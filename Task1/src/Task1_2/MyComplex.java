package Task1_2;

/**
 * Created by Boris on 11.10.2017.
 */
public class MyComplex {

    private double real = 0;
    private double imag = 0;

    public MyComplex() {
    }

    public MyComplex(double real, double imaag) {
        this.real = real;
        this.imag = imaag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" +
                real +
                "+" + imag +
                "i)";
    }

    public boolean isReal(){
        return (real!=0);
    }

    public boolean isImaginary(){
        return (imag!=0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyComplex myComplex = (MyComplex) o;

        if (Double.compare(myComplex.real, real) != 0) return false;
        return Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals (double real, double imag){
        return ((this.real==real)&&(this.imag==imag));
    }

    public double magnitude(){
        return Math.sqrt(real*real+imag*imag);
    }

    public double argument(){
        if (magnitude()==0) return Double.NaN;
        return Math.asin(imag/magnitude());
    }

    public MyComplex add(MyComplex mc){
        real+=mc.getReal();
        imag+=mc.getImag();
        return this;
    }

    public MyComplex subtract(MyComplex mc){
        real-=mc.getReal();
        imag-=mc.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex mc){
        MyComplex res = new MyComplex(real+mc.getReal(), imag+mc.getImag());
        return res;
    }

    public MyComplex subtractNew(MyComplex mc){
        MyComplex res = new MyComplex(real-mc.getReal(), imag-mc.getImag());
        return res;
    }

    public MyComplex multiply(MyComplex mc){
        real=real*mc.getReal()-imag*mc.getImag();
        imag = real*mc.getImag()+imag*mc.getReal();
        return this;
    }

    public MyComplex conjugate(){
        MyComplex res = new MyComplex(real, (-1)*imag);
        return res;
    }

    public MyComplex divide(MyComplex mc){
        multiply(mc.conjugate());
        double coef = mc.getReal()*mc.getReal()-mc.getImag()*mc.getImag();
        if (coef==0) {
            real = Double.NaN;
            imag = Double.NaN;
        }
        else {
            real /= coef;
            imag /= coef;
        }
        return this;
    }
}
