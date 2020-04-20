package com.suai;

public class Polynom {

    private int deg;
    private int[] nums;

    public Polynom(int d, String n){
        deg = d;
        nums = new int[deg+1];
        char c[] = n.toCharArray();
        for (int i = deg; i >= 0; i--) {
            if (c[i] == '0') nums[deg-i] = 0;
            if (c[i] == '1') nums[deg-i] = 1;
        }
    }

    public Polynom(int s, Polynom p){
        String oldPoly = p.toString();
        for (int i = 0; i < s; i++)
            oldPoly += "0";
        deg = s+p.getDeg();
        nums = new int[deg+1];
        char c[] = oldPoly.toCharArray();
        for (int i = deg; i >= 0; i--) {
            if (c[i] == '0') nums[deg-i] = 0;
            if (c[i] == '1') nums[deg-i] = 1;
        }
    }

    public Polynom xor(Polynom b){
        int newDeg = deg;
        StringBuilder n = new StringBuilder();
        int[] bNums = b.getNums();
        int indx = -1;
        for (int i = deg; i >= 0; i--){
            if (nums[i] != bNums[i]){
                if (indx == -1) indx = i;
                n.append("1");
            }
            else if (indx != -1) n.append("0");
        }
        String res = n.toString();
        if (indx == -1) return new Polynom(0, "0");
        return new Polynom(indx, res);
    }

    public Polynom mod(Polynom b){
        Polynom c = new Polynom(0, "0");
        if (deg < b.getDeg()) return c;
        Polynom a = new Polynom(0, this);
        while (true) {
            Polynom b1 = new Polynom(a.deg - b.deg, b);
            c = b1.xor(a);
            if (c.deg < b.deg) break;
            a = c;
        }
        return c;
    }

    public Polynom plus(Polynom c){
            int [] bNums = c.getNums();
            StringBuilder sb = new StringBuilder();
            int i = deg;
            while (i > c.deg){
                sb.append(nums[i]);
                i--;
            }
            for (i = c.deg; i >= 0; i--){
                sb.append(bNums[i]);
            }
            return new Polynom(deg, sb.toString());

    }

    public int getDeg(){
        return deg;
    }

    public int[] getNums(){
        return nums;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = deg; i >= 0; i--) {
            switch (nums[i]) {
                case 0:
                    sb.append("0");
                    break;
                case 1:
                    sb.append("1");
            }
        }
        return sb.toString();
    }
}