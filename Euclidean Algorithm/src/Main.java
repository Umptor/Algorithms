import java.util.Scanner;

public class Main {

    static int first_a;
    static int first_b;

    static int euclid(int a, int b) {
        System.out.println("a = " + a + "   |   b = " + b);


        if(a == 0)
            return b;
        else if(b == 0)
            return a;
        else
            return euclid(b % a, a);
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Geben Sie a und b ein");

        int a = s.nextInt();
        int b = s.nextInt();
        first_a = a;
        first_b = b;

        System.out.print(euclid((13*a + 8*b), (5*a + 3*b)));
    }
}
