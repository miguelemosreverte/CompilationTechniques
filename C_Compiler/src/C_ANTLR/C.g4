grammar C;


/** The start rule; begin parsing here. */
prog:   stat+ ; 

stat:  f_d
    |  for_loop
    |  while_loop
    |  if_condition
    |  f_p  ';'
    |  variable_declaration ';'
    |  assignation ';'
    |  ret ';'
    |  f_c ';'
    ;






//=======================================================
//THINGS that end with semicolon

ret : 'return' to_value;

// f_p <-- function_prototype
f_p : VALID_C_TYPES ID '(' parametersList? ')' ; 

//=======================================================
//THINGS that end with code_block or stat

for_loop : 'for' '(' (assignation|ID) ';' comparation ';' assignation ')' (code_block|stat);

while_loop : 'while' '(' logic_op ')' (code_block|stat);

if_condition : 'if' '(' logic_op ')' (code_block|stat) else_condition?;
else_condition : 'else' ('(' logic_op ')')? (code_block|stat) ;

// f_d <-- function_declaration
f_d : VALID_C_TYPES ID '(' parametersList? ')' code_block ; 

//=======================================================
//THINGS that don't end with semicolon
             
code_block : '{' stat* '}' ;


//=======================================================
//COMPOSED EXPRESSIONS
// (compositing to parse rules allows for a finer granularity,
//   ie.: using specifically INT for the type of the FOR indexes
//        or DIGIT for math operations)
assign_op  :   EQUAL|OTHER_ASSIGN_OPS;
string : CHAR;    

// f_c <-- function_call
f_c : ID '(' inputParametersList ')';  

variable_declaration : VALID_C_TYPES ID (EQUAL to_value)? (',' VALID_C_TYPES? ID (EQUAL to_value)?)*;

//=======================================================
//THINGS that are really reusable (they don't end with semicolon either)
to_value : ID | digit | string | f_c | math_operation; 
comparation : to_value COMPARACION to_value;
logic_op : '('? comparation ')'? (LOGIC_OP logic_op)?;
assignation : ID (assign_op to_value) | ID INCR_DECR;

//=======================================================
//and here comes math, it was neccesary to improve the grammar to
//make priorities among the operators
/*

math_operation : '('? math_operator (math_operation_high | math_operation_medium | math_operation_low)+ ')'? ;
math_operation_high :  (MATH_OP_HIGH_PRIORITY math_operator)+;
math_operation_medium :  (MATH_OP_HIGH_PRIORITY math_operator)+;
math_operation_low :  (MATH_OP_HIGH_PRIORITY math_operator)+;
math_operator: digit|ID|f_c;

MATH_OP_HIGH_PRIORITY : '*'| '/';
MATH_OP_MEDIUM_PRIORITY : '^';
MATH_OP_LOW_PRIORITY : '-'|'+';


*/





unapplied : (low_op|medium_op|high_op) ;

low_op :  (MATH_OP_LOW_PRIORITY math_operation);
medium_op :  (MATH_OP_MEDIUM_PRIORITY math_operation);
high_op :  (MATH_OP_HIGH_PRIORITY math_operation);


math_operation : math_operand unapplied?;
math_operand : digit|ID|f_c|grouped ;
grouped : '(' math_operation ')';


MATH_OP_MEDIUM_PRIORITY : '*'| '/';
MATH_OP_HIGH_PRIORITY : '^';
MATH_OP_LOW_PRIORITY : '-'|'+';



digit : integer | floating_point;    
integer : INT;    
floating_point : FLOAT;  






//=======================================================
//COMMA SEPARATED VALUES
parametersList : VALID_C_TYPES (',' VALID_C_TYPES)*
               | variable_declaration
               | parametersList ',' parametersList;

inputParametersList : to_value
               | inputParametersList ',' inputParametersList
               | ;



ENDLINE  :   [ \n\r\t] -> skip ;  

EQUAL : '=';
OTHER_ASSIGN_OPS : '*='|'+='|'-='|'/=';
INCR_DECR : '--'|'++';
COMPARACION  : '=='|'>''='?|'<''='?;
LOGIC_OP : '||'|'&&'|'!';
VALID_C_TYPES : 'int'|'INT'|'float'|'FLOAT'|'double'|'DOUBLE'|'char'|'CHAR'|'void'|'VOID';  
ID  :   (ALPHABET|VALID_ID_SIMBOLS)+; 

INT :   [0-9]+ ;      
FLOAT :   ([0-9]+) '.' ([0-9]+) ; 
CHAR : '"' CHARS_ '"' | '\'' CHARS_ '\'';

fragment CHARS_ : (ALPHABET | VALID_ID_SIMBOLS | INT | FLOAT | ' ' )*;
fragment ALPHABET : [a-zA-Z]+;
fragment VALID_ID_SIMBOLS : '_'; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
