int _x = 1.8;
double exec (double);



double exec (double valor){
    int i = 10;

    while ((i >= 5) && (valor > 3.4))
        valor -= _x - i;

    return valor;

}
        

int main (void);

int main (void) {
    double y = 1, z = 3.5;
    for (_x = 5; _x < 10; _x = _x + 1)
        y = exec(y) + exec(z);
    if (y < 100) {
        y = y / 2;
    }
    else
        z = y + 5.5;

    return 0;
}