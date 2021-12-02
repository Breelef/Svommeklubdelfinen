package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Payment {
    public void showPayments ()throws IOException {
        FileReader fr = new FileReader("Memberlist");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String useMe = "";
        int price = 0;
        while((line = br.readLine()) != null){
            if(line.contains("Price")){
                useMe = line.split(":")[1].trim();
                price += Integer.parseInt(useMe);
            }
        }
        System.out.println("Total amount of payment for the next year: " + price + " kr");
    }
    public void showArrears(ArrayList<Member> memberList) throws  IOException{
        for (int i = 0; i < memberList.size(); i++){
            String membership = memberList.get(i).getStartMembership();
            int day = Integer.parseInt(membership.substring(0,2));
            int month = Integer.parseInt(membership.substring(3,5));
            if(day < 13 && month == 12 || day > 13 && month == 11){
                System.out.println(memberList.get(i));
            }
        }
    }
}
/*FileReader fr = new FileReader("Memberlist");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String useMe = "";
        while((line = br.readLine()) != null){
            if(line.contains("Membership date")){
                useMe = line.split(":")[1].trim();
                int day = Integer.parseInt(useMe.substring(0,2));
                int month = Integer.parseInt(useMe.substring(3,5));
                int year = Integer.parseInt(useMe.substring(6,8));
                if(day < 13 && month == 12 || day > 13 && month < 12){

                }
            }
        }*/