import javafx.util.Pair;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static ArrayList<Pair<Integer, Integer>> cookies = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Integer> answer = new ArrayList<>();

    static void checkSmaller() {
        for(int i = cookies.size() - 1; i >= 0; i--) {
            if(cookies.get(i).getValue() < cookies.get(cookies.size() - 1).getValue()) {
                cookies.remove(i);
            }
        }
    }

    static void outOfBounds(int index, int k) {
        if(cookies.get(0).getKey() <= index - k) {
            answer.add(cookies.get(0).getValue());
            cookies.remove(0);
        }
        else {
            answer.add(cookies.get(0).getValue());
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int i = 0;

        for(i = 0; i < k; i++) {
            cookies.add(new Pair<>(i, scanner.nextInt()));
            checkSmaller();
        }
        while(i < n) {
            cookies.add(new Pair<>(i, scanner.nextInt()));
            outOfBounds(i, k);
            checkSmaller();
            i++;
        }
        for(Integer a: answer)
            System.out.print(a + " ");
        System.out.print(cookies.get(0).getValue());
    }
}
