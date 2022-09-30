import java.util.Arrays;
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
        intentosUsuario(palabraSeleccionada,largo);
    }

    public static String leerIngresoUsuario(){
        Scanner leerIngresoUsuario = new Scanner(System.in);
        String ingresoUsuario = leerIngresoUsuario.nextLine();
        return ingresoUsuario;
    }
    public static boolean esUnNumero(String ingresoUsuario){
        try{
            int number = Integer.parseInt(ingresoUsuario);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    public static boolean esUnaSolaLetra(String ingresoUsuario){
        int largo = ingresoUsuario.length();
        if(largo==1){
            return true;
        }else{
            return false;
        }
    }
    public static String validarIngresoUsuario(){
        String ingresoUsuario="";
        try{
            System.out.println("Ingrese una letra:");
            ingresoUsuario=leerIngresoUsuario();
        }catch(Exception e){
            System.out.println("Error, intente nuevamente:");
            validarIngresoUsuario();
        }finally {
            boolean esNumero = esUnNumero(ingresoUsuario);
            if (esNumero==true){
                System.out.println("Error, no se permiten números");
                validarIngresoUsuario();
            }
            boolean soloUnaLetra = esUnaSolaLetra(ingresoUsuario);
            if (soloUnaLetra==false){
                System.out.println("Error, debe ingresar solo una letra");
                validarIngresoUsuario();
            }
        }
        return ingresoUsuario;
    }
    public static String[] asignarPalabras(){
        String [] palabras = new String[10];
        palabras[0] = "dinamarca";
        palabras[1] = "enfurecer";
        palabras[2] = "curar";
        palabras[3] = "cambio";
        palabras[4] = "sufrir";
        palabras[5] = "virgen";
        palabras[6] = "aldea";
        palabras[7] = "roce";
        palabras[8] = "vampiro";
        palabras[9] = "involuntario";
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
    public static char respuestaUsuario(int largo){
        String respuestaUsuario = validarIngresoUsuario();
        String respuestaSinMayusculas = respuestaUsuario.toLowerCase();
        char letraRespuesta = respuestaSinMayusculas.charAt(0);
        return letraRespuesta;
    }
    public static char[] crearArregloRespuesta(int largo){
        char[] respuestas = new char[largo];
        for(int i = 0; i<largo; i++){
            respuestas [i] = '_';
        }
        return respuestas;
    }
    public static void intentosUsuario(String palabraSeleccionada, int largo){
        char[] letrasRespuestas = crearArregloRespuesta(largo);
        char[] letrasPalabra = palabraSeleccionada.toCharArray();
        int intento=1;
        do{
            char letraRespuesta = respuestaUsuario(largo);
            for(int i = 0; i<largo; i++){
                boolean aciertos = validarAciertos(i,letraRespuesta,letrasPalabra);
                if(aciertos==true){
                    letrasRespuestas[i] = letraRespuesta;
                }
            }
            mostrarRespuesta(letrasRespuestas,largo);
            System.out.println(" ");
            System.out.println("Le quedan: "+(10-intento)+" intentos");
            intento++;
            boolean respuestaCorrecta = verificarRespuestaCompleta(letrasRespuestas,letrasPalabra);
            if(respuestaCorrecta==true){
                break;
            }
        }while(intento<=10);
        System.out.println("Juego Finalizado");
    }
    public static void mostrarRespuesta(char[] letrasRespuestas, int largo){
        for(int i = 0; i<largo; i++){
            System.out.print(letrasRespuestas[i]);
        }
    }
    public static boolean validarAciertos(int i, char letraRespuesta, char[] letrasPalabra){
        if(letraRespuesta==letrasPalabra[i]){
            return true;
        }else{
            return false;
        }
    }
    public static boolean verificarRespuestaCompleta(char[] letrasRespuestas, char[] letrasPalabra){
        if(Arrays.equals(letrasRespuestas,letrasPalabra)){
            System.out.println("Respuesta Correcta");
            return true;
        }else{
            return false;
        }
    }
}
