package com.pablo.utils;
import java.util.Scanner;

public class Calculadora {
	static int result;
	static void suma(int a, int b){
	result = a +b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int first =scan.nextInt();
		int second = scan.nextInt();
		suma(first,second);
		System.out.print(result);
	}

}
