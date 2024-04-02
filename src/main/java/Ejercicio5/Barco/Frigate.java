package Ejercicio5.Barco;

public class Frigate extends Barco {

    public Frigate() {
        super(3); // Tamaño fijo de 3 posiciones
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