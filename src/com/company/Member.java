package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class Member {
    private String name;
    private int age;
    private String CPR;
    private boolean status;
    private String startMembership;

    public Member(String name, int age, String CPR, boolean status, String startMembership){
        this.name = name;
        this.age = age;
        this.CPR = CPR;
        this.status = status;
        this.startMembership = startMembership;
    }
    public Member(){

    }
    public String getStartMembership() {
        return startMembership;
    }

    public void setStartMembership(String startMembership) {
        this.startMembership = startMembership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Member> addMember(ArrayList<Member> memberList)throws IOException{
        Scanner input = new Scanner(System.in);
        int age = 0;
        System.out.println("Enter name: ");
        String nameT = input.nextLine();
        System.out.println("Enter CPR-nr: ");
        String CPRnr = input.next();
        System.out.println("Enter date of membership: ");
        input.nextLine();
        String membership = input.nextLine();
        int day = Integer.parseInt(CPRnr.substring(0,2));
        int month = Integer.parseInt(CPRnr.substring(2,4));
        int year = Integer.parseInt(CPRnr.substring(4,6));
        if(year > 21){
            String y = "19" + year;
            year = Integer.parseInt(y);
            age = 2021 - year;
        }else {
            age = 21 - year;
        }
        if(month > 12 || month == 12 && day < 13){
            age--;
        }
        Member memberAdd = new Member(nameT, age, CPRnr, true, membership);
        //Skriver til fil
        FileWriter fileWriter = new FileWriter("Memberlist", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(memberAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        memberList.add(memberAdd);
        return memberList;
    }
    public void editMember(){

    }
    public void deleteMember() {

    }
    public ArrayList<Member> addToArray(ArrayList<Member> memberList)throws IOException{
        FileReader fr = new FileReader("Memberlist");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String Name = "";
        int age = 0;
        String CPR = "";
        boolean status = false;
        String membership = "";
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Name")) {
                Name = line.split(":")[1].trim();
            }
            if (line.contains("Age")) {
                useMe = line.split(":")[1].trim();
                age = Integer.parseInt(useMe);
            }
            if (line.contains("CPR-nr")) {
                CPR = line.split(":")[1].trim();
            }
            if (line.contains("Membership")){
                useMe = line.split(":")[1].trim();
                status = useMe.equalsIgnoreCase("Active membership");
            }
            if(line.contains("Membership date")){
                membership = line.split(":")[1].trim();
            }
            if(line.contains("*********************************")){
                Member memberAdd = new Member(Name, age, CPR, status, membership);
                memberList.add(memberAdd);
            }
        }
        br.close();
        fr.close();
        return memberList;
    }

    public String toString(){
        String g = "";
        int price = 0;
        if(status){
            g = "Active membership";
        }else{
            g = "Passive membership";
        }
        if(age < 18){
            price = 1000;
        }else{
            price = 1600;
            if(age >= 60){
                price = 1200;
            }
        }
        return "Name: " + name + "\nAge: " + age + "\nCPR-nr: " + CPR + "\nMembership: " + g + "" +
                "\nPrice: " + price + "\nMembership date: " + startMembership + "\n*********************************";
    }
}
