package Ejercicio7;

import java.util.HashMap;

public class AlgoritmoTablasHash {

    // Definición de las tres tablas hash
    private HashMap<String, HashMap<Integer, Barco>> tablaTipoBarco;  // Hash sobre el tipo de barco
    private HashMap<Integer, HashMap<Integer, Barco>> tablaNumeroBarco;  // Hash sobre el número del barco
    private HashMap<String, HashMap<Integer, Barco>> tablaNombreBarco;  // Hash sobre el nombre del barco
    // Hash sobre el nombre del barco

    public AlgoritmoTablasHash() {
        tablaTipoBarco = new HashMap<>();
        tablaNumeroBarco = new HashMap<>();
        tablaNombreBarco = new HashMap<>();
    }

    // Método para cargar un barco en las tablas hash
    public void cargarBarco(Barco barco) {
        // Cargar en la primera tabla hash basada en el tipo de barco
        String tipo = barco.getTipo();
        if (!tablaTipoBarco.containsKey(tipo)) {
            tablaTipoBarco.put(tipo, new HashMap<>());
        }
        tablaTipoBarco.get(tipo).put(barco.getNumero(), barco);

        // Cargar en la segunda tabla hash basada en el número del barco
        if (!tablaNumeroBarco.containsKey(barco.getNumero())) {
            tablaNumeroBarco.put(barco.getNumero(), new HashMap<>());
        }
        tablaNumeroBarco.get(barco.getNumero()).put(barco.getNivel(), barco);

        // Cargar en la tercera tabla hash basada en el nombre del barco
        String nombre = barco.getNombre();
        if (!tablaNombreBarco.containsKey(nombre)) {
            tablaNombreBarco.put(nombre, new HashMap<>());
        }
        tablaNombreBarco.get(nombre).put(barco.getNumero(), barco);

    }

    // Clase Barco
    static class Barco {
        private int numero;
        private String nombre;
        private String tipo;
        private int nivel;

        public Barco(int numero, String nombre, String tipo, int nivel) {
            this.numero = numero;
            this.nombre = nombre;
            this.tipo = tipo;
            this.nivel = nivel;
        }

        public int getNumero() {
            return numero;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public int getNivel() {
            return nivel;
        }
    }

    public static void main(String[] args) {
        // Crear una instancia del algoritmo de tablas hash
        AlgoritmoTablasHash algoritmo = new AlgoritmoTablasHash();

        // Ejemplo de carga de un barco
        Barco barco1 = new Barco(123, "Barco1", "Tipo1", 1);
        algoritmo.cargarBarco(barco1);
    }
}
