import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class Leer {
    private static final String contraseña  = "MeLlamoSpiderman";
    public static void main(String[] args) {
        String textoEncriptado="";
        Key clave=FuncionalidadRelativa.obtenerClave(contraseña);
        try(BufferedReader br=new BufferedReader(new FileReader("textoEncriptado.txt"))) {
            textoEncriptado = br.readLine();
        }catch (FileNotFoundException e){
            System.err.println("Error no se encuentra el archivo");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error al leer el archivo");
            e.printStackTrace();
        }
        System.out.println(FuncionalidadRelativa.desencriptar(textoEncriptado, clave));
    }
}
