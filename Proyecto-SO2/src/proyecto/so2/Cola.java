/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.so2;

/**
 *
 * @author Nicolas
 */
public class Cola {
    
private Nodo head;
    private Nodo tail;
    private int size;
    
    public Cola() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public void Empty() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void Enqueue(int ID, int priority) {
        Nodo newNode = new Nodo(ID, priority);
        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }
    
    public void EnqueueNode(Nodo node) {
        if (this.isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        size++;
    }
    
    public Nodo Dequeue() {
        Nodo newNode = null;
        switch (this.size) {
            case 0:
                break;
            case 1:
                newNode = this.head;
                this.Empty();
                break;
            default:
                newNode = this.head;
                head = head.getNext();
                size--;
                break;
        }
        return newNode;
    }
    
    public Cola UpdateCounter() {
        Cola aux = new Cola();
        for (int i = 0; i < size; i++) {
            Nodo auxNode = this.Dequeue();
            auxNode.setCounter(auxNode.getCounter() + 1);
            auxNode.setNext(null);
            if (auxNode.getCounter() < 8) {
                this.EnqueueNode(auxNode);
            }else{
                auxNode.setCounter(0);
                aux.EnqueueNode(auxNode);
            }
        }
        return aux;
    }
    
    public String EnqueueQueue(Cola queue){
        String string = "";
        while(!queue.isEmpty()){
            Nodo node = queue.Dequeue();
            node.updatePriority();
            string += Integer.toString(node.getID()) + ",";
            this.EnqueueNode(node);
        }
        return string;
    }
    
    public String PrintQueue(){
        String string = "";
        for (int i = 0; i < size; i++) {
            Nodo node = this.Dequeue();
            node.setNext(null);
            string += "ID Teléfono: " + Integer.toString(node.getID()) + " " + "(Contador: " +Integer.toString(node.getCounter()) + ")" + "\n";
            this.EnqueueNode(node);
        }
        return string;
    }
    
    public String DataForTxt() {
        String string = "";
        for (int i = 0; i < size; i++) {
            Nodo node = this.Dequeue();
            node.setNext(null);
            string += "ID Teléfono: " + Integer.toString(node.getID()) + " " + "(Contador: " +Integer.toString(node.getCounter()) + ")" + "\n";
            this.EnqueueNode(node);
        }
        return string;
    }
    
    public Nodo getHead() {
        return head;
    }
    
    public void setHead(Nodo head) {
        this.head = head;
    }
    
    public Nodo getTail() {
        return tail;
    }
    
    public void setTail(Nodo tail) {
        this.tail = tail;
    }
    
}
