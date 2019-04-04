import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    static int max = 0;

    static void moveUp(int n, int sum, ArrayList<Integer> nums, ArrayList<Integer> curSums) {  // Returns sum
        ArrayList<Integer> curNewSums = new ArrayList<>();
        if(curSums.size() != 0) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < curSums.size(); j++) {
                    int a = curSums.get(j) + nums.get(i);
                    if(a <= sum) {
                        if(a > max)
                            max = a;
                        if(!curNewSums.contains(a))
                            curNewSums.add(a);

                    }
                }
            }
            max++;
            max--;
            moveUp(n, sum, nums, curNewSums);
        }
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                nums.add(scanner.nextInt());
            }
            ArrayList<Integer> initial = new ArrayList<>();
            initial.add(0);
            moveUp(n, sum, nums, initial);
            nums.clear();
            System.out.println(max);
            max = 0;
        }

        scanner.close();
    }
}