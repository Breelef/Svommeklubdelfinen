package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
    @Override
    public ArrayList<Member> addMember(ArrayList<Member> memberList){
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

        CompSwimmer memberAdd = new CompSwimmer(nameT, age, CPRnr, status, swimT, compTime,
                pracTime, compName, place, pracDate, compDate);
        memberList.add(memberAdd);
        return memberList;
    }
}
