package com.company;
import java.util.*;

public class SwimmerStats {

    public void divisionSwimmers(ArrayList<CompSwimmer> compList){
        Scanner input = new Scanner (System.in);
        System.out.println("*----------------------------*");
        System.out.println("| For Butterfly    (press 1) |");
        System.out.println("| For Crawl        (press 2) |");
        System.out.println("| For backstroke   (press 3) |");
        System.out.println("| For breaststroke (Press 4) |");
        System.out.println("*----------------------------*");

        int answer = input.nextInt();

        switch (answer) {
            case 1:
                System.out.println("Coach: Karsten");
                System.out.println("Senior Swimmers:");
                compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Butterfly")) {
                        if(compList.get(i).getAge() >= 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                System.out.println("Junior Swimmers: ");
                for(int i = 0; i < compList.size(); i++){
                    if (compList.get(i).getSwimType().equals("Butterfly")) {
                        if(compList.get(i).getAge() < 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Coach: Jørgen");
                System.out.println("Senior Swimmers:");
                compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Crawl")) {
                        if(compList.get(i).getAge() >= 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                System.out.println("Junior Swimmers: ");
                for(int i = 0; i < compList.size(); i++){
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Crawl")) {
                        if(compList.get(i).getAge() < 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Coach: Michael");
                System.out.println("Senior Swimmers:");
                compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Backstroke")) {
                        if(compList.get(i).getAge() >= 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                System.out.println("Junior Swimmers: ");
                for(int i = 0; i < compList.size(); i++){
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Backstroke")) {
                        if(compList.get(i).getAge() < 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Coach: Hardy");
                System.out.println("Senior Swimmers:");
                compList.sort(Comparator.comparing(CompSwimmer::getBestCompTime));
                for (int i = 0; i < compList.size(); i++) {
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Breaststroke")) {
                        if(compList.get(i).getAge() >= 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                System.out.println("Junior Swimmers: ");
                for(int i = 0; i < compList.size(); i++){
                    if (compList.get(i).getSwimType().equalsIgnoreCase("Breaststroke")) {
                        if(compList.get(i).getAge() < 18){
                            System.out.println(compList.get(i));
                        }
                    }
                }
                break;
            default:
                System.out.print("try again");
                break;

        }
    }
}