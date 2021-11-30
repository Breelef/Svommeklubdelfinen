package com.company;
import java.util.*;
import java.io.*;

public class FreeSwimmer extends Member {
    private String type;
    public FreeSwimmer(String name, int age, String CPR, boolean status, String member, String type){
        super(name, age, CPR, status, member);
        this.type = type;
    }
    public FreeSwimmer(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Member> addFreeSwimmer(ArrayList<Member> memberList) throws IOException{
        Scanner input = new Scanner(System.in);
        super.addMember(memberList);
        FreeSwimmer addSwimmer = new FreeSwimmer(memberList.get(memberList.size()-1).getName(), memberList.get(memberList.size()-1).getAge(),
                memberList.get(memberList.size()-1).getCPR(), true, memberList.get(memberList.size()-1).getStartMembership(), "Recreational swimmer");
        System.out.println(addSwimmer);
        return memberList;
    }
    public String toString(){
        return "Name: " + getName() + "\nAge: " + getAge() + "\nSwimmer: " + type + "\n*********************************";
    }
}
