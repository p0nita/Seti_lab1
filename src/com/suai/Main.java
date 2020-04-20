package com.suai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input g(x): ");
        String gx = sc.nextLine();
        Polynom g = new Polynom(gx.length()-1, gx);

        System.out.println("Input m(x): ");
        String mx = sc.nextLine();
        Polynom m = new Polynom(mx.length()-1, mx);

        System.out.println("Input k: ");
        int k = sc.nextInt();
        Coder c = new Coder(g, m, k);
        sc.nextLine();
        Polynom a = c.start();
        int size = a.getDeg();
        System.out.println("Input vector e(x): ");
        String er = sc.nextLine();
        if(size > er.length()){
            System.out.println("Input " + (size-er.length()+1) + " symbols!");
            er+=sc.nextLine();
        }
        Polynom e = new Polynom(size, er);
        Decoder d = new Decoder(e,a,g);
        boolean error = d.start();
        System.out.println("Was there an error? --- " + error);
    }
}