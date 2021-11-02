/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak2_backtracking;

import java.util.ArrayList;

/**
 *
 * @author u0002531
 */
public class Oplossing {
    private ArrayList<Toewijzing> toewijzingen;

    public Oplossing(ArrayList<Toewijzing> toewijzingen) {
        this.toewijzingen = toewijzingen;
    }

    /**
     * 
     * @return ArrayList van toewijzingen
     */
    public ArrayList<Toewijzing> getToewijzingen() {
        return toewijzingen;
    }
    
    /**
     * 
     * @param toewijzingen 
     */
    public void setToewijzingen(ArrayList<Toewijzing> toewijzingen) {
        this.toewijzingen = toewijzingen;
    }
}
