import java.io.*;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getCommonPrime(int a, int b) {
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {


        int red = scanner.nextInt();
        int green = scanner.nextInt();
        int initialRed = red;
        int initialGreen = green;

        System.out.println("1 " + red + " " + green);

        ArrayList<Integer> commonPrimes = new ArrayList<>();
        ArrayList<Integer> newFactors = new ArrayList<>();
        ArrayList<Integer> newFactors2 = new ArrayList<>();

        newFactors.add(1);

        while (red != 1 && green != 1) {
            int common = getCommonPrime(red, green);
            if (common == -1)
                break;
            if (commonPrimes.indexOf(common) != -1)
                newFactors.add(common);
            commonPrimes.add(common);
            red /= common;
            green /= common;

        }

        ArrayList<Integer> printed = new ArrayList<>();
        ArrayList<Integer> used = new ArrayList<>();


        int c = 1;

        while (commonPrimes.size() > 0) {
            ArrayList<Integer> arr;
            ArrayList<Integer> arr2;
            if (c % 2 == 1) {
                arr = newFactors;
                arr2 = newFactors2;
            } else {
                arr = newFactors2;
                arr2 = newFactors;
            }

            for (int i = 0; i < commonPrimes.size(); i++) {              // Go through primes
                if (used.indexOf(commonPrimes.get(i)) != -1)             // If used, continue
                    continue;


                for (Integer num : arr) {
                    int newFactor = commonPrimes.get(i) * num;
                    if(printed.indexOf(newFactor) == -1) {
                        System.out.println(newFactor + " " + initialRed / newFactor + " " + initialGreen / newFactor);
                        printed.add(newFactor);
                    }
                    if(num != 1)
                        arr2.add(newFactor);
                }

                used.add(commonPrimes.get(i));
                commonPrimes.remove(i);
                i--;
            }
            arr.clear();
            used.clear();
            c++;
        }




        /*

        ArrayList<Integer> printed = new ArrayList<>();
        int initialSize = commonPrimes.size();

        for(int i = 0; i < initialSize; i++) {
            if(commonPrimes.indexOf(commonPrimes.get(i)) == i) {
                printed.add(commonPrimes.get(i));
                System.out.println(commonPrimes.get(i) + " " + initialRed / commonPrimes.get(i) + " " + initialGreen / commonPrimes.get(i));
            }
            int j = i + 1;
            while(j < commonPrimes.size()) {
                int newFactor = commonPrimes.get(i) * commonPrimes.get(j);
                if(printed.indexOf(newFactor) == -1) {
                    System.out.println(newFactor + " " + initialRed / newFactor + " " + initialGreen / newFactor);
                    commonPrimes.add(newFactor);
                    printed.add(newFactor);
                }
                j++;
            }
            i++;
        }
    }
        */
    }
}

// 40320 362880