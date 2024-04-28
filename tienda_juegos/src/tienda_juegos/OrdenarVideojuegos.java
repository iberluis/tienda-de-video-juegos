/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda_juegos;

/**
 *
 * @author IBER LUIS
 */
   class videojuegos {
    int codigo;
    String nombre;
    int precio;
    String clasificacion;
    int añolanzamiento;
    String fabricante;
    String historia;

    public videojuegos(int codigo, String nombre, int precio, String clasificacion, int añolanzamiento, String fabricante, String historia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.añolanzamiento = añolanzamiento;
        this.fabricante = fabricante;
        this.historia = historia;
    }
}

    class Nodo {
        videojuegos ordenar;
        Nodo izquierda, derecha;

        public Nodo(videojuegos ordenar) {
            this.ordenar = ordenar;
            izquierda = derecha = null;
        }
        
    }

public class OrdenarVideojuegos {
    Nodo raiz;

    OrdenarVideojuegos() {
        raiz = null;
    }

    void insertar(videojuegos ordenar) {
        raiz = insertarNodo(raiz, ordenar);
    }

    Nodo insertarNodo(Nodo nodo, videojuegos ordenar) {
        if (nodo == null) {
            return new Nodo(ordenar);
        }

        // Comparing based on classification and release year
        if (ordenar.añolanzamiento >= 2000 && ordenar.añolanzamiento <= 2010) {
            if (ordenar.clasificacion.equals("deporte")) {
                nodo.izquierda = insertarNodo(nodo.izquierda, ordenar);
            }
        } else if (ordenar.añolanzamiento >= 2010 && ordenar.añolanzamiento <= 2023) {
            if (ordenar.clasificacion.equals("estrategia") || ordenar.clasificacion.equals("aventura")) {
                nodo.derecha = insertarNodo(nodo.derecha, ordenar);
            }
        }

        return nodo;
    }

    void inOrder(Nodo nodo) {
        if (nodo != null) {
            inOrder(nodo.izquierda);
            System.out.println("Codigo: " + nodo.ordenar.codigo + " Nombre: " + nodo.ordenar.nombre + " Fecha: " + nodo.ordenar.añolanzamiento + " Clasificacion: " + nodo.ordenar.clasificacion + " Precio $ " + nodo.ordenar.precio + " Fabricante: " + nodo.ordenar.fabricante);
            inOrder(nodo.derecha);
        }
    }

    public static void main(String[] args) {
        OrdenarVideojuegos arbol = new OrdenarVideojuegos();

        arbol.insertar(new videojuegos(103, "minecraft",13000,"aventura",2022,"papucho","cubos"));
        arbol.insertar(new videojuegos(101, "fifa",50000,"deporte",2006,"Catalina Ospina","estaba aburrido"));
        arbol.insertar(new videojuegos(102, "frefire",5000,"estrategia",2020,"Sergio","la mama lo mando"));
        arbol.insertar(new videojuegos(104, "gta",60000,"aventura",2023,"Rockstar Games","nuevas aventuras"));

        System.out.println("Arbol in-order: ");
        arbol.inOrder(arbol.raiz);
    }
}
