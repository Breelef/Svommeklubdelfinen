package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    public void showArrears() throws  IOException{
        FileReader fr = new FileReader("Memberlist");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String useMe = "";
        while((line = br.readLine()) != null){
            if(line.contains("Membership date")){

            }
        }
    }
}
