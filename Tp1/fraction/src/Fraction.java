//trying modification

import java.math.BigInteger;

public class Fraction {
    private BigInteger num;
    private BigInteger den;


    public Fraction(int num, int den) {
       this(BigInteger.valueOf(num),BigInteger.valueOf(den));
    }

    public Fraction(BigInteger num, BigInteger den) {
        this.num=num;
this.den=den;
    }


    public Fraction(BigInteger num) {
        this.den.valueOf(1);
        this.num = num;
    }

    public BigInteger getNum() {
        return this.num;
    }

    public BigInteger getDen() {
        return this.den;
    }

    public Fraction add(Fraction b) {
        num = num.multiply(b.getDen()).add((den).multiply(b.getNum()));
        den = den.multiply(b.getDen());
        return this;
    }

    public Fraction sub(Fraction b) {
        num = num.multiply(b.getDen()).subtract(den.multiply(b.getNum()));
        den = den.multiply(b.getDen());
        return this;
    }

    public Fraction mult(Fraction b) {
        this.num = this.num.multiply(b.getNum());
        this.den = this.den.multiply((b.getDen()));
        return this;
    }

    public Fraction divi(Fraction b) {

        this.num = this.num.multiply(b.getDen());
        this.den = this.den.multiply(b.getNum());
        return this;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "num=" + num +
                ", den=" + den +
                '}';
    }
    public double doubleValue1()
    {
        double c=((this.num).doubleValue()/(this.den).doubleValue());
   return c;
    }

}
