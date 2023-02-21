import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Elija una opcion: ");
            System.out.println("1. Escribir");
            System.out.println("2. Leer");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Escribir.main(args);
                    break;
                case 2:
                    Leer.main(args);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while (opcion!=0);
    }
}
