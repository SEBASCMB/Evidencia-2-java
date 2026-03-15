import java.util.Scanner;

public class GestionPedidos {
    private Pila pilaPrincipal = new Pila();   // Para Undo
    private Pila pilaSecundaria = new Pila();  // Para Redo
    private Scanner sc = new Scanner(System.in);

    public void registrarPedido() {
        System.out.print("Nombre de la pizza: ");
        String nombre = sc.nextLine();
        String[] ingredientes = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredientes[i] = sc.nextLine();
        }
        
        pilaPrincipal.push(new Pizza(nombre, ingredientes));
        // Al registrar algo nuevo, la pila de Redo debe limpiarse
        while (!pilaSecundaria.isEmpty()) pilaSecundaria.pop();
        
        System.out.println("¡Pedido registrado!");
    }

    public void undo() {
        Pizza deshecha = pilaPrincipal.pop();
        if (deshecha != null) {
            pilaSecundaria.push(deshecha);
            System.out.println("Deshecho: " + deshecha);
        } else {
            System.out.println("No hay pedidos para deshacer.");
        }
    }

    public void redo() {
        Pizza recuperada = pilaSecundaria.pop();
        if (recuperada != null) {
            pilaPrincipal.push(recuperada);
            System.out.println("Rehecho: " + recuperada);
        } else {
            System.out.println("No hay nada que rehacer.");
        }
    }

    public void mostrarActual() {
        Pizza actual = pilaPrincipal.peek();
        if (actual != null) {
            System.out.println("En producción: " + actual);
        } else {
            System.out.println("No hay pedidos activos.");
        }
    }
}