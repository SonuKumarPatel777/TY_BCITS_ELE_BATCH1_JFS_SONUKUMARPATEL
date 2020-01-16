package com.tryy.bcits.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
private int id;
String sname;
double cgpa;

Student(int id, String fname, double cgpa) {
this.id = id;
this.sname = fname;
this.cgpa = cgpa;
}
@Override
public String toString() {
return "Stu ID="+this.id+"Std name="+this.sname+"std Cgpa="+this.cgpa ;
}

}// End of Student Class
class SortingStudent implements Comparator<Student>{
@Override
public int compare(Student s1, Student s2) {
if(s2.cgpa>s1.cgpa){
            return 1;
        }else if(s2.cgpa<s1.cgpa){
            return -1;
        }
        return s1.sname.compareTo(s2.sname);
    }//End of Compare method

}//End of Class

public class SolutionSort {
public static void main(String[] args) {
System.out.println("Enter the  number of students ");
Scanner scn = new Scanner(System.in);
int n = scn.nextInt();
Student student [] = new Student[n];

for (int i = 1; i <= n; i++) {
System.out.println("Enter the " + i + "student Id");
int id = scn.nextInt();
System.out.println("Enter the " + i + "student name");
String sname = scn.next();
System.out.println("Enter the " + i + "student cgpa");
double cgpa = scn.nextDouble();
            Student std=new Student(id,sname,cgpa);
            student[i-1]= std;
}
Arrays.sort(student,new SortingStudent());
for (Student student2 : student) {
System.out.println(student2.toString());

}


}// End of main

}// End of Class


