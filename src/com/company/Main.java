package com.company;
import java.util.*;
import java.io.*;

public class Main {
    private static Member myMember = new Member();
    private static CompSwimmer mySwimmer = new CompSwimmer();

    public static void main(String[] args) throws IOException {
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<CompSwimmer> compList = new ArrayList<>();
        myMember.addMember(memberList);
        mySwimmer.addMember(compList, memberList);

        Scanner scan = new Scanner(System.in);

        int answer = scan.nextInt();
        while (answer < 3) {
            System.out.println("welcome to Svømme Delfin Klubben");
            System.out.println("Do you want to add a member(press 1), change memberInformation(press 2), cancel member(press 3), see compostionmembers(press 4), " +
                    " ");


        }


        switch (answer) {
            case 1:
                System.out.println("do you wish add a compSwimmer(press 1) freeswimmer(press 2?)");
                answer = scan.nextInt();
                switch (answer) {
                    case 1:
                        Member newMemberComp = new CompSwimmer().addMember(compList, memberList);//laver et nyt objekt af typen Compswimmer, og kører metoden på objektet, og parameteroverfører de informationer som metoden skal indeholde.
                        break;
                    case 2:
                        Member newMemberFree = new FreeSwimmer().addMember(compList, memberList);//laver et nyt objekt af typen FreetupeSwimmer, etc.
                        break;
                    default:
                        System.out.print("try again");
                        break;

                }
            case 2:
                //editmember.
                break;
            case 3://cancelmember
                break;
            case 4: //see positionSwimmers and pick.
                System.out.print("Do you want to see CompositionsMembers in\n butterfly (press 1) \n crawl(press 2) \n rygcrawl(press 3) \n brystsvømning(press 4) ");
                answer = scan.nextInt();
                break;
            switch (answer) {
                case 1: //butterfly - write to file i en sorteret Array
                    break;
                case 2: //crawl - write to file i en sorteret Array
                    break;
                case 3: //rygcrawl - write to file i en sorteret Array
                    break;
                case 4: // brystsvømning - write to file i en sorteret Array                    break;
                default:
                    System.out.print("try again");
                    break;

            }

            case 5:
                //moneybalance
                System.out.print("Do you want to see a full membershiplist(press 1) \n see a membershiplist for members who didnt pay(press 2) \n get total balancerapport(press 3)");
                answer = scan.nextInt();
                switch (answer) {
                    case 1: // see full memberlist -
                        break;
                    case 2://memberlist of people who didnt pay.
                        break;
                    case 3://printing out balancerapport : expected total balanceamount for next year, last year:  amount of total balance for the members who payed, negativ total balanceamount (the members who didnt pay last year),
                        break;
                    default:
                        System.out.println();
                        break;
                }

        }
    }

}
