import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static class fret {
        ArrayList<Integer> held = new ArrayList<>(3000000);

        public fret() {
            for(int i = 0; i < 3000000; i++) {
                held.add(0);
            }
        }
        public int hold(int a) {
            if(isLarger(a) == 1) {
                held.add(0, a);
                return 1;
            }
            else if(isLarger(a) == 0) {
                return 0;
            }
            else {
                int r = release(a);
                return r++;

            }
        }

        int isLarger(int a) {
            if(a > held.get(0))
                return 1;
            else if(a == held.get(0))
                return 0;
            else return -1;
        }

        int release(int a) {
            int i = 0;
            int m = 0;
            while(i < held.size() - 1) {
                if (a < held.get(0)) {
                    held.remove(0);
                    m++;
                }
                else if(a == held.get(0))
                    return m;
                else {
                    return ++m;
                }
            }
            return m;
        }
    }

    static fret[] s = new fret[10];

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int f = scanner.nextInt();
        int m = 0;

        for(int i = 0; i < 10; i++)
            s[i] = new fret();


        for(int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            m+= s[a].hold(b);
            /*
            if(b == max[a + 1]) {
                continue;
            }
            else if(b > max[a + 1]) {
                s[a + 1][b + 1] = max[a + 1];
                max[a + 1] = b;
                m++;
            }
            else {
                m+= release(a + 1, b + 1);
                if(b != max[a + 1])
                    m++;
            }
            */
        }
        System.out.print(m);
    }
}

