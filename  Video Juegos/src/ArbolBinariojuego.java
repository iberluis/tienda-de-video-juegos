/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IBER LUIS
 */
class Juego {
     int codigoint;
     String nombrestr;
     int precioint;
     String clasificaionstr;
     int año_lanzamientoint;
     String fabricante;
     String historia_del_juegostr;
     
    public Juego(int codigoint,String nombrestr,int precioint,String clasificaionstr,int año_lanzamientoint,String  fabricante,String historia_del_juegostr ) {
        this.codigoint = codigoint;
        this.nombrestr = nombrestr;
        this.precioint = precioint;
        this.clasificaionstr = clasificaionstr;
        this.año_lanzamientoint = año_lanzamientoint;
        this.fabricante = fabricante;
        this.historia_del_juegostr = historia_del_juegostr;
    }

   
}

class Nodo{
    Juego ordenar;
    Nodo izquierda, derecha;
    public Nodo(Juego ordenar){
            this.ordenar = ordenar;
            izquierda = derecha = null;
    }
    
}

public class ArbolBinariojuego {
    Nodo raiz;
   
    ArbolBinariojuego() {
        raiz = null;
    }
    
    void insertar(Juego ordenar) {
        raiz = insertarNodo(raiz, ordenar);
    }
   
    Nodo insertarNodo(Nodo nodo, Juego ordenar) {
        if (nodo == null) {
            nodo = new Nodo(ordenar);
            return nodo;
        }
        if (ordenar.clasificaionstr.equals("deporte") && (ordenar.año_lanzamientoint >= 2000 && ordenar.año_lanzamientoint <= 2010)){
            nodo.izquierda = insertarNodo(nodo.izquierda, ordenar);
        } else if (ordenar.clasificaionstr.equals("estrategia") && (ordenar.año_lanzamientoint >= 2010 && ordenar.año_lanzamientoint <= 2023)){
            nodo.derecha = insertarNodo(nodo.derecha, ordenar);
        } else if (ordenar.clasificaionstr.equals("aventura") && (ordenar.año_lanzamientoint >= 2020 && ordenar.año_lanzamientoint <= 2024)){
            nodo.derecha = insertarNodo(nodo.derecha, ordenar);
        } else if (ordenar.clasificaionstr.equals("deporte") && (ordenar.año_lanzamientoint == 2020)){
            nodo.derecha = insertarNodo(nodo.derecha, ordenar);
        }
        return nodo;
    }
   
    void inOrder(Nodo nodo) {
        if (nodo != null) {
            inOrder(nodo.izquierda);
            System.out.println("Codigo: " + nodo.ordenar.codigoint + ", Nombre: " + nodo.ordenar.nombrestr + 
            ", Precio: " + nodo.ordenar.precioint +
            ", Clasificacion: " + nodo.ordenar.clasificaionstr +
            ", Año de lanzamiento: " + nodo.ordenar.año_lanzamientoint + 
            ", Fabricante: " + nodo.ordenar.fabricante +
            ", Historia del juego: " + nodo.ordenar.historia_del_juegostr);
            inOrder(nodo.derecha);
        }
    }
    
    public static void main(String[] args) {
        ArbolBinariojuego arbol = new ArbolBinariojuego();

        arbol.insertar(new Juego(1000, "mortal kombat", 168304, "aventura", 2022, "John Tobias", "MK fue iniciado en el año 1992, cuando Street Fighter II, el juego de lucha uno contra uno de Capcom"));
        arbol.insertar(new Juego(1007, "eFootball", 50000, "deporte", 2006, "iber luis", "desarrollado por Konami para PlayStation 4, PlayStation 5"));
        arbol.insertar(new Juego(1012, "Halo", 33900, "estrategia", 2020, "Markus Persson", " centra en la historia de John-117 (Pablo Schreiber), un soldado 'Spartan' conocido como Jefe Maestro."));
        arbol.insertar(new Juego(1003, "minecraft", 85000, "aventura", 2023, "Castle Wolfenstein", "fue desarrollado en el año 2009 por el sueco Markus Persson, mejor conocido en la comunidad como Notch."));

        System.out.println("Arbol in-order: ");
        arbol.inOrder(arbol.raiz);
    }
}



     
   

