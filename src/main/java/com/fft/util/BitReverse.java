package com.fft.util;

import java.util.Arrays;

/**
 * @author 关凯宁
 * @date 2020/6/30 21:41
 */
public class BitReverse {

    public static <T> void bitReverse(T[] input){
        final int length = input.length;
        boolean[] mark=new boolean[length];
        int bitLength= Integer.toBinaryString(length).length()-1;
        Arrays.fill(mark,false);
        for (int i = 0; i < length; i++) {
            if(!mark[i]){
                int other=bitReverseForInteger(i,bitLength);

                if(i!=other){
                    T temp=input[i];
                    input[i]=input[other];
                    input[other]=temp;
                    mark[other]=true;
                }

                mark[i]=true;
            }
        }
    }

    public static int bitReverseForInteger(int i,int len) {
        int res=0;
        while(len>0){
            res<<=1;
            res^=i&1;
            len--;
            i>>=1;
        }
        return res;
    }
}
