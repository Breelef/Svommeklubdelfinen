package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CompSwimmer extends Member{
    private String swimType;
    private double bestCompTime;
    private double bestTrainingTime;
    private String compName;
    private int placement;
    private String practiceDate;
    private String compDate;

    public CompSwimmer(String name, int age, int CPR, boolean status, String st, double bestCT, double bestTT, String cName, int place, String pDate, String cDate){
        super(name, age, CPR, status);
        swimType = st;
        bestCompTime = bestCT;
        bestTrainingTime = bestTT;
        compName = cName;
        placement = place;
        practiceDate = pDate;
        compDate = cDate;
    }
    public CompSwimmer(){
    }

    public String getSwimType() {
        return swimType;
    }

    public void setSwimType(String swimType) {
        this.swimType = swimType;
    }

    public double getBestCompTime() {
        return bestCompTime;
    }

    public void setBestCompTime(double bestCompTime) {
        this.bestCompTime = bestCompTime;
    }

    public double getBestTrainingTime() {
        return bestTrainingTime;
    }

    public void setBestTrainingTime(double bestTrainingTime) {
        this.bestTrainingTime = bestTrainingTime;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public String getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(String practiceDate) {
        this.practiceDate = practiceDate;
    }

    public String getCompDate() {
        return compDate;
    }

    public void setCompDate(String compDate) {
        this.compDate = compDate;
    }
    public ArrayList<CompSwimmer> addMember(ArrayList<CompSwimmer> compList, ArrayList<Member> memberList) throws IOException {
        Scanner input = new Scanner(System.in);
        super.addMember(memberList);
        System.out.println("Enter swimtype: ");
        String swimT = input.next();
        System.out.println("Enter best competition time: ");
        double compTime = input.nextDouble();
        System.out.println("Enter placement at the competition");
        int place = input.nextInt();
        System.out.println("Enter competition date for the best time: ");
        String compDate = input.nextLine();
        System.out.println("Enter name of competition: ");
        String compName = input.nextLine();
        System.out.println("Enter best practice time: ");
        double pracTime = input.nextDouble();
        System.out.println("Enter practice date for the best time: ");
        String pracDate = input.nextLine();
        CompSwimmer memberAdd = new CompSwimmer(super.getName(), super.getAge(), super.getCPR(), super.isStatus(), swimT, compTime,
                pracTime, compName, place, pracDate, compDate);
        //Skriver til fil
        FileWriter fileWriter = new FileWriter("compSwimmers", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(memberAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        compList.add(memberAdd);
        System.out.println("Want to see a list of all the competition swimmers?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            for (int i = 0; i < compList.size(); i++) {
                System.out.println(compList.get(i));
            }
        }
        return compList;
    }
    public ArrayList<CompSwimmer> addToArray(ArrayList<CompSwimmer> compList)throws IOException{
        FileReader fr = new FileReader("compSwimmers");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String Name = "";
        int age = 0;
        int CPR = 0;
        boolean status = true;
        String swimtype = "";
        double bestCompTime = 0.0;
        double bestPracTime = 0.0;
        String compName = "";
        int placement = 0;
        String pracDate = "";
        String compDate = "";
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Name")) {
                Name = line.split(":")[1].trim();
            }
            if (line.contains("Model")) {
                useMe = line.split(":")[1].trim();
                age = Integer.parseInt(useMe);
            }
            if (line.contains("Benzin type")) {
                useMe = line.split(":")[1].trim();
                CPR = Integer.parseInt(useMe);
            }
            if (line.contains("Størrelse på bilen")) {
                swimtype = line.split(":")[1].trim();
            }
            if (line.contains("Registreringsnummer")) {
                useMe = line.split(":")[1].trim();
                bestCompTime = Double.parseDouble(useMe);
            }
            if (line.contains("Registreringsdato")) {
                useMe = line.split(":")[1].trim();
                bestPracTime = Double.parseDouble(useMe);

            }
            if (line.contains("Bilen har kørt")) {
                compName = line.split(":")[1].trim();
            }
            if(line.contains("Bilen har kørt"){
                useMe = line.split(":")[1].trim();
                placement = Integer.parseInt(useMe);
            }
            if(line.contains("Bilen har kørt"){
               pracDate = line.split(":")[1].trim();
            }
            if(line.contains("Bilen har kørt"){
                compDate = line.split(":")[1].trim();
            }
            if(line.contains("*********************************")){
                CompSwimmer swimmerAdd = new CompSwimmer(Name, age, CPR, status, swimtype, bestCompTime, bestPracTime,
                        compName, placement, pracDate, compDate);
                compList.add(swimmerAdd);
            }
        }
        br.close();
        fr.close();
    }
}

/*
Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        String nameT = input.nextLine();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter CPR-nr: ");
        int CPRnr = input.nextInt();
        System.out.println("""
                    Enter true for active membership
                    Enter false for passive membership""");
        boolean status = input.nextBoolean();
 */
