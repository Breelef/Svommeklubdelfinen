package com.company;
import java.util.*;

public class SwimmerStats {

    public void divisionSwimmers(ArrayList<CompSwimmer> compList){
        Scanner input = new Scanner (System.in);
        System.out.println("" +
                "Press 1 for Butterfly" +
                "\nPress 2 for Crawl" +
                "\nPress 3 for Backstroke" +
                "\nPress 4 for Breaststroke");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equals("Butterfly")) {
                        compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                        System.out.println(compList.get(i));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equals("Crawl")) {
                        compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                        System.out.println(compList.get(i));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < compList.size(); i++) {
                if (compList.get(i).getSwimType().equals("Backstroke")) {
                    compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                    System.out.println(compList.get(i));
                }
            }
                break;
            case 4:
                for (int i = 0; i < compList.size(); i++) {
                if (compList.get(i).getSwimType().equals("Breaststroke")) {
                    compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                    System.out.println(compList.get(i));
                }
            }
                break;
            default:
                System.out.print("try again");
                break;

        }
    }
}