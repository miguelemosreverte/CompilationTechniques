# CompilationTechniques

3 warnings, one a Java Runtime Exception, the others a slap on the wrist by System.out.println, tell when a C code has the following problems:

* Undeclared variables

    This is achieved by setting up a stack of scopes
* String on integer initialization

    This is achieved by setting up a symbols table
* Floating-point on integer initialization

    Which is achieved by having said symbols table implemented along with sintax rules that ANTLR can work with: ANTLR only provides rulesContexts for each of the sintax rules, leaving the specifics of the lexical tokenization behind, and obscuring the nature of a digit, whether or not it is a floating-point number, by saying that it is just a digit.
    That is if using a syntax rule like the following:
      digit : FLOAT | INT;
    When it would be necessary for the third warning to have not 1, but 3 rulesContexts like this:
      digit : float | INT;
    where the uppercase words represent lexical rules and the lowercase ones represent sintax rules.

More on that on the documentation, found at /documentation.pdf

and examples at /code_examples, where the resulting PDFs files, along with the LaTEX ones used to construct them, can be found.
