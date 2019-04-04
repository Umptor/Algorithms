import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int moveDown(int size) {
        if(size == 0 || size == 1 || size == 2 || size == 3 )
            return 1;
        return moveDown(size - 1) + moveDown(size - 4);
    }

    static int getPrimes(int a) {
        int [] t = new int [a];
        t [0] = 2;
        int index = 1;
        int p = 1;
        boolean prime;
        while((p += 2) <= a) {
            prime = true;
            for(int i = 0; i < index; i++) {
                if(p % t[i] == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime) {
                t[index] = p;
                index++;
            }
        }
        int [] primes = new int [index];
        while(--index >= 0) {
            primes [index] = t [index];
        }
        return primes.length;

    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int a = moveDown(scanner.nextInt());
            //System.out.println(a);
            int count = 0;
            if(a == 1) {
                System.out.println(0);
                continue;
            }
            count = getPrimes(a);
            System.out.println(count);
        }
    }
}
