import java.io.*;
import java.util.*;


public class Main {

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
    }


    public static Scanner scanner = new Scanner(System.in);
    static String[] a = new String[] { "0", "1", "2", "3" };

    public static void main(String[] args) {


        int n = scanner.nextInt();


        final int maxbit = 1 << a.length;

        //for each combination given by a (binary) number 'p'...
        for (int p = 0; p < maxbit; p++) {
            final List<String> res = new ArrayList<String>();

            //evaluate if array 'a' element at index 'i' is present in combination (and include it if so)
            for (int i = 0; i < a.length; i++) {
                if ((1 << i & p) > 0) {
                    res.add(a[i]);
                }
            }
            String a = Arrays.toString(res.toArray());
            System.out.println(Arrays.toString(res.toArray()));
        }





        /*
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(i);
        }

        ArrayList<Set> allSets = new ArrayList<Set>();
        setArr.add(new Set(arr));

        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();

        int m = 0;
        for(int i = 0; i < n; i++) {
            int j = 0;
            int size = allSets.size()
            while(m < size) {
                if(allSets.get(m).)
            }
        }
        */
    }
}
