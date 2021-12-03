package com.company;
import java.util.*;

public class SwimmerStats {

    public void divisionSwimmers(ArrayList<CompSwimmer> compList){
        Scanner input = new Scanner (System.in);
        System.out.print("*----------------------------*");
        System.out.print("| For Butterfly    (press 1) |");
        System.out.print("| For Crawl        (press 2) |");
        System.out.print("| For backstroke   (press 3) |");
        System.out.print("| For breaststroke (Press 4) |");
        System.out.print("*----------------------------*");

        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.println("Coach: Karsten");
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equals("Butterfly")) {
                        compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                        System.out.println(compList.get(i));
                    }
                }
                break;
            case 2:
                System.out.println("Coach: Jørgen");
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equals("Crawl")) {
                        compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                        System.out.println(compList.get(i));
                    }
                }
                break;
            case 3:
                System.out.println("Coach: Michael");
                for (int i = 0; i < compList.size(); i++) {
                if (compList.get(i).getSwimType().equals("Backstroke")) {
                    compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                    System.out.println(compList.get(i));
                }
            }
                break;
            case 4:
                System.out.println("Coach: Hardy");
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