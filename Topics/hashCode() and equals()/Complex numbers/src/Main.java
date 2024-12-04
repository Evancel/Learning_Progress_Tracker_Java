import java.util.Objects;

class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof ComplexNumber complexNumber)) {
            return false;
        }

        return this.re == complexNumber.getRe() &&
                this.im == complexNumber.getIm();
    }

    @Override
    public int hashCode() {
        int result = 17;
        long reBits = Double.doubleToLongBits(re);
        long imBits = Double.doubleToLongBits(im);
        result = 31 * result + (int) (reBits ^ (reBits >>> 32));
        result = 31 * result + (int) (imBits ^ (imBits >>> 32));
        System.identityHashCode(james);
        return result;
    }
}