package Ejercicio5.Guerra;

import Ejercicio5.Cuadricula.CuadriculaVirtual;

public class GuerraDeBarcosAvanzada {
    public static void main(String[] args) {
        int filas = 4;
        int columnas = 4;

        CuadriculaVirtual cuadriculaHumano = new CuadriculaVirtual(filas, columnas);
        CuadriculaVirtual cuadriculaComputadora = new CuadriculaVirtual(filas, columnas);

        while (true) {
            cuadriculaHumano.mostrarTableroHumano();
            cuadriculaHumano.turnoHumano();
            if (cuadriculaHumano.computadoraDerrotada()) {
                System.out.println("¡Has ganado!");
                break;
            }

            cuadriculaComputadora.turnoComputadora();
            cuadriculaHumano.mostrarTableroHumano();
            if (cuadriculaHumano.humanoDerrotado()) {
                System.out.println("¡La computadora ha ganado!");
                break;
            }
        }
    }
}