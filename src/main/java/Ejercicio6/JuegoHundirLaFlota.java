package Ejercicio6;
import Ejercicio5.Cuadricula.CuadriculaVirtual;

import java.util.Scanner;

public class JuegoHundirLaFlota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int filas = 4; // Tamaño del tablero
        int columnas = 4;

        // Crear cuadrículas para cada jugador
        CuadriculaVirtual cuadriculaJugador1 = new CuadriculaVirtual(filas, columnas);
        CuadriculaVirtual cuadriculaJugador2 = new CuadriculaVirtual(filas, columnas);

        // Configuración de barcos para el jugador 1
        configurarBarcos(scanner, cuadriculaJugador1);

        // Configuración de barcos para el jugador 2
        configurarBarcos(scanner, cuadriculaJugador2);

        // Comienzo del juego
        System.out.println("Comienza el juego de Hundir la Flota!");

        // Turnos alternados hasta que uno de los jugadores quede sin barcos
        while (true) {
            // Turno del jugador 1
            System.out.println("Turno del Jugador 1:");
            cuadriculaJugador1.turnoHumano();
            if (cuadriculaJugador2.humanoDerrotado()) {
                System.out.println("¡El Jugador 1 ha ganado!");
                break;
            }

            // Turno del jugador 2
            System.out.println("Turno del Jugador 2:");
            cuadriculaJugador2.turnoHumano();
            if (cuadriculaJugador1.humanoDerrotado()) {
                System.out.println("¡El Jugador 2 ha ganado!");
                break;
            }
        }

        scanner.close();
    }

    // Método para configurar los barcos en la cuadrícula del jugador
    private static void configurarBarcos(Scanner scanner, CuadriculaVirtual cuadricula) {
        System.out.println("Configuración de barcos para el jugador:");

        int barcosRestantes = 3; // Cada jugador tiene un máximo de tres barcos
        while (barcosRestantes > 0) {
            System.out.println("Barcos restantes: " + barcosRestantes);

            // Solicitar al usuario las coordenadas para el barco
            System.out.print("Introduce la fila para el barco (0-3): ");
            int fila = scanner.nextInt();
            System.out.print("Introduce la columna para el barco (0-3): ");
            int columna = scanner.nextInt();

            // Verificar si las coordenadas están dentro del rango del tablero
            if (fila >= 0 && fila < 4 && columna >= 0 && columna < 4) {
                // Colocar el barco en la cuadrícula
                cuadricula.turnoHumano();
                barcosRestantes--;
            } else {
                System.out.println("Coordenadas fuera de rango. Inténtalo de nuevo.");
            }
        }
    }
}
