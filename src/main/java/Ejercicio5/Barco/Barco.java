package Ejercicio5.Barco;

public abstract class Barco {
    private int tamaño;
    private boolean hundido;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.hundido = false;
    }

    public abstract boolean atacar(int posicion);

    public int getTamaño() {
        return tamaño;
    }

    public boolean isHundido() {
        return hundido;
    }

    protected void setHundido(boolean hundido) {
        this.hundido = hundido;
    }
}