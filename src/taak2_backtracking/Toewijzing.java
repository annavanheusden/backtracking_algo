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
public class Toewijzing {
    private String supportersgroep;
    private String hotel;

    public Toewijzing(String supportersgroep, String hotel) {
        this.supportersgroep = supportersgroep;
        this.hotel = hotel;
    }

    /**
     * 
     * @return de supportersgroep
     */
    public String getSupportersgroep() {
        return supportersgroep;
    }
    
    /**
     * Methode om de supportersgroep te veranderen 
     * @param supportersgroep 
     */
    public void setSupportersgroep(String supportersgroep) {
        this.supportersgroep = supportersgroep;
    }

    /**
     * Methode om het hotel op te vragen 
     * @return hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Methode om het hotel te veranderen 
     * @param hotel 
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    

}
