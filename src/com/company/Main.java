package com.company;
import java.util.*;
import java.io.*;

public class Main {
    // Der skal kaldes en static instance af klassen
    private static Member myMember = new Member();
    private static CompSwimmer mySwimmer = new CompSwimmer();
    private static FreeSwimmer myFree = new FreeSwimmer();
    private static SwimmerStats myStats = new SwimmerStats();
    private static Payment myPayments = new Payment();


    public static void main(String[] args) throws IOException {
        //Arraylister af members og competition swimmers
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<CompSwimmer> compList = new ArrayList<>();
        //Læser fra filer og læser ind i Arraylister
        myMember.addToArray(memberList);
        mySwimmer.addToArrays(compList);
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("*------------------------------------------------------------------------------------------*");
        System.out.println("|                           Welcome to Svømme klubben Delfinen                             |");
        System.out.println("|                   This program is used for easy overview of the members                  |");
        System.out.println("|   You can the full memberlist, the members that has payed, and with members is in arreas.|");
        System.out.println("|   For the trainers, there will be an easy access for the top swimmers in there division. |");
        System.out.println("|                      And how they did in the previous tournaments                        |");
        System.out.println("*------------------------------------------------------------------------------------------*");
        System.out.println("                                  |                      |                                  ");
        System.out.println("                                  |                      |                                  ");
        System.out.println("                         *---------------------------------------*                          ");
        System.out.println("                         | Do you want to add a member (press 1) |                          ");
        System.out.println("                         | Change memberInformation    (press 2) |                          ");
        System.out.println("                         | Edit membership             (press 3) |                          ");
        System.out.println("                         | See competition members     (press 4) |                          ");
        System.out.println("                         | Accounting                  (press 5) |                          ");
        System.out.println("                         *---------------------------------------*                          ");

        answer = scan.nextInt();
        if (answer > 6) {
            System.out.println(answer + " ERROR CODE 404");
        } else {
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
                    System.out.println("*---------------------------------------------*");
                    System.out.println("| Edit a competition swimmer info   (press 1) |");
                    System.out.println("| Edit member info                  (press 2) |");
                    System.out.println("*---------------------------------------------*");
                    answer = scan.nextInt();
                    switch (answer) {
                        case 1:
                            myMember.editMember(memberList); //Kan redigerer et member objekt
                            break;
                        case 2:
                            mySwimmer.editCompSwimmer(compList); //Kan redigerer et compSwimmer objekt
                            break;
                        default:
                            System.out.println("ERROR CODE 404");
                            break;
                    }
                    break;
                case 3://delete member
                    myMember.deleteMember(memberList, compList);
                    break;
                case 4: //see positionSwimmers and pick.
                    myStats.divisionSwimmers(compList);
                    break;

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
                            myMember.showMembers(memberList);
                            break;
                        case 2://memberlist of people in arrear(who didn't pay).
                            myPayments.showArrears(memberList);
                            break;
                        case 3://printing out balancerapport : expected total balanceamount for the incoming year
                            myPayments.showPayments();
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
