import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int smallest1 = 2100000000;
    static int smallest2 = 2100000000;
    static int largest1 = 0;
    static int largest2 = 0;
    static int bestScore1 = 0;
    static int bestScore2 = 0;
    static int maxDifference = -2100000000;

    static ArrayList<Integer> nums1 = new ArrayList<>();
    static ArrayList<Integer> nums2 = new ArrayList<>();

    static int findBigger() {
        if(nums1.size() == 0)
            return -1;
        else if(nums2.size() == 0)
            return 1;
        if(nums1.get(nums1.size() - 1) > nums2.get(nums2.size() - 1))
            return 1;       // 1 is bigger
        else if(nums1.get(nums1.size() - 1).equals(nums2.get(nums2.size() - 1)))
            return 0;       //  equal
        else
            return -1;      // 2 is bigger
    }


    public static void main(String[] args) {

        int num1 = scanner.nextInt();
        for(int i = 0; i < num1; i++) {
            nums1.add(scanner.nextInt());
        }
        int num2 = scanner.nextInt();
        for(int i = 0; i < num2; i++) {
            nums2.add(scanner.nextInt());
        }

        Collections.sort(nums1);
        Collections.sort(nums2);

        int score1 = num1 * 2;
        int score2 = num2 * 2;
        int difference = score1 - score2;
        maxDifference = difference;
        bestScore1 = score1;
        bestScore2 = score2;

        while(nums1.size() > 0) {
            int a = findBigger();

            if(a == 1) {
                score1 += 1;
                difference++;
                nums1.remove(nums1.size() - 1);
            }
            else if(a == 0) {
                score1 += 1;
                score2 += 1;
                nums1.remove(nums1.size() - 1);
                nums2.remove(nums2.size() - 1);

            }
            else {

                score2 += 1;
                difference--;
                nums2.remove(nums2.size() - 1);
            }
            if(difference >= maxDifference) {
                maxDifference = difference;
                bestScore1 = score1;
                bestScore2 = score2;
            }

        }

        System.out.print("");
        System.out.println(bestScore1 + ":" + bestScore2);
    }
}
