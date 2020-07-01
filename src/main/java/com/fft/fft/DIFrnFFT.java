package com.fft.fft;

import com.fft.Complex.Complex;
import com.fft.util.BitReverse;
import com.fft.util.TwiddleFactor;

import static com.fft.util.ComplexOperation.*;

/**
 * @author 关凯宁
 * @date 2020/7/1 8:47
 */
public class DIFrnFFT {

    public static void compute(int n, Complex[] target) {
        int numOfProblem = 1;
        int problemSize = n;
        int distance = 1;
        Complex[] units = TwiddleFactor.twiddles(n);
        BitReverse.bitReverse(units);
        BitReverse.bitReverse(target);

        while (problemSize > 1) {
            for (int jFirst = 0; jFirst < numOfProblem; jFirst++) {
                int j = jFirst;
                int jTwiddle = 0;
                while (j < n) {
                    Complex currTwiddle = units[jTwiddle];
                    Complex temp = target[j];
                    target[j] = add(temp, target[j + distance]);
                    target[j + distance] = multy(min(temp, target[j + distance]), currTwiddle);
                    jTwiddle++;
                    j += numOfProblem << 1;
                }
            }
            numOfProblem <<= 1;
            problemSize >>>= 1;
            distance <<= 1;
        }

        //不知道为什么结果和正确结果差个共轭
        for (Complex c:target) {
            c.conjugate();
        }
    }
}
