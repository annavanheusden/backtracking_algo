/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak2_backtracking;

/**
 *
 * @author u0002531
 */
public class Hotel {
    private String naam;
    private int sterren;
    private int kamers;

    public Hotel(String naam, int sterren, int kamers) {
        this.naam = naam;
        this.sterren = sterren;
        this.kamers = kamers;
    }

    /**
     * Methode voor de naam van het hotel op te vragen
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Methode voor het aantal sterren op te vragen 
     * @return the sterren
     */
    public int getSterren() {
        return sterren;
    }

    /**
     * Methode voor het aantal beschikbare kamers op te vragen 
     * @return the kamers
     */
    public int getKamers() {
        return kamers;
    }
    
    /**
     * Methode voor aantal beschikbare kamers te veranderen
     * @param kamers 
     */
    public void setKamers(int kamers) {
        this.kamers = kamers;
    }

}
