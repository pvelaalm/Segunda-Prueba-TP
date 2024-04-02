package Ejercicio8;

import java.util.*;

public class GrafoNoDirigido {
    private Map<String, List<Arista>> grafo;

    public GrafoNoDirigido() {
        this.grafo = new HashMap<>();
    }

    public void agregarPuerto(String puerto) {
        grafo.put(puerto, new ArrayList<>());
    }

    public void agregarArista(String puerto1, String puerto2, int distancia) {
        Arista arista1 = new Arista(puerto2, distancia);
        Arista arista2 = new Arista(puerto1, distancia);
        grafo.get(puerto1).add(arista1);
        grafo.get(puerto2).add(arista2);
    }

    public void eliminarPuerto(String puerto) {
        grafo.remove(puerto);
        for (String p : grafo.keySet()) {
            Iterator<Arista> iterator = grafo.get(p).iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getDestino().equals(puerto)) {
                    iterator.remove();
                }
            }
        }
    }

    public void recorridoProfundidad(String inicio) {
        Set<String> visitados = new HashSet<>();
        dfs(inicio, visitados);
    }

    private void dfs(String puerto, Set<String> visitados) {
        if (!visitados.contains(puerto)) {
            System.out.println(puerto);
            visitados.add(puerto);
            for (Arista arista : grafo.get(puerto)) {
                dfs(arista.getDestino(), visitados);
            }
        }
    }

    public List<String> caminoMasCorto(String origen, String destino) {
        Map<String, Integer> distancia = new HashMap<>();
        Map<String, String> padre = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

        for (String puerto : grafo.keySet()) {
            distancia.put(puerto, Integer.MAX_VALUE);
            padre.put(puerto, null);
        }
        distancia.put(origen, 0);
        cola.offer(origen);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            for (Arista arista : grafo.get(actual)) {
                String vecino = arista.getDestino();
                int nuevaDistancia = distancia.get(actual) + arista.getDistancia();
                if (nuevaDistancia < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDistancia);
                    padre.put(vecino, actual);
                    cola.offer(vecino);
                }
            }
        }

        List<String> camino = new ArrayList<>();
        String actual = destino;
        while (actual != null) {
            camino.add(actual);
            actual = padre.get(actual);
        }
        Collections.reverse(camino);
        return camino;
    }

    public String puertoConMayorAristas() {
        String puertoMayor = null;
        int maxAristas = Integer.MIN_VALUE;
        for (String puerto : grafo.keySet()) {
            int numAristas = grafo.get(puerto).size();
            if (numAristas > maxAristas) {
                maxAristas = numAristas;
                puertoMayor = puerto;
            }
        }
        return puertoMayor;
    }

    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        grafo.agregarPuerto("Madero");
        grafo.agregarPuerto("Rodas");
        grafo.agregarPuerto("Puerto1");
        grafo.agregarPuerto("Puerto2");

        grafo.agregarArista("Madero", "Puerto1", 10);
        grafo.agregarArista("Puerto1", "Puerto2", 15);
        grafo.agregarArista("Madero", "Rodas", 20);

        System.out.println("Recorrido en profundidad:");
        grafo.recorridoProfundidad("Madero");

        System.out.println("\nCamino más corto de Madero a Rodas:");
        List<String> camino = grafo.caminoMasCorto("Madero", "Rodas");
        System.out.println(camino);

        String puertoMayorAristas = grafo.puertoConMayorAristas();
        System.out.println("\nPuerto con mayor número de aristas: " + puertoMayorAristas);
        System.out.println("Eliminando el puerto con mayor número de aristas...");
        grafo.eliminarPuerto(puertoMayorAristas);
    }

    static class Arista {
        private String destino;
        private int distancia;

        public Arista(String destino, int distancia) {
            this.destino = destino;
            this.distancia = distancia;
        }

        public String getDestino() {
            return destino;
        }

        public int getDistancia() {
            return distancia;
        }
    }
}

