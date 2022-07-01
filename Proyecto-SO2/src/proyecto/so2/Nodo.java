/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.so2;

/**
 *
 * @author Nicolás Briceño y Andres
 */
public class Nodo {
    
    private Nodo next;
    private int ID;
    private int counter;
    private int priority;
    private double strike;
    private double critico; 
    private double evasion;
    private double velocidad;
    private double rango;

    public Nodo(int ID, int priority) {
        this.ID = ID;
        this.counter = 0;
        this.priority = priority;
        this.strike = Math.random();
        this.critico = Math.random();
        this.evasion = Math.random();
        this.velocidad = Math.random();
        this.rango = Math.random();
    }

    public void updatePriority() {
        if (this.priority > 1) {
            this.priority = this.priority - 1;
        }
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
