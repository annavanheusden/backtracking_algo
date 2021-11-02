package taak2_backtracking;

import java.util.ArrayList;
import java.util.Optional;

public class Backtracken {
    
    static private ArrayList<Poule> poules;
    static private ArrayList<Hotel> hotels;
    static private ArrayList<Supportersgroep> supportergroepen;
    
    /**
     * 
     * @param o opgave
     * @return oplossing 
     */
    public static Optional<Oplossing> backtracken(Opgave o) {
        poules = o.getPoules();
        hotels = o.getHotels();
        supportergroepen = o.getSupportersgroepen();       
        return toewijzen(new Oplossing(new ArrayList<>()), 0,0);
    }
    
    /**
     * Recursief toewijzen van hotels aan verschillende groepen 
     * @param huidigeOplossing 
     * @param hotelnr
     * @param groepnr
     * @return 
     */
    public static Optional<Oplossing> toewijzen(Oplossing huidigeOplossing, int hotelnr, int groepnr) {     
      //Werden alle supportergroepen doorlopen?
      //Zoja: Huidige oplossing teruggeven
      //Zonee: De volgende supportergroep toewijzen
      if(huidigeOplossing.getToewijzingen().size() == supportergroepen.size()) {
          return Optional.of(huidigeOplossing);
      }
      else {
            Hotel hotel = hotels.get(hotelnr);
            Supportersgroep groep = supportergroepen.get(groepnr);
          
          //Is het hotel vol?
          if(isVol(groep, hotel)) {
              //Zoja: Is dit het laatste hotel?
              //Zoja: Backtracken
              if(hotelnr == hotels.size() - 1) {
                return backtrack(huidigeOplossing);
              }
              //Zonee: Dezelfde groep proberen toe te wijzen bij het volgende hotel
              else {
                return toewijzen(huidigeOplossing, hotelnr+1, groepnr);    
              }
          }
          else {
             //Zonee: Zit een 'vijand' in het hotel?
             if(zelfdePoule(huidigeOplossing,groep,hotelnr)) {
                    //Zoja: Is dit het laatste hotel?
                    //Zoja: Backtracken
                    if(hotelnr == hotels.size() - 1) {
                        return backtrack(huidigeOplossing);
                    }
                    //Zonee: Dezelfde groep proberen toe te wijzen bij het volgende hotel
                    else {
                        return toewijzen(huidigeOplossing, hotelnr+1, groepnr); 
                    }
             }
             else {
                //Zonee: Zijn er genoeg sterren?
                //Zoja: Deze groep toewijzen aan het hotel
                if(genoegSterren(groep,hotel)) {
                    hotels.get(hotelnr).setKamers(hotel.getKamers() - groep.getKamers());
                    Toewijzing toewijzing = new Toewijzing(groep.getNaam(),hotel.getNaam());
                    huidigeOplossing.getToewijzingen().add(toewijzing);
                    return toewijzen(huidigeOplossing, 0, groepnr+1);
                }
                else {
                    //Zonee: Is dit het laatste hotel?
                    //Zoja: Backtracken
                    if(hotelnr == hotels.size() - 1) {
                        return backtrack(huidigeOplossing);
                    }
                    //Zonee: Dezelfde groep proberen toe te wijzen bij het volgende hotel
                    else {
                        return toewijzen(huidigeOplossing,hotelnr+1,groepnr);
                    }
                }
             }
                           
          }
      }
    }
   
    /**
     * Methode die controleert of het hotel al vol is
     * @param groep die we in het hotel proberen plaatsen
     * @param hotel
     * @return true als het vol is, false als het niet vol is
     */
    private static boolean isVol(Supportersgroep groep, Hotel hotel) {
        return hotel.getKamers() < groep.getKamers();       
    }
    
