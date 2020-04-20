package com.suai;

import java.util.Arrays;

public class Coder {
   public Polynom g;
   public Polynom m;
   public Polynom c;
   public Polynom t;
   public int k;
   public int r;

    public Coder(Polynom g, Polynom m, int k){
        this.g = g;
        this.m = m;
        this.k = k;
        r = g.getDeg();
    }

    public Polynom start(){
        multi();
        return calcA();
    }

    public void multi() {
        /*int [] array = m.getNums();
        int[] array1 = new int[array.length+r];
        for(int i = 0; i < array.length; i++){
            if(array[i] == 1) array1[i+r] = 1;
        }
        System.out.println(Arrays.toString(array1));

        StringBuilder n = new StringBuilder();
        int i = array1.length-1;
        while (i >= 0){
            if (array1[i] == 1){
                n.append("1");
            }
            else n.append("0");
            i--;
        }
        String str = n.toString();
        System.out.println("m(x)*x^r = "+str);
        //String str = Arrays.toString(m.getNums());*/
        t = new Polynom(r, m);
        System.out.println("m(x)*x^r = "+ t.toString());
        System.out.println("Deg m(x)*x^r = "+ t.getDeg());
        c = t.mod(g);
        System.out.println("c(x) = " + Arrays.toString(c.getNums()));
    }

    public Polynom calcA(){
        Polynom a = t.plus(c);
        System.out.println("a(x) = " + Arrays.toString(a.getNums()));
        return a;
    }
}
