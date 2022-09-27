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
    public static String validarIngresoUsuario(int largo){
        String ingresoUsuario="";
        try{
            System.out.println("Ingrese su respuesta:");
            ingresoUsuario=leerIngresoUsuario();
            validarLargoDeLaRespuesta(ingresoUsuario, largo);
            validarQueRespuestaNoTengaNumeros(ingresoUsuario, largo);
        }catch(Exception e){
            System.out.println("Error, Ingrese nuevamente:");
            validarIngresoUsuario(largo);
        }

        return ingresoUsuario;
    }
    public static void validarLargoDeLaRespuesta(String ingresoUsuario, int largo){
        int largoRespuesta = ingresoUsuario.length();
        if (largoRespuesta!=largo){
            System.out.println("Error, Ingrese una palabra de: "+largo+" letras");
            validarIngresoUsuario(largo);
        }
    }
    public static void validarQueRespuestaNoTengaNumeros(String ingresoUsuario, int largo){
        if(!ingresoUsuario.substring(0, largo).matches("[a-z]*")){
            System.out.println("Error, Ingrese solo Letras");
            validarIngresoUsuario(largo);
        }
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
    public static void intentosUsuario(String palabraSeleccionada, int largo){
        char[] letrasPalabra = palabraSeleccionada.toCharArray();
        int intento=1;
        do{
            String respuesta = validarIngresoUsuario(largo);
            char[] letrasRespuesta = respuesta.toCharArray();
            if(Arrays.equals(letrasPalabra,letrasRespuesta)){
                System.out.println("La respuesta es correcta");
                break;
            }else{
                for(int i = 0; i<largo; i++){
                    validarAciertos(i,letrasRespuesta,letrasPalabra);
                }
                System.out.println("Respuesta incorrecta | Intentos restantes: "+(10-intento));
                intento++;
            }
        }while(intento<=10);
        System.out.println("Se acabaron los intentos");
    }
    public static void validarAciertos(int i, char[] letrasRespuesta, char[] letrasPalabra){
        if(letrasRespuesta[i]==letrasPalabra[i]){
            System.out.println("Letra "+letrasRespuesta[i]+" correcta");
        }else{
            System.out.println("Letra "+letrasRespuesta[i]+" incorrecta");
        }
    }
}
