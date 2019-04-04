package com.company;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int newPole = 0;
        int poleCount = 0;
        int found = -1;
        int lastPole = 0;

        String cities = scanner.nextLine();
        cities = scanner.nextLine();
        cities = cities.replaceAll("\\s", "");

        for(int i = r - 1; i >= 0; i--) {
            if(cities.charAt(i) == '1') {
                found = 1;
                newPole = i;
                poleCount++;
                lastPole = i;
                break;
            }
        }

        if(found != 1) {
            System.out.println(-1);
            return;
        }

        for(int i = newPole; i < n; i++) {
            found = -1;
            int j = lastPole + 2 * (r) - 1;
            if(j >= n) {
                for(int k = n - 1; k > n - r - 1; k--) {
                    if(cities.charAt(k) == '1') {
                        found = 1;
                        if(k != lastPole)
                            poleCount++;
                        break;
                    }
                }
                if(found != 1) {
                    System.out.println("-1");
                    return;
                }
                break;
            }
            while(j > i) {
                if(cities.charAt(j) == '1') {
                    found = 1;
                    lastPole = j;
                    i = j - 1;
                    poleCount++;
                }
                j--;
            }
            if(found == -1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(poleCount);
    }
}
/*
12 4
101101100000
*/