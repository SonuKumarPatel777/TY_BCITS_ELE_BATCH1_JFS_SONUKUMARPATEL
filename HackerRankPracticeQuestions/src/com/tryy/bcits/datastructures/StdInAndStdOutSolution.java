package com.tryy.bcits.datastructures;

import java.util.Scanner;

public class StdInAndStdOutSolution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Integer ");
        int i = scan.nextInt();
        System.out.println("Enter the Double Valu");
        double d = scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter the String ");
        String s = scan.nextLine();
        

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        
    }//End of main();
}//End of Class
