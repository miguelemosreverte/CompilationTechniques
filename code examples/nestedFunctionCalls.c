
int nestedFunctionCalls(int, int);
int plusOne(int);

int plusOne(int a){
    return a + 1;
}

int nestedFunctionCalls(int x){


    plusOne(plusOne(plusOne(x)));


}

int a = 1;
a = nestedFunctionCalls(a);
