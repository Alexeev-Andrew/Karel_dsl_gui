// Generated from D:/projects/education/tuke/KarelDSL/src/parser_grammar\Program.g4 by ANTLR 4.9.2
package parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProgramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProgramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProgramParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(ProgramParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(ProgramParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(ProgramParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expression(ProgramParser.Logical_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(ProgramParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(ProgramParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ProgramParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(ProgramParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#command_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand_sequence(ProgramParser.Command_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ProgramParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ProgramParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ProgramParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(ProgramParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(ProgramParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#mainFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunction(ProgramParser.MainFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ProgramParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#parametersDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersDeclaration(ProgramParser.ParametersDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(ProgramParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ProgramParser.FunctionCallContext ctx);
}