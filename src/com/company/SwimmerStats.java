package com.company;
import java.util.*;

public class SwimmerStats {

    public void divisionSwimmers(ArrayList<CompSwimmer> compList){
        for (CompSwimmer compSwimmer : compList) {
            if (compSwimmer.getSwimType().equals("Crawl")) {
                System.out.println(compSwimmer);
            }
        }
    }
}
