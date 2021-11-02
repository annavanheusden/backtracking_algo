/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taak2_backtracking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u0002531
 */
public class Taak2_Backtracking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Gson gsonIn = new Gson();
            String file = "/Users/Anna/Desktop/invoerWK2.json.txt";
            if (args.length > 0) {
                file = args[0];
            }
            
            Opgave[] invoeren = gsonIn.fromJson(new FileReader(file), Opgave[].class);
            ArrayList<Optional<Oplossing>> oplossingen = new  ArrayList<>();
            int aantal = invoeren.length;
            for(int i = 0; i < aantal; i++) {
                Opgave opgave = invoeren[i];
                Optional<Oplossing> oplossing = Backtracken.backtracken(opgave);
                oplossingen.add(oplossing);
            }
            
            
            FileWriter uit = null;
            try {
                GsonBuilder bobDeBouwer = new GsonBuilder();
                bobDeBouwer.setPrettyPrinting();
                Gson gs = bobDeBouwer.create();
                uit = new FileWriter("uitvoerWK.json.txt");
                String uitString = gs.toJson(oplossingen);
                uit.write(uitString);
            } catch (IOException ex) {
                Logger.getLogger(Taak2_Backtracking.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                uit.close();
                } catch (IOException ex) {
                Logger.getLogger(Taak2_Backtracking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Taak2_Backtracking.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
