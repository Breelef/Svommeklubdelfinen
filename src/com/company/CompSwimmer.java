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

    public CompSwimmer(String name, int age, String CPR, boolean status, String member, String st, double bestCT, double bestTT, String cName, int place, String pDate, String cDate){
        super(name, age, CPR, status, member);
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

    public ArrayList<CompSwimmer> addCompSwimmer(ArrayList<CompSwimmer> compList, ArrayList<Member> memberList) throws IOException {
        Scanner input = new Scanner(System.in);
        super.addMember(memberList);
        int index = memberList.size();
        System.out.println("Enter swimtype: ");
        String swimT = input.next();
        System.out.println("Enter best competition time: ");
        double compTime = input.nextDouble();
        System.out.println("Enter placement at the competition");
        int place = input.nextInt();
        input.nextLine();
        System.out.println("Enter competition date for the best time: ");
        String compDate = input.nextLine();
        System.out.println("Enter name of competition: ");
        String compName = input.nextLine();
        System.out.println("Enter best practice time: ");
        double pracTime = input.nextDouble();
        input.nextLine();
        System.out.println("Enter practice date for the best time: ");
        String pracDate = input.nextLine();
        CompSwimmer compAdd = new CompSwimmer(memberList.get(index - 1).getName(), memberList.get(index-1).getAge(),
                memberList.get(index-1).getCPR(), true, memberList.get(index - 1).getStartMembership(),
                swimT, compTime, pracTime, compName, place, pracDate, compDate);
        System.out.println(compAdd);
        //Skriver til fil
        FileWriter fileWriter = new FileWriter("competitionSwimmers", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(compAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        compList.add(compAdd);
        return compList;
    }
    public ArrayList<CompSwimmer> addToArrays(ArrayList<CompSwimmer> compList)throws IOException{
        FileReader fr = new FileReader("competitionSwimmers");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String Name = "";
        int age = 0;
        String CPR = "";
        String swimtype = "";
        double bestCompTime = 0.0;
        double bestPracTime = 0.0;
        String compName = "";
        int placement = 0;
        String pracDate = "";
        String compDate = "";
        String memberDate = "";
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Name")) {
                Name = line.split(":")[1].trim();
            }
            if (line.contains("Age")) {
                useMe = line.split(":")[1].trim();
                age = Integer.parseInt(useMe);
            }
            if (line.contains("Swim Type")) {
                swimtype = line.split(":")[1].trim();
            }
            if (line.contains("Best training time")) {
                useMe = line.split(":")[1].trim();
                bestPracTime = Double.parseDouble(useMe);
            }
            if (line.contains("Training date")) {
                pracDate = line.split(":")[1].trim();
            }
            if (line.contains("Best competition time")) {
                useMe = line.split(":")[1].trim();
                bestCompTime = Double.parseDouble(useMe);
            }
            if (line.contains("Competition name")) {
                compName = line.split(":")[1].trim();
            }
            if(line.contains("Placement")){
                useMe = line.split(":")[1].trim();
                placement = Integer.parseInt(useMe);
            }
            if(line.contains("Competition date")){
               compDate = line.split(":")[1].trim();
            }
            if(line.contains("CPR-NR")){
                CPR = line.split(":")[1].trim();
            }
            if(line.contains("Date of membership")){
                memberDate = line.split(":")[1].trim();
            }
            if(line.contains("*********************************")){
                CompSwimmer swimmerAdd = new CompSwimmer(Name, age, CPR, true, memberDate, swimtype, bestCompTime, bestPracTime,
                        compName, placement, pracDate, compDate);
                compList.add(swimmerAdd);
            }
        }
        br.close();
        fr.close();
        return compList;
    }
    public void editCompSwimmer(ArrayList<CompSwimmer> compList)throws IOException{
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < compList.size(); i++) {
            System.out.println("Nr. " + (i + 1) + "\n" + compList.get(i));
        }
        System.out.print("Enter the number of member you want to edit: ");
        int changeNumber = scan.nextInt();
        System.out.println();
        CompSwimmer tempObject = compList.get((changeNumber - 1));
        System.out.println("Member " + changeNumber + ":\n1 - Swim Type: " + compList.get(changeNumber-1).getSwimType()
                + "\n2 - Best competition time: " + compList.get(changeNumber-1).getBestCompTime() +
                "\n3 - Best training time: " + compList.get(changeNumber-1).getBestTrainingTime());

        System.out.print("Enter the number of the information you want to edit: ");
        System.out.println();
        int infoNumber = scan.nextInt();
        scan.nextLine();       //Stops the next line from getting "eaten"
        switch (infoNumber) {
            case 1:
                System.out.print("Enter new Swim Type: ");
                String swimT = scan.nextLine();
                tempObject.setSwimType(swimT);
                break;
            case 2:
                System.out.print("Enter new competition time");
                double compTime = scan.nextDouble();
                tempObject.setBestCompTime(compTime);
                System.out.println("Enter date for new competition time");
                String compDate = scan.nextLine();
                tempObject.setCompDate(compDate);
                System.out.println("Enter placement at competition");
                int placement = scan.nextInt();
                tempObject.setPlacement(placement);
                System.out.println("Enter name of competition");
                String compName = scan.nextLine();
                tempObject.setCompName(compName);
                break;
            case 3:
                System.out.println("Enter new training time");
                double trainingTime = scan.nextDouble();
                tempObject.setBestTrainingTime(trainingTime);
                System.out.println("Enter date of new training time");
                String trainingDate = scan.nextLine();
                tempObject.setPracticeDate(trainingDate);
                break;
            default:
                System.out.println("Number " + infoNumber + " is not not a valid option");
                break;
        }

        System.out.println("\nSwimmer nr. " + changeNumber + " with the edit: ");
        compList.set((changeNumber - 1), tempObject);
        System.out.println(compList.get(changeNumber - 1));

        //Prints the updated ArrayList to the file
        FileWriter writer = new FileWriter("competitionSwimmers");
        for (CompSwimmer p : compList) {
            writer.write(p + System.lineSeparator());
        }
        writer.close();
    }
    public String toString(){
        /*String g = "";
        int price = 0;
        if(isStatus()){
            g = "Active membership";
        }else{
            g = "Passive membership";
        }
        if(getAge() < 18){
            price = 1000;
        }else{
            price = 1600;
            if(getAge() >= 60){
                price = 1200;
            }
        }*/
        return "Name: " + super.getName() + "\nAge: " + super.getAge() + "\nSwim Type: " + swimType + "\nBest training time: "
                + bestTrainingTime + "\nTraining date: " + practiceDate + "\nBest competition time: " + bestCompTime + "\nCompetition name: "
                + compName + "\nPlacement: " + placement + "\nCompetition date: " + compDate + "\nCPR-NR: " + super.getCPR() +
                "\nDate of membership: " + super.getStartMembership() + "\n*********************************";
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
        public ArrayList<CompSwimmer> addMember(ArrayList<CompSwimmer> compList, ArrayList<Member> memberList) throws IOException {
        Scanner input = new Scanner(System.in);
        super.addMember(memberList);
        System.out.println("Enter swimtype: ");
        String swimT = input.next();
        System.out.println("Enter best competition time: ");
        double compTime = input.nextDouble();
        System.out.println("Enter placement at the competition");
        int place = input.nextInt();
        input.nextLine();
        System.out.println("Enter competition date for the best time: ");
        String compDate = input.nextLine();
        System.out.println("Enter name of competition: ");
        String compName = input.nextLine();
        System.out.println("Enter best practice time: ");
        double pracTime = input.nextDouble();
        input.nextLine();
        System.out.println("Enter practice date for the best time: ");
        String pracDate = input.nextLine();
        CompSwimmer memberAdd = new CompSwimmer(super.getName(), super.getAge(), super.getCPR(), super.isStatus(), swimT, compTime,
                pracTime, compName, place, pracDate, compDate);
        System.out.println(memberAdd);
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
 */
