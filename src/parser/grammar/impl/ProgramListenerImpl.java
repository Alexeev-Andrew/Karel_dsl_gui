package parser.grammar.impl;

import com.sun.org.apache.xpath.internal.operations.And;
import gui.GUI;
import model.Program;
import model.commands.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.grammar.ProgramListener;
import parser.grammar.ProgramParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class ProgramListenerImpl implements ProgramListener {

    private Program program;

    private HashMap<String, Function> function_declarations;

    private Stack<Command> command_stack = new Stack<>();
    private Stack<LogicalExpression> expression_stack = new Stack<>();

    // GUI world
    private GUI world;

    public ProgramListenerImpl(GUI world){
        this.world = world;
    }

    @Override
    public void enterProgramm(ProgramParser.ProgrammContext ctx) {
        command_stack.push(new ActionSequence());
        function_declarations = new HashMap<>();
    }

    @Override
    public void exitProgramm(ProgramParser.ProgrammContext ctx) {
        // check if stack has more than one object - if yes - collapse it into one action sequence
        collapseCommandStack(0);
        program = new Program((ActionSequence) command_stack.peek(), function_declarations);
    }

    @Override
    public void enterTitle(ProgramParser.TitleContext ctx) {

    }

    @Override
    public void exitTitle(ProgramParser.TitleContext ctx) {

    }

    @Override
    public void enterAction(ProgramParser.ActionContext ctx) {
//        System.out.println("ACTION!");
    }

    @Override
    public void exitAction(ProgramParser.ActionContext ctx) {
        Action curr_action = Action.getByKey(ctx.getText());
        command_stack.push(curr_action);
    }

    @Override
    public void enterLogical_expression(ProgramParser.Logical_expressionContext ctx) {
        // not needed
    }

    @Override
    public void exitLogical_expression(ProgramParser.Logical_expressionContext ctx) {
        Expression curr_expression = Expression.getByKey(ctx.getText());
        if(expression_stack.empty()){
            // it's a part of while/if
            return;
        }
        // else - part of expression (or/and)
        LogicalExpression last_ex = expression_stack.peek();

        if(last_ex instanceof AndOrExpression){
            AndOrExpression ex = (AndOrExpression) last_ex;
            if(ex.getType() == AndOrExpression.Type.AND){
                // AND
                ex.getExpressions().add(curr_expression);
            } else {
                // OR now provides no logic, because we always have AND expression
            }
        }
    }

    @Override
    public void enterLogicalOrExpression(ProgramParser.LogicalOrExpressionContext ctx) {
        // add new Or block into expression_stack
        expression_stack.push(new AndOrExpression(AndOrExpression.Type.OR));
    }

    @Override
    public void exitLogicalOrExpression(ProgramParser.LogicalOrExpressionContext ctx) {
//        AndOrExpression curr = (AndOrExpression) expression_stack.peek();
        // not needed
    }

    @Override
    public void enterLogicalAndExpression(ProgramParser.LogicalAndExpressionContext ctx) {
        // add new And block into expression_stack
        expression_stack.push(new AndOrExpression(AndOrExpression.Type.AND));
    }

    @Override
    public void exitLogicalAndExpression(ProgramParser.LogicalAndExpressionContext ctx) {
        AndOrExpression curr = (AndOrExpression) expression_stack.pop();
        AndOrExpression curr_or_exp = (AndOrExpression) expression_stack.peek();
        curr_or_exp.getExpressions().add(curr);
    }

    @Override
    public void enterExpression(ProgramParser.ExpressionContext ctx) {
        // not used now
    }

    @Override
    public void exitExpression(ProgramParser.ExpressionContext ctx) {
        // not used now
    }

    @Override
    public void enterCommand(ProgramParser.CommandContext ctx) {
        // not used now
    }

    @Override
    public void exitCommand(ProgramParser.CommandContext ctx) {
        // not used now
    }

    @Override
    public void enterCommand_sequence(ProgramParser.Command_sequenceContext ctx) {
        // not used now
    }

    @Override
    public void exitCommand_sequence(ProgramParser.Command_sequenceContext ctx) {
        // not used now
    }

    @Override
    public void enterForStatement(ProgramParser.ForStatementContext ctx) {
        // add new ForLoop to stack
        ForLoop forloop = new ForLoop(Integer.valueOf(ctx.NUMBER().getText()));
        command_stack.push(forloop);
    }

    @Override
    public void exitForStatement(ProgramParser.ForStatementContext ctx) {
        // pop commands from stack until get ForLoop obj, add all commands to sequence
        ArrayList<Command> commands = new ArrayList<>();
        while(!command_stack.isEmpty() && (!(command_stack.peek() instanceof ForLoop))){
            commands.add(command_stack.pop());
        }
        // something went wrong
        if(command_stack.empty())
            return;

        Collections.reverse(commands);
        if(command_stack.peek() instanceof ForLoop)
            ((ForLoop) command_stack.peek()).getBody_actions().add(commands);

        // now we need to fix nesting for/while loops
        collapseCommandStack(1);
    }

    @Override
    public void enterWhileStatement(ProgramParser.WhileStatementContext ctx) {
        // add new WhileLoop to stack
        command_stack.push(new WhileLoop());
    }

    @Override
    public void exitWhileStatement(ProgramParser.WhileStatementContext ctx) {
        // pop commands from stack until get ForLoop obj, add all commands to sequence
        ArrayList<Command> commands = new ArrayList<>();
        while(!command_stack.isEmpty() && (!(command_stack.peek() instanceof WhileLoop))){
            commands.add(command_stack.pop());
        }
        // something went wrong
        if(command_stack.empty())
            return;

        if(command_stack.peek() instanceof WhileLoop) {
            Collections.reverse(commands);
            ((WhileLoop) command_stack.peek()).getBody_actions().add(commands);

            // add condition from logical expression stack
            if(!expression_stack.empty())
                ((WhileLoop) command_stack.peek()).setCondition(expression_stack.pop());
        }

        // now we need to fix nesting for/while loops
        collapseCommandStack(1);

    }

    @Override
    public void enterIfStatement(ProgramParser.IfStatementContext ctx) {
        // add new IfCommand to stack
        command_stack.push(new IfCommand());
    }

    @Override
    public void exitIfStatement(ProgramParser.IfStatementContext ctx) {
        // pop commands from stack until get ForLoop obj, add all commands to sequence
        ArrayList<Command> commands = new ArrayList<>();
        while(!command_stack.isEmpty() && (!(command_stack.peek() instanceof IfCommand))){
            commands.add(command_stack.pop());
        }
        // something went wrong
        if(command_stack.empty())
            return;

        if(command_stack.peek() instanceof IfCommand){
            Collections.reverse(commands);
            ((IfCommand) command_stack.peek()).getBody_actions().add(commands);
            // add condition from logical expression stack
            if(!expression_stack.empty())
                ((IfCommand) command_stack.peek()).setCondition(expression_stack.pop());
        }


        // now we need to fix nesting for/while loops
        collapseCommandStack(1);
    }

    @Override
    public void enterTypeSpecifier(ProgramParser.TypeSpecifierContext ctx) {

    }

    @Override
    public void exitTypeSpecifier(ProgramParser.TypeSpecifierContext ctx) {

    }

    @Override
    public void enterFunctionDefinition(ProgramParser.FunctionDefinitionContext ctx) {
        command_stack.push(new ActionSequence());
    }

    @Override
    public void exitFunctionDefinition(ProgramParser.FunctionDefinitionContext ctx) {
       //  curr_function_declaration = new Function(ctx.F_Name().getText(), curr_parameters, curr_action_sequence);

        // pop commands from stack until get ActionSequence obj, add all commands to sequence
        ArrayList<Command> commands = new ArrayList<>();
        while(!command_stack.isEmpty() && (!(command_stack.peek() instanceof ActionSequence))){
            commands.add(command_stack.pop());
        }
        // something went wrong
        if(command_stack.empty())
            return;

        if(command_stack.peek() instanceof ActionSequence){
            ((ActionSequence) command_stack.peek()).add(commands);
            // add new function to function hash map
            function_declarations.put(ctx.F_Name().getText(), new Function(null, (ActionSequence) command_stack.peek()));
        }

    }

    @Override
    public void enterMainFunction(ProgramParser.MainFunctionContext ctx) {

    }

    @Override
    public void exitMainFunction(ProgramParser.MainFunctionContext ctx) {
        // todo:
    }

    @Override
    public void enterParameters(ProgramParser.ParametersContext ctx) {

    }

    @Override
    public void exitParameters(ProgramParser.ParametersContext ctx) {

    }

    @Override
    public void enterParametersDeclaration(ProgramParser.ParametersDeclarationContext ctx) {

    }

    @Override
    public void exitParametersDeclaration(ProgramParser.ParametersDeclarationContext ctx) {

    }

    @Override
    public void enterExpressionList(ProgramParser.ExpressionListContext ctx) {

    }

    @Override
    public void exitExpressionList(ProgramParser.ExpressionListContext ctx) {

    }

    @Override
    public void enterFunctionCall(ProgramParser.FunctionCallContext ctx) {

    }

    @Override
    public void exitFunctionCall(ProgramParser.FunctionCallContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public Program getProgram(){
        return program;
    }


    private void collapseCommandStack(int nesting_level){
        // we will go through the stack and find first actionSequence/forLoop/while/if objects.
        // And add all objects that go after into it's body
        ArrayList<Command> commands_nesting = new ArrayList<>();
        int cur_nesting = 0;
        while(!command_stack.empty()){
            Command last_command = command_stack.pop();
            if(last_command instanceof CommandWithBody){
                // reverse becausse we used stack
                Collections.reverse(commands_nesting);
                // add all commands to it's body
                ((CommandWithBody) last_command).add(commands_nesting);
                if(cur_nesting == nesting_level){
                    // save object to stack and return
                    command_stack.push(last_command);
                    break;
                }
                else {
                    commands_nesting.clear();
                    commands_nesting.add(last_command);
                    ++cur_nesting;
                }

            } else {
                commands_nesting.add(last_command);
            }
        }
    }
}
