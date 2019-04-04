import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static class Set {
        ArrayList<Integer> numbers = new ArrayList<>();

        public Set(int[] n) {
            for(int i: n) {
                numbers.add(i);
            }
        }

        public Set(ArrayList<Integer> s) {
            for(Integer i: s) {
                numbers.add(i);
            }
        }

        public ArrayList<Integer> remove(int index) {
            ArrayList<Integer> a = new ArrayList<>();
            for(Integer i: numbers)
                a.add(i);
            a.remove(index);
            return a;
        }

        public ArrayList<Integer> getNumbers() {
            return numbers;
        }

        public void replace(Set s) {
            for(int i = 0; i < numbers.size() - 1; i++)
                numbers.remove(0);
            for(Integer i: s.getNumbers()) {
                numbers.add(i);
            }
        }

    }

    static boolean exists(ArrayList<Set> allSets, ArrayList<Integer> set) {
        for(Set s: allSets) {
            for(int i = 0; i < s.getNumbers().size() - 1; i++) {
                if(!set.get(i).equals(s.getNumbers().get(i)))
                    break;
                if(i == s.getNumbers().size())
                    return true;
            }
        }
        return false;
    }

    static boolean isUnique(ArrayList<Set> allSets, Set check) {
        for(Set s: allSets) {
            int similarity = 0;
            for(int i = 0; i < check.getNumbers().size(); i++) {
                if(s.getNumbers().get(i).equals(check.getNumbers().get(i)))
                    similarity++;

            }
            if (similarity == s.getNumbers().size())
                return false;
        }
        return true;
    }

    static boolean fulfills(Set check, int k) {
        for(int i = 0; i < check.getNumbers().size(); i++) {
            for(int j = i + 1; j < check.getNumbers().size(); j++) {
                if((check.getNumbers().get(i) + check.getNumbers().get(j))%k == 0)
                    return false;
            }
        }
        return true;
    }

    static int nonDivisibleSubset(int n, int k, int[] S) {
        ArrayList<Set> allSets = new ArrayList<>();
        if(fulfills(new Set(S), k))
            return n;
        allSets.add(new Set(S));

        int m = 0;
        for(int i = 0; i < n; i++) {        // The number of removed elements left
            int size = allSets.size();
            while(m < size) {
                if(allSets.get(m).getNumbers().size() == n - i) {
                    for(int j = 0; j < allSets.get(m).getNumbers().size(); j++) {
                        Set newSet = new Set(allSets.get(m).remove(j));
                        if(fulfills(newSet, k))
                            return newSet.getNumbers().size();
                        //if(isUnique(allSets, newSet))
                        allSets.add(newSet);
                    }
                }
                m++;
            }
        }
        return 0;
    }

    // 15800000
    // 16405495
    //
    /*
4 3
1 7 2 4
    */


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(n, k, S);

        System.out.println(String.valueOf(result));
        System.out.println("\n");

        scanner.close();
    }
}

// 4 3 1 7 2 4
