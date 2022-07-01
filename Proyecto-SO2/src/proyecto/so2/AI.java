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
 * @author Nicolás Briceño
 */
public class AI {
    public TelfRevisado Check(Nodo node) {
        TelfRevisado checked = null;
        if (node != null) {
            Interfaz.ColasBot.setText("ID Teléfono en revisión: " + Integer.toString(node.getID()) + "\n");
            node.setCounter(0);
            try {
                Thread.sleep(13000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
            double rand = Math.random() * 100;
            if (rand <= 40) {
                //Sale al mercado
                checked = new TelfRevisado(node, 0);
                Interfaz.ColasBot.setText(Interfaz.ColasBot.getText() + "Ganador del combate" + "\n");
            } else if (rand > 40 && rand <= 67) {
                //Volver a encolarlos
                checked = new TelfRevisado(node, 1);
                Interfaz.ColasBot.setText(Interfaz.ColasBot.getText() + "Empate" + "\n");
            } else {
                //Necesita un refuerzo
                checked = new TelfRevisado(node, 2);                
                Interfaz.ColasBot.setText(Interfaz.ColasBot.getText() + "Necesita un refuerzo" + "\n");
            }
        }
        return checked;
    }
}
