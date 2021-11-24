package com.company;
import java.util.*;

public class Main {
    private static Member myMember = new Member();
    private static CompSwimmer mySwimmer = new CompSwimmer();

    public static void main(String[] args) {
	ArrayList<Member> memberList = new ArrayList<Member>();
    myMember.addMember(memberList);
    mySwimmer.addMember(memberList);
    }
}
