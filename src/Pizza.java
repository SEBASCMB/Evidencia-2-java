import java.util.Arrays;

public class Pizza {

  private String nombre;
  private String[] ingredientes;

  public Pizza(String nombre, String[] ingredientes) {
    this.nombre       = nombre;
    this.ingredientes = ingredientes;
  }

  @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: " + Arrays.toString(ingredientes);
    }

}
