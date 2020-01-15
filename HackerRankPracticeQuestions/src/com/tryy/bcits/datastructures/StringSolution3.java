package com.tryy.bcits.datastructures;

import java.util.Scanner;

public class StringSolution3 {

    public static void main(String[] args) {
    	System.out.println(" Enter your String");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
       String[] splitString = (s.replaceAll("^[\\W+\\s+]", "").split("[\\s!,?._'@]+"));
            System.out.println(splitString.length);
            for (String string : splitString) {
                System.out.println(string);
              }
     }//End Of Main
    
}//End Of Class