package com.fft.util;

import com.fft.Complex.Complex;

/**
 * @author 关凯宁
 * @date 2020/6/30 20:51
 */
public class ComplexOperation {

    public static Complex add(Complex o1,Complex o2){
        return new Complex(o1.real()+o2.real(),
                o1.imag()+o2.imag());
    }

    public static Complex min(Complex o1,Complex o2){
        return new Complex(o1.real()-o2.real(),
                o1.imag()-o2.imag());
    }

    public static Complex multy(Complex o1,Complex o2){
        return new Complex(o1.real()*o2.real()-o1.imag()*o2.imag(),
                o1.imag()*o2.real()+o1.real()*o2.imag());
    }

    public static Complex divide(Complex o1,Complex o2) {
        double mod=mod(o2);
        return new Complex((o1.real()*o2.real()+o1.imag()*o2.imag())/mod,(o1.imag()*o2.real()-o1.real()*o2.imag())/mod);
    }

    public static double mod(Complex o){
        return o.real()*o.real()+o.imag()*o.imag();
    }
}
