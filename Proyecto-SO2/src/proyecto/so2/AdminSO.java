/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.so2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás y Andres
 */
public class AdminSO {
    
    public void updateText() {
        Interfaz.Admin1.setText(Interfaz.level1.PrintQueue());
        Interfaz.Admin1.update(Interfaz.Admin1.getGraphics());
        Interfaz.Admin2.setText(Interfaz.level2.PrintQueue());
        Interfaz.Admin2.update(Interfaz.Admin2.getGraphics());
        Interfaz.Admin3.setText(Interfaz.level3.PrintQueue());
        Interfaz.Admin3.update(Interfaz.Admin3.getGraphics());
        Interfaz.AdminFix.setText(Interfaz.fixStation.PrintQueue());
        Interfaz.AdminFix.update(Interfaz.AdminFix.getGraphics());
    }
    
    public Nodo Phone() { 
        //Aquí se crean por prioridad y se avisa a interfaz de su creación
        int min = 0;
        int max = 2;
        Random random = new Random();
        int rand = random.nextInt(max+min)+min;
        double pantalla = Math.random() * 75;
        double pin = Math.random()  * 84;
        double camara = Math.random() * 80;
        double botones = Math.random() * 85;
        Nodo phone;
        if (rand == 1){
            double trophies = pantalla + pin + 3*camara + 4*botones;
            phone = this.CreateThophie(trophies);
        }else if (rand == 2){        
            double trophies = 2*pantalla + pin + 4*camara + 3*botones;
            phone = this.CreateThophie(trophies);
        }else{
            double trophies = pantalla + pin + 4*camara + 3*botones;
            phone = this.CreateThophie(trophies);
        }
        return phone;
    }
    
    public Nodo CreateThophie(double trophie){
       Nodo nodo;
        if (trophie <= 1999) {
            nodo = new Nodo(Interfaz.telefonos, 1);
            System.out.println("Soy prioridad 3");
            Interfaz.telefonos++;
        } else if (trophie > 1999 && trophie <= 2999) {
            nodo = new Nodo(Interfaz.telefonos, 2);
            System.out.println("Soy prioridad 2");
            Interfaz.telefonos++;
        } else {
            nodo = new Nodo(Interfaz.telefonos, 3);
            System.out.println("Soy un pipi en Clash Royale");
            Interfaz.telefonos++;
        }
        return nodo; 
    }
    
    public Nodo CreatePhone() {
        //Proceso normal de creacion, tomando en cuenta la probabilidad (70%)
        double rand = Math.random() * 100;
        Nodo nodo = null;
        if (rand <= 70) {
            nodo = Phone();
        }
        return nodo;
    }
    
    public void AddPhone(Nodo nodo) {
        //Metodo que se encarga de meter en las colas
        if (nodo != null) {
            switch (nodo.getPriority()) {
                case 1:
                    Interfaz.level1.EnqueueNode(nodo);
                    updateText();
                    break;
                case 2:
                    Interfaz.level2.EnqueueNode(nodo);
                    updateText();
                    break;
                case 3:
                    Interfaz.level3.EnqueueNode(nodo);                    
                    updateText();
                    break;
                default:
                    break;
            }
        }
    }
    
    public Nodo SelectPhone() {
        Nodo nodo;
        if (!Interfaz.level1.isEmpty()) {
            nodo = Interfaz.level1.Dequeue();
        } else if (!Interfaz.level2.isEmpty()) {
            nodo = Interfaz.level2.Dequeue();
        } else if (!Interfaz.level3.isEmpty()) {
            nodo = Interfaz.level3.Dequeue();
        } else {
            nodo = null;
        }
        return nodo;
    }
    
    //El metodo que maneja los nodos que ya reviso la IA, y fueron vendidos, quedaron en empate, o a reforzar
    public void ManageChecked(TelfRevisado checked) { 
        if (checked != null) {
            switch (checked.getAction()) {
                case 0:
                    //Los telefonos vendidos 
                    break;
                case 1:
                    //Los telefonos que empataron
                    AddPhone(checked.getNode());
                    break;
                case 2:
                    //Los telefonos a refuerzo
                    Interfaz.fixStation.EnqueueNode(checked.getNode());
                    updateText();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void ManageFixes() {
        if (!Interfaz.fixStation.isEmpty()) {
            double rand = Math.random() * 100;
            Nodo nodo = Interfaz.fixStation.Dequeue();
            if (rand <= 45) {
                updateText();
                switch (nodo.getPriority()) {
                    case 1:
                        Interfaz.level1.EnqueueNode(nodo);
                        break;
                    case 2:
                        Interfaz.level2.EnqueueNode(nodo);
                        break;
                    case 3:
                        Interfaz.level3.EnqueueNode(nodo);
                        break;
                    default:
                        break;
                }
            } else {
                Interfaz.fixStation.EnqueueNode(nodo);
            }
        }
    }
    
    public void UpdatePriority() {
        String string;
        String[] strings;
        string = Interfaz.level1.EnqueueQueue(Interfaz.level2.UpdateCounter());
        System.out.println(string.equals(""));
        if (!string.equals("")) {
            System.out.println("Entre en el if del 2 al 1");
            strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                Interfaz.priorityUp.setText("Superaste las 1999 copas, subes de Arena de 3 a 2\nTelefono(s): " + strings[i]);
                Interfaz.priorityUp.update(Interfaz.priorityUp.getGraphics());
            }
        }
        string = Interfaz.level2.EnqueueQueue(Interfaz.level3.UpdateCounter());
        if (!string.equals("")) {
            System.out.println("Entre en el if del 3 al 2");
            strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                Interfaz.priorityUp.setText("Superaste las 2999 copas, Subes de Arena de 2 a 1\nTelefono(s): " + strings[i]);
                Interfaz.priorityUp.update(Interfaz.priorityUp.getGraphics());
            }
        }
    }
}
