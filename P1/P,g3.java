//con la misma clase crear un metodo puro que me permita sumar 2 fracciones y que me devuelva el resultado

public class Fraccion {

    float numerador, denominador,x, y;

    float sumar(int numerador, int denominador, int x, int y){

        float a = (numerador/denominador) + (x/y);

        return a;

    }

    public static void main(String[] args) {

        Fraccion fraccion = new Fraccion();

        fraccion.sumar(4,5,6,7);
        
    }
    
}
