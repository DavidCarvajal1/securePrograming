import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class FuncionalidadRelativa {
    private static final String ALGORITMO = "AES/ECB/PKCS5Padding";
    public static Key obtenerClave(String contraseña) {
        //Creamos la clave. Al ser el algoritmo AES tenemos que indicarle la longitud del bloque
        // La longitud puede ser 16
        // La longitud de la contraseña tiene que coincidir con la longitud indicada
        return new SecretKeySpec(contraseña.getBytes(), 0, 16, "AES");
    }

    public static String encriptar(String texto, Key clave) {
        String salida="";
        try {
            // 2 - Crear un Cipher
            Cipher cipher = Cipher.getInstance(ALGORITMO);

            // 3 - Iniciar el cifrado con la clave
            cipher.init(Cipher.ENCRYPT_MODE, clave);

            // 4 - Llevar a cabo el cifrado
            byte[] cipherText = cipher.doFinal(texto.getBytes());

            // Imprimimos el mensaje cifrado en Base 64:
            salida=Base64.getEncoder().encodeToString(cipherText);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("La clave utilizada no es válida");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("El tamaño del bloque elegido no es correcto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El padding seleccionado no es correcto");
            e.printStackTrace();
        }catch (NoSuchPaddingException e){
            System.err.println("El padding seleccionado no existe");
            e.printStackTrace();
        }
        return salida;
    }
    public static String desencriptar(String textoEncriptado, Key clave){
        String salida="";
        try {
            // 2 - Crear un Cipher
            Cipher cipher = Cipher.getInstance(ALGORITMO);

            // 3 - Iniciar el descifrado con la clave
            cipher.init(Cipher.DECRYPT_MODE, clave);

            // 4 - Llevar a cabo el descifrado
            byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));

            // Imprimimos el mensaje descifrado:
            salida=new String(plainText);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            System.err.println("El padding seleccionado no existe");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("La clave utilizada no es válida");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("El tamaño del bloque elegido no es correcto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El padding seleccionado no es correcto");
            e.printStackTrace();
        }
        return salida;
    }
}
