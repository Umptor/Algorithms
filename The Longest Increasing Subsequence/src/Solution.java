import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static Scanner s = new Scanner(System.in);

    static int[] series;
    static int[] result;

    static int findGreatest(int a, int b, int c)
    {
        while (b - a > 1)
        {
            int m = a + (b - a)/2;
            if (result[m]>=c)
                b = m;
            else
                a = m;
        }

        return b;
    }

    public static void main(String[] args) {

        int a = s.nextInt();
        series = new int[a];
        result = new int[a];
        Arrays.fill(result, 0);
        int last = 1;
        result[0] = s.nextInt();

        for (int i = 1; i < a; i++) {
            int b = s.nextInt();
            if (b < result[0])
                result[0] = b;
            else if (b > result[last - 1])
                result[last++] = b;
            else
                result[findGreatest(-1, last - 1, b)] = b;
        }


        System.out.println(last);

    }
}