grammar Program;


programm : functionDefinition* mainFunction functionDefinition*;
//programm : (action)+;

title : STRING;

action  : 'move()'
        | 'turnLeft()'
        | 'pickBeeper()'
        | 'putBeeper()'
        ;

logical_expression  : 'frontIsClear()'
            | 'frontIsBlocked()'
            | 'leftIsClear()'
            | 'leftIsBlocked()'
            | 'rightIsClear()'
            | 'rightIsBlocked()'
            | 'beepersPresent()'
            | 'facingNorth()'
            | 'facingEast()'
            | 'facingSouth()'
            | 'facingWest()'
            | 'true'
            | 'false'
            ;

logicalOrExpression:
    logicalAndExpression (Or logicalAndExpression)*
;

logicalAndExpression :
    logical_expression (And logical_expression)*
;


expression :
      logicalOrExpression
    | NUMBER
    | STRING
    ;

command : action
                | forStatement
                | whileStatement
                | ifStatement
                | functionCall
//                | function
                ;

command_sequence : command+;

forStatement : 'for' '(' NUMBER ')' '{' command_sequence '}';

whileStatement : 'while' '(' logicalOrExpression ')' '{' command_sequence '}';

ifStatement : 'if' '(' logicalOrExpression ')' '{' command_sequence '}';

//function : 'function' STRING '()' '{' command_sequence '}';

// Function Start

typeSpecifier:
    (
          Char
        | Bool
        | Int
        | Void
        | String
    )
    ;

functionDefinition:
    Function? typeSpecifier F_Name parameters '{' command_sequence '}';

mainFunction :
    'main' '(' ')'  '{' command_sequence '}';

parameters :
    '(' parametersDeclaration? ')';

parametersDeclaration :
    typeSpecifier P_Name (',' typeSpecifier P_Name)*;


expressionList:
	expression (
		',' expression
	)*
	;

functionCall :
    F_Name '(' expressionList? ')';

// Function End


F_Name  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;

P_Name : [a-zA-Z_] [a-zA-Z0-9_]*;

BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~ [\r\n]* -> skip;

NUMBER : [1-9]+[0-9]*;

// string constants
Bool: 'bool' | 'boolean';
Char: 'char';
Int: 'int';
String: 'String';
Void: 'void';
Function: 'func' | 'function';
Or : '||';
And : '&&';



STRING : '"' .*? '"';
WS : [ \r\t\n]+ -> skip;
EndOfFile : EOF -> skip;
