package com.fft.util;

import com.fft.Complex.Complex;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;

import static java.lang.Math.*;

/**
 * 计算单位根
 * */
public class TwiddleFactor {

    public static final double SQRT2_2 =sqrt(2)/2;


    /**
     * 计算半个周期的单位根
     * */
    public static Complex[] twiddles(@NotNull int n){
        Complex[] res=new Complex[n];
        for (int i = 0; i < n; i++) {
            res[i]=new Complex();
        }

        final double unit=2*PI/n;
        final double S=sin(unit);
        final double C=1-2*sin(unit/2)*sin(unit/2);

        int L=n/8;

        res[0].real(1);
        res[0].imag(0);
        for (int i = 0; i < L-1; i++) {
            res[i+1].real(C*res[i].real()-S*res[i].imag());
            res[i+1].imag(S*res[i].real()+C*res[i].imag());
        }
        res[L].real(SQRT2_2);
        res[L].imag(SQRT2_2);
        for (int i = 1; i < L; i++) {
            res[L+i].real(res[L-i].imag());
            res[L+i].imag(res[L-i].real());
        }
        L<<=1;
        res[L].real(0);
        res[L].imag(1);
        for (int i = 1; i < L; i++) {
            res[L+i].real(-res[L-i].real());
            res[L+i].imag(res[L-i].imag());
        }

        for (Complex c:res){
            System.out.println(c.toString());
        }

        L<<=1;
        for (int i = 0; i < L; i++) {
            res[L+i].real(res[L-i].real());
            res[L+i].imag(-res[L-i].imag());
        }
        return res;
    }
}
