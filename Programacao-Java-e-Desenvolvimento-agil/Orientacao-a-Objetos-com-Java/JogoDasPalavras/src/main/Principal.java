package main;

import java.util.Scanner;

public class Principal {
	
	private static String palavras;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Palavras 1");
		palavras = new String(sc.nextLine());
		System.out.println(palavras);
	}

}
