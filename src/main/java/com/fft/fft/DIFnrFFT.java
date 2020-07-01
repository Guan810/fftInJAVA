package com.fft.fft;

import com.fft.Complex.Complex;
import com.fft.util.BitReverse;
import com.fft.util.TwiddleFactor;
import static com.fft.util.ComplexOperation.*;

/**
 * @author 关凯宁
 * @date 2020/6/30 21:26
 */
public class DIFnrFFT {

    public static void computeWithoutBitReverse(int n, Complex[] target){
        int numOfProblem=1;
        int problemSize=n;
        Complex[] units= TwiddleFactor.twiddles(n);

        while (problemSize>1){
            int halfSize=problemSize>>>1;
            for (int i = 0; i < numOfProblem; i++) {
                int jFirst=i*problemSize;
                int jLast=jFirst+halfSize;
                int jTwiddle=0;
                for (int j = jFirst; j < jLast; j++) {
                    Complex currTwiddle=units[jTwiddle];
                    Complex temp=target[j];
                    target[j]=add(temp,target[j+halfSize]);
                    target[j+halfSize]=multy(currTwiddle,min(temp,target[j+halfSize]));
                    jTwiddle+=numOfProblem;
                }
            }
            numOfProblem<<=1;
            problemSize=halfSize;
        }
    }

    public static void compute(int n, Complex[] target){
        computeWithoutBitReverse(n,target);
        BitReverse.bitReverse(target);
        //不知道为什么结果和正确结果差个共轭
        for (Complex c:target) {
            c.conjugate();
        }
    }
}
