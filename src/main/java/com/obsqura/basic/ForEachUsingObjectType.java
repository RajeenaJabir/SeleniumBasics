package com.obsqura.basic;

public class ForEachUsingObjectType {
    public static void main(String args[]){
        Object a[][]=new Object[3][2];
        a[0][0]=10;
        a[0][1]="hai";
        a[1][0]=10.9888;
        a[1][1]="My first attempt";
        a[2][0]=101;

        for (Object[] i :a) {
            for (Object j:i) {
                System.out.print(j+"    ");
            }
            System.out.println();
        }
    }
}
