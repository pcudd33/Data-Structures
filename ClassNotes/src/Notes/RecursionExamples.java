package Notes;//examples of recursive functions

public class RecursionExamples {
    /**
     * compute the sum of numbers from n down to 1
     * @param n starting point
     * @return sum from n to 1
     */

    public static int sumNto1(int n){
        //base case
        if (n == 1){
            //we know the sum from 1 down to 1 is 1!
            return 1;
        }else{
            //recursive step
            return n + sumNto1(n-1);
        }
    }

    /**
     * RECURSIVLEY compute x raised to the power of n
     * @param x base case
     * @param n exponent
     * @return x^n
     */
   /* public static int power(double x, int n){
        //base case
        if (n == 0){
            return 1;
        }else{
            //recursive step -> x * x^(n -1)
            return  (x *  power(x, n-1));
        }
    }*/

    public static double power2(double x, int n){
        //base case
        if (n == 1){
            return x;
        }

        //compute the power of x^{n/2}
        //because we are dividing by 2 (and the argument is of type int)
        //this will automatically truncate n/2
        double result = power2(x, n/2);
        result *= result;

        if (n%2 != 0){
            result *= x;
        }
        return result;
    }

    public static int factorial(int n){
        if (n == 1)
            return 1;
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("the sum from 5 to 1 is " + sumNto1(5));
        System.out.println("the sum from 26 to 1 is " + sumNto1(26));
        System.out.println("2 to the 16 is " + power2(2, 16) );
        System.out.println("2 to the 13th is " + power2(2,13));
        System.out.println("5 factorial is "+ factorial(5));
    }
}
