package com.obsqura.basic;

import java.util.Scanner;

public class subtraction {
    public static void main(String args[]){
        float a,b,c;

        Scanner sc =new Scanner(System.in);
        System.out.print("ENTER first NUMBER:");
        a=sc.nextFloat();
        System.out.print("ENTER second NUMBER:");
        b=sc.nextFloat();
        c=a-b;
        System.out.print("Result="+c);


    }
}
