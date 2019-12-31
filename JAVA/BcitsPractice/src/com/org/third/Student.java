package com.org.third;

public class Student{
        public static void main(String[] args) {
		
		StudentInfo s1=new StudentInfo();
		s1.setId(101);
		s1.setName("sonu");
		s1.setMarks(77.66);
		
		StudentInfo s2=new StudentInfo();
		s2.setId(201);
		s2.setName("sumit");
		s2.setMarks(66.77);
		
		StudentInfo s3=new StudentInfo();
		s3.setId(301);
		s3.setName("Rakash");
		s3.setMarks(80.66);
		
		StudentInfo s4=new StudentInfo();
		s3.setId(401);
		s3.setName("Abhilash");
		s3.setMarks(55.66);
		
		Object obj[]= {s1,s2,s3,s4};
		for (Object stu : obj) {
			System.out.println(stu);
		}
	}

}
