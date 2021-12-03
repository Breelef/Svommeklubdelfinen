package com.company;

import java.lang.reflect.Array;
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

    public void addMember(ArrayList<Member> memberList)throws IOException{
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
    }
    public void editMember(ArrayList<Member> memberList)throws IOException{
        Scanner scan = new Scanner(System.in);
        String g = "";
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println("Nr. " + (i + 1) + "\n" + memberList.get(i));
        }
        System.out.print("Enter the number of member you want to edit: ");
        int changeNumber = scan.nextInt();
        System.out.println();
        Member tempObject = memberList.get((changeNumber - 1));
        if(memberList.get(changeNumber-1).isStatus()){
            g = "Active membership";
        }else{
            g = "Passive membership";
        }
        System.out.println("Member " + changeNumber + ":\n1 - Name: " + memberList.get(changeNumber-1).getName()
                + "\n2 - Membership: " + g + "\n3 - Date of membership: " + memberList.get(changeNumber-1).getStartMembership());

        System.out.print("Enter the number of the information you want to edit: ");
        System.out.println();
        int infoNumber = scan.nextInt();
        scan.nextLine();       //Stops the next line from getting "eaten"
        switch (infoNumber) {
            case 1:
                System.out.print("Enter new name: ");
                String name = scan.nextLine();
                tempObject.setName(name);
                break;
            case 2:
                System.out.print("Enter membership status (type false for passive membership, true for active membership): ");
                boolean status = scan.nextBoolean();
                tempObject.setStatus(status);
                break;
            case 3:
                System.out.println("Enter new membership date: ");
                String membership = scan.nextLine();
                tempObject.setStartMembership(membership);
                break;
            default:
                System.out.println("Number " + infoNumber + " is not not a valid option");
                break;
        }

        System.out.println("\nMember nr. " + changeNumber + " with the edit: ");
        memberList.set((changeNumber - 1), tempObject);
        System.out.println(memberList.get(changeNumber - 1));

        //Prints the updated ArrayList to the file
        FileWriter writer = new FileWriter("Memberlist");
        for (Member p : memberList) {
            writer.write(p + System.lineSeparator());
        }
        writer.close();
    }
    public void deleteMember(ArrayList<Member> memberList, ArrayList<CompSwimmer> compList)throws IOException {
        Scanner input = new Scanner(System.in);
        int i = 1;
        int answer = 0;
        for (Member member : memberList) {
            System.out.println(i + ". " + member);
            i++;
        }
        System.out.println("Which member would you like to delete?");
        answer = input.nextInt();
        for(int k = 0; k < compList.size(); k++){
            if(memberList.get(answer-1).getCPR().equals(compList.get(k).getCPR())){
                compList.remove(k);
            }
        }
        memberList.remove(answer - 1);
        //Overwrite file with updated memberlist
        FileWriter writer = new FileWriter("Memberlist");
        for (Member p : memberList) {
            writer.write(p + System.lineSeparator());
        }
        writer.close();
        FileWriter writerComp = new FileWriter("competitionSwimmers");
        for (CompSwimmer p : compList) {
            writerComp.write(p + System.lineSeparator());
        }
        writer.close();
    }
    public void addToArray(ArrayList<Member> memberList)throws IOException{
        FileReader fr = new FileReader("Memberlist");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String Name = "";
        int age = 0;
        String CPR = "";
        boolean status = true;
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
                if(useMe.equalsIgnoreCase("Active membership")){
                    status = true;
                }else{
                    status = false;
                }
            }
            if(line.contains("Date of membership")){
                membership = line.split(":")[1].trim();
            }
            if(line.contains("*********************************")){
                Member memberAdd = new Member(Name, age, CPR, status, membership);
                memberList.add(memberAdd);
            }
        }
        br.close();
        fr.close();
    }
    public void showMembers(ArrayList<Member> memberList){
        for(Member member : memberList){
            System.out.println(member);
        }
    }

    public String toString(){
        String g = "";
        int price = 0;
        if(status){
            g = "Active membership";
        }else{
            g = "Passive membership";
        }
        if(g.equals("Passive membership")){
            price = 500;
        }else{
            if(age < 18){
                price = 1000;
            }else{
                price = 1600;
                if(age >= 60){
                    price = 1200;
                }
            }
        }
        return "Name: " + name + "\nAge: " + age + "\nCPR-nr: " + CPR + "\nMembership: " + g + "" +
                "\nPrice: " + price + "\nDate of membership: " + startMembership + "\n*********************************";
    }
}
