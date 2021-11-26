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
    }
}
