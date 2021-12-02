package com.company;
import java.util.*;
import java.io.*;

public class Main {
    private static Member myMember = new Member();
    private static CompSwimmer mySwimmer = new CompSwimmer();
    private static FreeSwimmer myFree = new FreeSwimmer();
    private static SwimmerStats myStats = new SwimmerStats();
    private static Payment myPayments = new Payment();


    public static void main(String[] args) throws IOException {
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<CompSwimmer> compList = new ArrayList<>();
        myMember.addToArray(memberList);
        mySwimmer.addToArrays(compList);
        //myStats.divisionSwimmers(compList);
        //myMember.addMember(memberList);
        //mySwimmer.addCompSwimmer(compList, memberList);
        //myFree.addFreeSwimmer(memberList);
        //myStats.divisionSwimmers(compList);
        //myPayments.showPayments();
        //myPayments.showArrears(memberList);
        myMember.editMember(memberList);
        //mySwimmer.editCompSwimmer(compList);
        Scanner scan = new Scanner(System.in);

        /*int answer = scan.nextInt();
        while (answer < 3) {
            System.out.println("welcome to Svømme Delfin Klubben");
            System.out.println("Do you want to add a member(press 1), change memberInformation(press 2), cancel member(press 3), see compostionmembers(press 4), " +
                    " ");

            System.out.println("*------------------------------------------------------------------------------------------*");
            System.out.println("|                           Welcome to Svømme klubben Delfinen                             |");
            System.out.println("|                   This program is used for easy overview of the members                  |");
            System.out.println("|   You can the full memberlist, the mebers that has payed, and with members is in arreas. |");
            System.out.println("|   For the trainers, there will be an easy access for the top swimmers in there division. |");
            System.out.println("|                      And how they did in the previous tournaments                        |");
            System.out.println("*------------------------------------------------------------------------------------------*");
            System.out.println("                                  |                      |        ");
            System.out.println("                                  |                      |        ");
            System.out.println("                         *---------------------------------------*");
            System.out.println("                         | Do you want to add a member (press 1) |");
            System.out.println("                         | Change memberInformation    (press 2) |");
            System.out.println("                         | Edit membership             (press 3) |");
            System.out.println("                         | See competition members     (press 4) |");
            System.out.println("                         *---------------------------------------*");

            int answer = 0;
            answer = scan.nextInt();
            if (answer > 6) {
                System.out.println(answer+" ERROR CODE 404");
            }else {



        switch (answer) {
            case 1:
                System.out.println("*---------------------------------------*");
                System.out.println("| Add a competition swimmer   (press 1) |");
                System.out.println("| Add leisure swimmer         (press 2) |");
                System.out.println("*---------------------------------------*");
                answer = scan.nextInt();
                switch (answer) {
                    case 1:
                       mySwimmer.addCompSwimmer(compList, memberList);//laver et nyt objekt af typen Compswimmer, og kører metoden på objektet, og parameteroverfører de informationer som metoden skal indeholde.
                        break;
                    case 2:
                        myFree.addMember(memberList);//laver et nyt objekt af typen FreetupeSwimmer, etc.
                        break;
                    default:
                        System.out.print("ERROR CODE 404");
                        break;

                }
            case 2:
                //editmember.
                break;
            case 3://cancelmember
                break;
            case 4: //see positionSwimmers and pick.
                myStats.divisionSwimmers(compList);
                answer = scan.nextInt();
                break;
            switch (answer) {
                case 1: //butterfly - write to file i en sorteret Array
                    break;
                case 2: //crawl - write to file i en sorteret Array
                    break;
                case 3: //rygcrawl - write to file i en sorteret Array
                    break;
                case 4: // brystsvømning - write to file i en sorteret Array
                    break;
                default:
                    System.out.print("try again");
                    break;

            }

            case 5:
                //moneybalance
                System.out.println("*------------------------------------*");
                System.out.println("| See full membershiplist  (press 1) |");
                System.out.println("| See members arreaslist   (press 2) |");
                System.out.println("| Get total balancerapport (press 3) |");
                System.out.println("*------------------------------------*");
                answer = scan.nextInt();
                switch (answer) {
                    case 1: // see full memberlist -
                        break;
                    case 2://memberlist of people who didnt pay.
                        break;
                    case 3://printing out balancerapport : expected total balanceamount for next year, last year:  amount of total balance for the members who payed, negativ total balanceamount (the members who didnt pay last year),
                        break;
                    default:
                        System.out.println("ERROR CODE 404");
                        break;
                }
            default:
                System.out.println("ERROR CODE 404");
                break;
            }
        }
    }

}
