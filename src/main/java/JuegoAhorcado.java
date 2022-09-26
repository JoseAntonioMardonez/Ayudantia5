import java.util.Scanner;

public class JuegoAhorcado {
    public static void main(String[] args){
        inicializar();
    }
    public static void inicializar(){
        String[] palabras = new String[10];
        palabras=asignarPalabras();
        String palabraSeleccionada = seleccionarPalabra(palabras);
        int largo = largoDeLaPalabra(palabraSeleccionada);
        respuestaUsuario(largo);


    }

    public static String leerIngresoUsuario(){
        Scanner leerIngresoUsuario = new Scanner(System.in);
        String ingresoUsuario = leerIngresoUsuario.nextLine();
        return ingresoUsuario;
    }
    public static String[] asignarPalabras(){
        String [] palabras = new String[10];
        palabras[0] = "Dinamarca";
        palabras[1] = "Enfurecer";
        palabras[2] = "Curar";
        palabras[3] = "Cambio";
        palabras[4] = "Sufrir";
        palabras[5] = "Virgen";
        palabras[6] = "Aldea";
        palabras[7] = "Roce";
        palabras[8] = "Vampiro";
        palabras[9] = "Involuntario";
        return palabras;
    }
    public static String seleccionarPalabra(String[] palabras){
        int numeroAzar = (int)((Math.random()*10)+1);
        System.out.println("Palabra numero: "+numeroAzar);
        return palabras[numeroAzar-1];
    }
    public static int largoDeLaPalabra(String palabra){
        int largoPalabra = palabra.length();
        System.out.println("El largo de la palabra es: "+largoPalabra);
        return largoPalabra;
    }
    public static void intentosUsuario(){

    }
    public static void respuestaUsuario(int largo){
        char[] respuesta = new char[largo];
    }

}
