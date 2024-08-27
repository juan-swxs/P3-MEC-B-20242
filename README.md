
public class Fraccion {

    private int numerador, denominador;

    public Fraccion(){

    }

    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;

    }

     void getdividir(){

     }

    void getdividir(int numerador,int denominador){
        int a = numerador/denominador;

        System.out.println(a);

    }

    void setcambiar_valores(int numerador, int denominador){
        this.numerador = 5;
        this.denominador = 4;

    }


    public static void main(String[] args) {

        Fraccion fraccion = new Fraccion();

        fraccion.getdividir(0, 0);
        fraccion.setcambiar_valores(0, 0);
        fraccion.getdividir();
        
    }
    
}
