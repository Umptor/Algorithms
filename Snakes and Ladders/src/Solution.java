import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Integer> ladders = new ArrayList<>();
    static ArrayList<Integer> ladders2 = new ArrayList<>();
    static ArrayList<Integer> snakes = new ArrayList<>();
    static ArrayList<Integer> snakes2 = new ArrayList<>();
    static int n;
    static int m;
    static int bestTime = 2100000000;

    public static void moveUp(ArrayList<Pair<Integer, Integer>> spots, int time, int[] nums) {
        ArrayList<Pair<Integer, Integer>> curSpots = new ArrayList<>();
        if(spots.size() != 0) {
            for(int i = 0; i < spots.size(); i++) {
                for (int j = 1; j < 7; j++) {
                    int curTime = spots.get(i).getValue();
                    curTime++;
                    int a = spots.get(i).getKey() + j;
                    boolean added = false;
                    for (Pair p : curSpots)
                        if (p.getKey().equals(a))
                            added = true;
                    if (added)
                        continue;
                    int index = snakes.indexOf(a);
                    if(index != -1) {
                        if(curTime < nums[a]) {
                            int newValue = snakes2.get(index);
                            curSpots.add(new Pair<>(snakes2.get(index), curTime));
                            nums[a] = curTime;
                            a = newValue;

                        }
                    }
                    else {
                        index = ladders.indexOf(a);
                        if (index != -1 && curTime <= nums[a]) {
                            int newValue = ladders2.get(index);
                            curSpots.add(new Pair<>(newValue, curTime));
                            nums[a] = curTime;
                            a = newValue;
                        } else if (a < 100 && curTime <= nums[a]) {
                            curSpots.add(new Pair<>(a, curTime));
                            nums[a] = curTime;
                        }
                    }
                    if (a == 100) {
                        if (curTime < bestTime) {
                            bestTime = curTime;
                        }
                    }
                }
            }
            moveUp(curSpots, time, nums);
        }
    }

    public static void main(String args[]) {
        int tests = scanner.nextInt();

        for(int i = 0; i < tests; i++) {
            int[] nums = new int[101];
            Arrays.fill(nums, 2100000000);
            n = scanner.nextInt();

            for(int j = 0; j < n; j++) {
                ladders.add(scanner.nextInt());
                ladders2.add(scanner.nextInt());
            }

            m = scanner.nextInt();
            for(int j = 0; j < m; j++) {
                snakes.add(scanner.nextInt());
                snakes2.add(scanner.nextInt());
            }

            ArrayList<Pair<Integer, Integer>> start = new ArrayList<>();
            start.add(new Pair<>(1, 0));
            moveUp(start, 0, nums);

            ladders.clear();
            ladders2.clear();
            snakes.clear();
            snakes2.clear();
            if(bestTime == 2100000000)
                bestTime = -1;
            System.out.println(bestTime);
            bestTime = 2100000000;
            start.clear();

        }

    }

}
