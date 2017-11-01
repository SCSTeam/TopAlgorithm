package jerry.binarysearch;

public class LC50_pow {
    public static void main(String[] args) {
        LC50_pow sol = new LC50_pow();
        double x = 2.0;
        int n = 3;

        System.out.println(sol.myPow(x, n));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double result = myPow(x * x, n / 2);
        if (n % 2 == 1) {
            result *= x;
        }

        return result;
    }
}
