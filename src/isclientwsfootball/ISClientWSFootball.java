/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isclientwsfootball;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class ISClientWSFootball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Number of yellow cards " + yellowCardsTotal());
        
        List<String> defendersSpain = allDefenders("Spain").getString();
        System.out.println("Defenders of the Spanish national football team");
        for(String defender : defendersSpain){
            System.out.println(defender + "\n");
        }
        
        System.out.println("Defenders for each country");
        List<TCountryInfo> countryNames = countryNames(true).getTCountryInfo();
        for(TCountryInfo info : countryNames){
            String country = info.getSName();
            System.out.println("---->" + country.toUpperCase() + "\n");
            List<String> defenders = allDefenders(country).getString();
            for(String defender : defenders){
                System.out.println(defender +"\n");
            }
        }
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }
    
}
