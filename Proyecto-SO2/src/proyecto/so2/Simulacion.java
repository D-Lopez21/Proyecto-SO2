/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.so2;

/**
 *
 * @author Nicolás
 */
public class Simulacion {
    
    private AdminSO admin;
    private AI ai;
    private int runTime;

    public Simulacion() {

        this.admin = new AdminSO();
        this.ai = new AI();
        this.runTime = 1000;

    }
    
    public void run() {
        admin.AddPhone(admin.Phone());
        
        while (true) {
            try {
                for (int j = 0; j < 2; j++) {
                    Nodo nodo = admin.SelectPhone();
                    TelfRevisado checked = ai.Check(nodo);
                    Thread.sleep(runTime);
                    admin.ManageChecked(checked);
                    Interfaz.ColasBot.update(Interfaz.ColasBot.getGraphics());
                    admin.UpdatePriority();
                    admin.ManageFixes();
                }
                admin.AddPhone(admin.CreatePhone());
            } catch (Exception e) {
            }
        }
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }
    
    
}
