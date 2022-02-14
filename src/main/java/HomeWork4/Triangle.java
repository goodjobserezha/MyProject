package HomeWork4;

public class Triangle {
    public static void main(String[] args) {

        Parties (3, 5, 7);

    }

    public static double Parties(int a, int b, int c) {

        double p = ((double)(a+b+c))/2;

        if (p <= a || p <= b || p <= c || a*b*c==0) {

            return -1;
        }
        double S = Math.sqrt(p*(p - a)*(p - b)*(p - c));

        if (a == b && b == c) {
            System.out.println(" The area of the triangle is " + S + " Equilateral triangle");
        } else if (a==b || a==c || b==c) {
            System.out.println(" The area of the triangle is " + S + " Isosceles triangle");
        } else if (S == 0.5*a*b || S == 0.5*a*c || S == 0.5*c*b){
            System.out.println(" The area of the triangle is " + S + " Scalene triangle");
        }
        return S;
    }

}