    /**
     * Methode die controleert of een groep in een hotel zit met een supportersgroep van dezelfde poule
     * @param huidigeOplossing
     * @param groep 
     * @param hotelnr
     * @return true als zelfde poule zitten, false als niet zo is
     */
    private static boolean zelfdePoule(Oplossing huidigeOplossing, Supportersgroep groep, int hotelnr) {
        String hotelNaam = hotels.get(hotelnr).getNaam();
        for(Toewijzing toewijzing: huidigeOplossing.getToewijzingen()) {
            String ploeg1LandNaam = groep.getLand();
            String ploeg2LandNaam = null;
            
            if(toewijzing.getHotel().equals(hotelNaam)) {
                String supportersNaam = toewijzing.getSupportersgroep();
                
                for(Supportersgroep supportersgroep: supportergroepen) {
                    if(supportersgroep.getNaam().equals(supportersNaam)) {
                        ploeg2LandNaam = supportersgroep.getLand();
                        break;
                    }
                }
                
                for(Poule poule: poules) {
                    for(Land land: poule.getLanden()) {
                        if(land.getLand().equals(ploeg1LandNaam)) {
                            for(Land land2: poule.getLanden()) {
                                if(land2.getLand().equals(ploeg2LandNaam) && !land2.getLand().equals(ploeg1LandNaam)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Methode die controleert of het hotel voldoende sterren heeft voor de groep
     * @param groep
     * @param hotel
     * @return true als het genoeg sterren heeft, false als het niet voldoende sterren heeft
     */
    private static boolean genoegSterren(Supportersgroep groep, Hotel hotel) {
        return groep.getSterren() <= hotel.getSterren();
    }
    
    /**
     * Methode voor het backtracken waarbij we de vorige groep toewijzen aan een volgend hotel 
     * @param huidigeOplossing
     * @return oplossing 
     */
    private static Optional<Oplossing> backtrack(Oplossing huidigeOplossing) {
        //Als je niet meer kan backtracken is er geen oplossing 
        if(huidigeOplossing.getToewijzingen().isEmpty()) {
            return Optional.empty();
        }
        //Wat is de vorige toewijzing?
        Toewijzing laatsteToewijzing = huidigeOplossing.getToewijzingen().get(huidigeOplossing.getToewijzingen().size() - 1);       
        String hotelNaamLaatsteToewijzing = laatsteToewijzing.getHotel();
        String supportergroepNaamLaatsteToewijzing = laatsteToewijzing.getSupportersgroep();
        
        Hotel hotelLaatsteToewijzing = null;
        Supportersgroep supportergroepLaatsteToewijzing = null;
        for(Hotel h: hotels) {
            if(h.getNaam().equals(hotelNaamLaatsteToewijzing)) {
                hotelLaatsteToewijzing = h;
            }
        }
        for(Supportersgroep s: supportergroepen) {
            if(s.getNaam().equals(supportergroepNaamLaatsteToewijzing)) {
                supportergroepLaatsteToewijzing = s;
            }
        }
        
        int indexHotelLaatsteToewijzing = hotels.indexOf(hotelLaatsteToewijzing);
        int indexSupportergroepLaatsteToewijzing = supportergroepen.indexOf(supportergroepLaatsteToewijzing);

        //Is er nog een volgend hotel?
        if(indexHotelLaatsteToewijzing == hotels.size() - 1) {
            //Zonee: Die toewijzing verwijderen en opnieuw backtracken
            hotels.get(indexHotelLaatsteToewijzing).setKamers(hotels.get(indexHotelLaatsteToewijzing).getKamers() + supportergroepLaatsteToewijzing.getKamers());
            huidigeOplossing.getToewijzingen().remove(laatsteToewijzing);
            return backtrack(huidigeOplossing);
        }
        else {
            //Zoja: Toewijzing verwijderen en zelfde groep toewijzen aan volgend hotel
            hotels.get(indexHotelLaatsteToewijzing).setKamers(hotels.get(indexHotelLaatsteToewijzing).getKamers() + supportergroepLaatsteToewijzing.getKamers());
            huidigeOplossing.getToewijzingen().remove(laatsteToewijzing);
            return toewijzen(huidigeOplossing, indexHotelLaatsteToewijzing+1, indexSupportergroepLaatsteToewijzing);    
        }
    }
}