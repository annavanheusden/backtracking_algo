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
public class Opgave {
    private ArrayList<Poule> poules;
    private ArrayList<Hotel> hotels;
    private ArrayList<Supportersgroep> supportersgroepen;

    public Opgave(ArrayList<Poule> poules, ArrayList<Hotel> hotels, ArrayList<Supportersgroep> supportersgroepen) {
        this.poules = poules;
        this.hotels = hotels;
        this.supportersgroepen = supportersgroepen;
    }

    /**
     * @return the poules
     */
    public ArrayList<Poule> getPoules() {
        return poules;
    }

    /**
     * @return the hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    /**
     * @return the supportersgroepen
     */
    public ArrayList<Supportersgroep> getSupportersgroepen() {
        return supportersgroepen;
    }

}
