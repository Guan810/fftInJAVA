package com.fft.Complex;

/**
 * @author 关凯宁
 * @date 2020/6/30 20:46
 */
public class Complex {

    public static final Complex UNIT=new Complex(0,1);

    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(){
        this.real=0;
        this.imag=0;
    }

    public Complex(double real){
        this.real=real;
        this.imag=0;
    }

    public double real(){
        return real;
    }

    public double imag(){
        return imag;
    }

    public void real(double r){
        real=r;
    }

    public void imag(double i){
        imag=i;
    }

    @Override
    public String toString() {
        return real+"\t"+imag;
    }

    public Complex conjugate(){
        this.imag=-this.imag;
        return this;
    }
}
