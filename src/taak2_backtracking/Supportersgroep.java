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
public class Supportersgroep {
    private String naam;
    private String land;
    private int sterren;
    private int kamers;

    public Supportersgroep(String naam, String land, int sterren, int kamers) {
        this.naam = naam;
        this.land = land;
        this.sterren = sterren;
        this.kamers = kamers;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @return the land
     */
    public String getLand() {
        return land;
    }

    /**
     * @return the sterren
     */
    public int getSterren() {
        return sterren;
    }

    /**
     * @return the kamers
     */
    public int getKamers() {
        return kamers;
    }



}
