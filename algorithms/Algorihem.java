package com.ty.bcits.algorithms;

import java.time.Duration;
import java.time.Instant;

public class Algorihem {
	public static Long addUpto(Long number) {
		Long total = 0L;
		for(int i = 0;i <= number; i++) {
			total = total + i;
		}
		return total;
	}
	
	public static Long addUptoQuick(Long number) {
		return number *(number + 1)/2;
	}
	
    public static void countDurationonAddUpto() {
    	Long number = 999999L;
    	Instant start = Instant.now();
    	System.out.println(addUpto(number));
    	Instant end = Instant.now();
    	long duration = Duration.between(start, end).toMillis();
    	double second = duration/1000.0;
    	System.out.println("addUpto took "+second+" Sec");
		
	}
    public static void countDurationonAddUptoQuick() {
    	Long number = 999999L;
    	Instant start = Instant.now();
    	System.out.println(addUptoQuick(number));
    	Instant end = Instant.now();
    	long duration = Duration.between(start, end).toMillis();
    	double second = duration/1000.0;
    	System.out.println("addUptoQuick took "+second+" Sec");
		
	}
    public static void main(String[] args) {
    	countDurationonAddUpto();
    	countDurationonAddUptoQuick();
	}
}
