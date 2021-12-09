package com.obsqura.basic;

public class Sample {
    public void display() {
        int cntr = 0;
        for (int i = 2; i <= 50; i++) {
            int r = i % 2;
            if (r == 0) {
                cntr = cntr + i;
            }
        }
        System.out.print(cntr);
    }
}
