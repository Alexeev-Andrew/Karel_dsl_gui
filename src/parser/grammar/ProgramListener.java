// Generated from D:/projects/education/tuke/KarelDSL/src/parser_grammar\Program.g4 by ANTLR 4.9.2
package parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProgramParser}.
 */
public interface ProgramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProgramParser#programm}.
	 * @param ctx the parse tree
	 */
	void enterProgramm(ProgramParser.ProgrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#programm}.
	 * @param ctx the parse tree
	 */
	void exitProgramm(ProgramParser.ProgrammContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(ProgramParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(ProgramParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(ProgramParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(ProgramParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(ProgramParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(ProgramParser.Logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(ProgramParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(ProgramParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(ProgramParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(ProgramParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ProgramParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ProgramParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(ProgramParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(ProgramParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#command_sequence}.
	 * @param ctx the parse tree
	 */
	void enterCommand_sequence(ProgramParser.Command_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#command_sequence}.
	 * @param ctx the parse tree
	 */
	void exitCommand_sequence(ProgramParser.Command_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ProgramParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ProgramParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ProgramParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ProgramParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ProgramParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ProgramParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(ProgramParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(ProgramParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(ProgramParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(ProgramParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(ProgramParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(ProgramParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(ProgramParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(ProgramParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#parametersDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParametersDeclaration(ProgramParser.ParametersDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#parametersDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParametersDeclaration(ProgramParser.ParametersDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(ProgramParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(ProgramParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ProgramParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ProgramParser.FunctionCallContext ctx);
}