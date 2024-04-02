# Segunda pruba de evaluación TP

[Link a mi repositorio de Github](https://github.com/pvelaalm/Segunda-Prueba-TP)

## Ejercicio 5
Clases Implementadas
Barco

La clase abstracta Barco representa un barco genérico en el juego. Contiene los atributos tamaño para almacenar el tamaño del barco y hundido para indicar si el barco ha sido hundido. Además, contiene el método abstracto atacar(int posicion) que debe ser implementado por las clases derivadas para gestionar los ataques a los barcos.
Battleship

La clase Battleship hereda de Barco y representa un tipo de barco llamado "Battleship" en el juego. Este barco tiene un tamaño fijo de 5 posiciones y está compuesto por contenedores que deben ser destruidos uno por uno para hundir el barco.
Canoe y Frigate

Estas clases representan los tipos de barcos "Canoe" y "Frigate" en el juego. Tienen un tamaño fijo de 1 y 3 posiciones respectivamente. Al igual que el Battleship, estos barcos se hunden cuando son atacados.
CuadriculaVirtual

La clase CuadriculaVirtual representa la cuadrícula de juego donde se colocan los barcos y se lleva a cabo la batalla. Permite a los jugadores realizar ataques y muestra el estado de los tableros.
GuerraDeBarcosAvanzada

La clase principal GuerraDeBarcosAvanzada contiene el método main donde se inicia el juego. En un bucle, se alternan los turnos entre el jugador humano y la computadora hasta que uno de ellos derrota al otro.
Funcionamiento del Juego

    Se crean las instancias de CuadriculaVirtual para el jugador humano y la computadora.
    En cada turno, se muestra el tablero del jugador humano y este realiza un ataque eligiendo una posición en la cuadrícula.
    Se verifica si el ataque impacta en algún barco de la computadora y se actualiza el estado del tablero.
    Se muestra el tablero actualizado y se verifica si todos los barcos de la computadora han sido hundidos. En caso afirmativo, el jugador humano gana.
    Luego, la computadora realiza un ataque aleatorio en el tablero del jugador humano.
    Se repiten los pasos 3 a 5 hasta que uno de los jugadores derrote al otro.

## Ejercicio 6

Clase JuegoHundirLaFlota

La clase JuegoHundirLaFlota contiene el método main que inicia el juego. En este método:

    Se crea una instancia de Scanner para la entrada del usuario.
    Se definen las dimensiones del tablero (4x4) y se crean instancias de CuadriculaVirtual para cada jugador.
    Se solicita a cada jugador que configure sus barcos en la cuadrícula utilizando el método configurarBarcos.
    Se inicia el juego, alternando turnos entre los jugadores hasta que uno de ellos derrote al otro.
    Se muestra el mensaje de victoria para el jugador ganador.

Método configurarBarcos

Este método se encarga de solicitar al jugador las coordenadas para colocar sus barcos en la cuadrícula. Cada jugador tiene un máximo de tres barcos que debe colocar en el tablero.

## Ejercicio 7

Clase AlgoritmoTablasHash

La clase AlgoritmoTablasHash contiene tres tablas hash y métodos para cargar barcos en estas tablas.
Atributos

    tablaTipoBarco: HashMap que utiliza el tipo de barco como clave y almacena otro HashMap como valor, que utiliza el número del barco como clave y almacena el objeto Barco.
    tablaNumeroBarco: HashMap que utiliza el número del barco como clave y almacena otro HashMap como valor, que utiliza el nivel del barco como clave y almacena el objeto Barco.
    tablaNombreBarco: HashMap que utiliza el nombre del barco como clave y almacena otro HashMap como valor, que utiliza el número del barco como clave y almacena el objeto Barco.

Métodos

    cargarBarco(Barco barco): Método para cargar un objeto Barco en las tres tablas hash. El barco se carga en la tabla correspondiente según su tipo, número y nombre.

Clase Barco

La clase Barco es una clase interna estática que representa un barco con atributos como número, nombre, tipo y nivel.
Método main

El método main crea una instancia del algoritmo de tablas hash y carga un ejemplo de barco en las tablas utilizando el método cargarBarco.

## Ejercicio 8

Clase GrafoNoDirigido

La clase GrafoNoDirigido representa un grafo no dirigido que contiene un mapa donde las claves son los nombres de los puertos y los valores son listas de aristas que conectan esos puertos.
Atributos

    grafo: Mapa que contiene los puertos como claves y una lista de aristas como valor.

Métodos

    agregarPuerto(String puerto): Agrega un nuevo puerto al grafo.
    agregarArista(String puerto1, String puerto2, int distancia): Agrega una arista que conecta dos puertos con una distancia dada.
    eliminarPuerto(String puerto): Elimina un puerto del grafo y todas las aristas que lo conectan con otros puertos.
    recorridoProfundidad(String inicio): Realiza un barrido en profundidad (DFS) desde un puerto dado.
    caminoMasCorto(String origen, String destino): Encuentra el camino más corto entre dos puertos utilizando el algoritmo de Dijkstra.
    puertoConMayorAristas(): Encuentra el puerto con el mayor número de aristas.
    main(String[] args): Método principal que crea una instancia del grafo, agrega puertos, aristas, realiza un recorrido en profundidad, encuentra el camino más corto entre dos puertos y elimina el puerto con el mayor número de aristas.

Clase Arista

La clase Arista representa una arista que conecta dos puertos y contiene un destino y una distancia.