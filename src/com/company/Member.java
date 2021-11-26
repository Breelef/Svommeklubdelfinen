package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Member {
    private String name;
    private int age;
    private int CPR;
    private boolean status;

    public Member(String name, int age, int CPR, boolean status){
        this.name = name;
        this.age = age;
        this.CPR = CPR;
        this.status = status;
    }
    public Member(){

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

    public int getCPR() {
        return CPR;
    }

    public void setCPR(int CPR) {
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
        Member memberAdd = new Member(nameT, age, CPRnr, status);
        //Skriver til fil
        FileWriter fileWriter = new FileWriter("Memberlist", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(memberAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        memberList.add(memberAdd);
        System.out.println("Do you want to see a list of all members?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            for (int i = 0; i < memberList.size(); i++) {
                System.out.println(memberList.get(i));
            }
        }
        return memberList;
    }
    public void editMember(){

    }
    public void deleteMember() {

    }
}
