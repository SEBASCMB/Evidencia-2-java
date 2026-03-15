public class Pila {
    private class Nodo {
        Pizza pizza;
        Nodo siguiente;

        Nodo(Pizza pizza) {
            this.pizza = pizza;
            this.siguiente = null;
        }
    }

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(Pizza nuevaPizza) {
        Nodo nuevoNodo = new Nodo(nuevaPizza);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public Pizza pop() {
        if (isEmpty()) return null;
        Pizza pizzaRetornada = tope.pizza;
        tope = tope.siguiente; // El tope ahora es el que estaba abajo
        return pizzaRetornada;
    }

    public Pizza peek() {
        return (isEmpty()) ? null : tope.pizza;
    }

    public boolean isEmpty() {
        return tope == null;
    }
}