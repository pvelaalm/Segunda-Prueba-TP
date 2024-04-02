package Ejercicio5.Cuadricula;



import Ejercicio5.Barco.Barco;
import Ejercicio5.Barco.Battleship;
import Ejercicio5.Barco.Canoe;
import Ejercicio5.Barco.Frigate;

import java.util.Random;
import java.util.Scanner;

public class CuadriculaVirtual {
    private char[][] tableroHumano;
    private char[][] tableroComputadora;
    private int filas;
    private int columnas;
    private Random rand;
    private Scanner scanner;
    private Barco[] barcosHumano;
    private Barco[] barcosComputadora;

    public CuadriculaVirtual(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tableroHumano = new char[filas][columnas];
        tableroComputadora = new char[filas][columnas];
        rand = new Random();
        scanner = new Scanner(System.in);
        inicializarTablero(tableroHumano);
        inicializarTablero(tableroComputadora);
        inicializarBarcos();
    }

    private void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private void inicializarBarcos() {
        barcosHumano = new Barco[]{new Battleship(), new Frigate(), new Canoe()};
        barcosComputadora = new Barco[]{new Battleship(), new Frigate(), new Canoe()};
    }

    public void mostrarTableroHumano() {
        System.out.println("Tablero del humano:");
        mostrarTablero(tableroHumano);
    }

    public void mostrarTableroComputadora() {
        System.out.println("Tablero de la computadora:");
        mostrarTablero(tableroComputadora);
    }

    private void mostrarTablero(char[][] tablero) {
        System.out.print("  ");
        for (int i = 0; i < columnas; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void turnoHumano() {
        System.out.println("Turno del humano:");
        System.out.print("Ingrese fila: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna: ");
        int columna = scanner.nextInt();
        disparar(tableroComputadora, fila, columna);
    }

    public void turnoComputadora() {
        System.out.println("Turno de la computadora:");
        int fila = rand.nextInt(filas);
        int columna = rand.nextInt(columnas);
        disparar(tableroHumano, fila, columna);
    }

    private void disparar(char[][] tablero, int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            if (tablero[fila][columna] == '-') {
                System.out.println("Agua...");
                tablero[fila][columna] = 'O';
            } else {
                for (Barco barco : barcosHumano) {
                    if (!barco.isHundido() && barco.atacar(fila * columnas + columna)) {
                        System.out.println("¡Impacto!");
                        tablero[fila][columna] = 'X';
                        if (barco.isHundido()) {
                            System.out.println("¡Hundido!");
                        }
                        return;
                    }
                }
                System.out.println("Ya se ha disparado aquí.");
            }
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    public boolean humanoDerrotado() {
        for (Barco barco : barcosHumano) {
            if (!barco.isHundido()) {
                return false; // Si hay al menos un barco no hundido, el humano no está derrotado
            }
        }
        return true; // Si todos los barcos están hundidos, el humano está derrotado
    }

    public boolean computadoraDerrotada() {
        for (Barco barco : barcosComputadora) {
            if (!barco.isHundido()) {
                return false; // Si hay al menos un barco no hundido, la computadora no está derrotada
            }
        }
        return true; // Si todos los barcos están hundidos, la computadora está derrotada
    }
}
