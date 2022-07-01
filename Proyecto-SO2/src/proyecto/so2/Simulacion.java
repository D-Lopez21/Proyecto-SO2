/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.so2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Simulacion {
    
    private AdminSO admin;
    private AI ai;
    private int runTime;
    private int counter;
    private int iteration;

    public Simulacion() {

        this.admin = new AdminSO();
        this.ai = new AI();
        this.runTime = 1000;
        this.counter = 0;
        this.iteration = 2;
        
    }
    
    public void run() {
        admin.AddPhone(admin.Phone());
        while (counter < iteration) {
            //System.out.println("Las iteraciones a realizar son: " + iteration);
            try {
                for (int j = 0; j < 2; j++) {
                    Nodo nodo = admin.SelectPhone();
                    TelfRevisado checked = ai.Check(nodo);
                    //System.out.println("RunTime es: " + runTime);
                    Thread.sleep(runTime);
                    admin.ManageChecked(checked);
                    Interfaz.ColasBot.update(Interfaz.ColasBot.getGraphics());
                    admin.UpdatePriority();
                    admin.ManageFixes();
                    //System.out.println("Antes de sumar, counter es: " + counter);
                    counter++;
                }
                admin.AddPhone(admin.CreatePhone());
            } catch (Exception e) {
            }
        }
    }

    public void setIteration(int counter) {
        this.iteration = counter;
        this.counter = 0;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
        this.counter = 0;
    }
    
    public void setAITime(int AITime) {
        this.ai.setProcessTime(AITime);
        this.counter = 0;
    }
    
}
