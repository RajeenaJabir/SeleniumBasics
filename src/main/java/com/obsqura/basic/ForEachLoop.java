package com.obsqura.basic;

import java.util.Arrays;

public class ForEachLoop {
    public  static  void main(String[] args) {
        int a[][] = new int[2][2];
        a[0][0] = 10;
        a[0][1] = 20;
        a[1][0] = 30;
        a[1][1] = 40;
        for (int i[] : a) {
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
            }
        }
    }
