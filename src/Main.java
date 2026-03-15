import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionPedidos gestor = new GestionPedidos();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        System.out.println("--- BIENVENIDO A PIZZA-TRACK (IU DIGITAL) ---");

        while (opcion != 0) {
            System.out.println("\nMENÚ DE GESTIÓN:");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual (Peek)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        gestor.registrarPedido();
                        break;
                    case 2:
                        gestor.undo();
                        break;
                    case 3:
                        gestor.redo();
                        break;
                    case 4:
                        gestor.mostrarActual();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema... ¡Buen turno!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
        sc.close();
    }
}