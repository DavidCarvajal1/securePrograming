import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class Escribir
{
    private static final String contraseña  = "MeLlamoSpiderman";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el texto a escribir: ");
        String texto = sc.nextLine();
        Key clave=FuncionalidadRelativa.obtenerClave(contraseña);
        FuncionalidadRelativa.encriptar(texto, clave);
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("textoEncriptado.txt"))){
            bw.write(FuncionalidadRelativa.encriptar(texto, clave));
        }catch (IOException e){
            System.err.println("Error al escribir el archivo");
            e.printStackTrace();
        }
    }
}
