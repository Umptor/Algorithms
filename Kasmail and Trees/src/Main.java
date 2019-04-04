import java.io.*;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static int getMax(int[] arr) {
        int index = 0;
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int treeCount = scanner.nextInt();
        int M = scanner.nextInt();
        int[] trees =  new int[treeCount];

        for(int i = 0; i < treeCount; i++)
            trees[i] = scanner.nextInt();

        int cut = 0;
        int multiplier = 1;
        int longestIndex = getMax(trees);
        int longestTree = trees[longestIndex];
        int highest = 0;

        while(cut < M) {

            trees[longestIndex] = 0;
            int newLongestIndex = getMax(trees);
            int newLongestTree = trees[newLongestIndex];
            if(M > cut + multiplier * (longestTree - newLongestTree)) {
                cut += multiplier * (longestTree - newLongestTree);
                longestIndex = newLongestIndex;
                longestTree = newLongestTree;
                multiplier++;
            }
            else {
                int newCut = 0;
                newCut += (M-cut)/multiplier;
                int a = (M-cut)% multiplier;
                if(a != 0)
                    newCut++;
                cut += multiplier * newCut;
                highest = longestTree - newCut;

                break;
            }
        }
        System.out.println(highest);
    }
}
