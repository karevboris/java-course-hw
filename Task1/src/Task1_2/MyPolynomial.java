package Task1_2;

import java.lang.reflect.Member;
import java.util.Arrays;

/**
 * Created by Boris on 11.10.2017.
 */
public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double ... coeffs) {
        this.coeffs = coeffs;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public int getDegree(){
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String res=null;
        for (int i=coeffs.length; i>0; i--){
            res+="("+coeffs[i]+")*x^"+i+"+";
        }
        res+=coeffs[0];
        return res;
    }

    public double evaluate(double x){
        double res = 0;
        for (int i=0; i<=coeffs.length; i++){
            res+=coeffs[i]*Math.pow(x, i);
        }
        return res;
    }

    public MyPolynomial add(MyPolynomial mp){
        double [] c = coeffs.clone();
        for (int i=0; i<=coeffs.length; i++){
            c[i]+=mp.getCoeffs()[i];
        }
        MyPolynomial res = new MyPolynomial(c);
        return res;
    }

    public MyPolynomial multiply(MyPolynomial mp){
        double [] c = new double[getDegree()+mp.getDegree()+1];
        for (int i= getDegree(); i>=0; i--)
            for(int j=mp.getDegree(); i>=0; i--){
            c[i+j]+=coeffs[i]*mp.getCoeffs()[j];
            }
            MyPolynomial res = new MyPolynomial(c);
        return res;
    }
}
