import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> failNums;
    static ArrayList<Character> chars;
    static int maxLength = 0;

    public static ArrayList<Integer> search(int a, ArrayList<Character> arr, ArrayList<Integer> failNums) {
        for (int i = 2; i <= a; i++) {
            char x = chars.get(failNums.get(i - 1) + 1);
            char y = chars.get(i);
            if(x == y) {
                failNums.set(i, failNums.get(i - 1) + 1);
                if(failNums.get(i) > maxLength && i != a)
                    maxLength = failNums.get(i);
            }
            else if(i != failNums.size() - 1) {
                if(chars.get(1) == chars.get(i)) {
                    failNums.set(i, 1);
                }
            }


        }
        return failNums;
    }

    public static void main(String[] args) {


        String s = scanner.nextLine();
        int a = s.length();
        failNums = new ArrayList<>();
        Collections.fill(failNums, 0);
        chars = new ArrayList<>();
        chars.add('0');
        for (int i = 1; i <= a; i++) {
            chars.add(s.charAt(i - 1));
            failNums.add(0);
        }
        failNums.add(0);

        failNums = search(a, chars, failNums);

        System.out.println(failNums.toString());

        if(failNums.get(failNums.size() - 1) <= maxLength) {

            for (int i = 0; i < failNums.get(failNums.size() - 1); i++) {
                System.out.print(chars.get(i + 1));
            }
        }
        else {
            if(failNums.get(failNums.get(failNums.size() - 1)) == 0) {
                System.out.println(-1);
                return;
            }
            for(char z: chars.subList(chars.size() - failNums.get(failNums.size() - 1), failNums.get(failNums.size() - 1) + 1))
                System.out.print(z);
            }


        if(failNums.get(a) == 0) {
            System.out.println(-1);
            return;
        }
        if(failNums.get(failNums.size() - 1) > a /2) {

        }

    }
}
