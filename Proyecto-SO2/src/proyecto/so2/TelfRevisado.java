/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.so2;

/**
 *
 * @author Nicolás Briceño
 */
public class TelfRevisado {
    private Nodo node;
    private int action;

    public TelfRevisado(Nodo node, int action) {
        this.node = node;
        this.action = action;
    }

    public Nodo getNode() {
        return node;
    }

    public void setNode(Nodo node) {
        this.node = node;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
