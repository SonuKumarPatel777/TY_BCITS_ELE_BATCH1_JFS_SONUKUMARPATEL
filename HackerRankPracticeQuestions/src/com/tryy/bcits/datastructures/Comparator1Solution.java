package com.tryy.bcits.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "name=" + name + ", score=" + score;
	}
	
	
	
}// End of Player Class

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player a1, Player a2) {
		if (a1.score < a2.score) {
			return 1;
		} else if (a1.score > a2.score) {
			return -1;
		} else {
			return a1.name.compareTo(a2.name);
		}
	}
}// End of Checker Class

 public class Comparator1Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of players ");
		int n = scan.nextInt();
		Player[] player = new Player[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the " + (i+1) + " Player name ");
			String name = scan.next();
			System.out.println("Enter the " + (i+1) + " Player score ");
			int score = scan.nextInt();
			player[i] = new Player(name, score);
		}
		Checker chek = new Checker();
		Arrays.sort(player, chek);
		for (Player player2 : player) {
			System.out.println(player2.toString());
		}
	}// End of main method

}// End of Text Class
