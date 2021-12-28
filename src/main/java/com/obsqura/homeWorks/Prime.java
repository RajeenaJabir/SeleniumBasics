package com.obsqura.homeWorks;

import java.util.Scanner;

public class Prime extends PrimeNumberUsingInheritance{
    public static void main(String[] args) {
        int min,max;
        Scanner sc = new Scanner(System.in);
        System.out.printf( "Enter lower bound :: ");
        min= sc.nextInt();
        System.out.printf( "\nEnter upper bound :: ");
        max= sc.nextInt();
        System.out.printf("\nPrime numbers between %d and %d are: ", min,max);
        for(int n=min;n<=max;n++) {
            if(PrimeNumberUsingInheritance.isPrime(n)) {
                System.out.println(n);
            }
        }
    }
}
