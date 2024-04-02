package Ejercicio5.Barco;

public class Battleship extends Barco {
    private boolean[] contenedores;

    public Battleship() {
        super(5); // Tamaño fijo de 5 posiciones
        contenedores = new boolean[5]; // Inicialmente todos los contenedores están intactos
        for (int i = 0; i < 5; i++) {
            contenedores[i] = true;
        }
    }

    @Override
    public boolean atacar(int posicion) {
        if (posicion >= 0 && posicion < 5) {
            if (contenedores[posicion]) {
                contenedores[posicion] = false; // Marcar el contenedor como destruido
                if (esHundido()) {
                    setHundido(true); // Marcar el barco como hundido si todos los contenedores han sido destruidos
                    return true;
                }
            }
        }
        return false; // Devolver false si el ataque no impactó en el barco o si el barco no fue hundido
    }

    private boolean esHundido() {
        for (boolean contenedor : contenedores) {
            if (contenedor) {
                return false; // Si hay al menos un contenedor intacto, el barco no está hundido
            }
        }
        return true; // Si todos los contenedores están destruidos, el barco está hundido
    }
}
