package Ejercicio5.Barco;

public class Canoe extends Barco {

    public Canoe() {
        super(1); // Tamaño fijo de 1 posición
    }

    @Override
    public boolean atacar(int posicion) {
        if (!isHundido()) {
            setHundido(true); // Marcar el barco como hundido en el primer ataque
            return true;
        }
        return false; // Devolver false si el barco ya está hundido
    }
}