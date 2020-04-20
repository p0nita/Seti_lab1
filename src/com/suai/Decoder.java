package com.suai;

public class Decoder {
    public Polynom e;
    public Polynom a;
    public Polynom g;
    public Polynom b;

    public Decoder(Polynom e, Polynom a, Polynom g){
        this.e = e;
        this.a = a;
        this.g = g;
    }

    public boolean start(){
        calcB();
        return syndrome();
    }
    public void calcB(){
        b = a.xor(e);
        System.out.println("b(x) = " + b.toString());
    }

    public boolean syndrome(){
        Polynom s = b.mod(g);
        int [] nums = s.getNums();
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==1) return true;
        }
        return false;
    }
}
