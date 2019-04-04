import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> combination(int n) {
        ArrayList<String> result = new ArrayList<>();

        String[] a = new String[n];
        for(int i = 0; i < a.length; i++)
            a[i] = String.valueOf(i);

        final int maxbit = 1 << a.length;

        for (int p = 0; p < maxbit; p++) {
            final List<String> res = new ArrayList<String>();

            for (int i = 0; i < a.length; i++) {
                if ((1 << i & p) > 0) {
                    res.add(a[i]);
                }
            }
            String b = Arrays.toString(res.toArray());
            result.add(b);
        }
    return result;
    }

    public static ArrayList<Integer> convert(String bob) {
        ArrayList<Integer> bill = new ArrayList<>();
        for(int i = 0; i < bob.length(); i++) {
            if(bob.charAt(i) >= '0' && bob.charAt(i) <= '9')
                bill.add(Integer.parseInt("" + bob.charAt(i)));
        }
        return bill;
    }

    private static class Set {
        public ArrayList<Integer> nums = new ArrayList<>();

        public Set(String s) {
            nums = convert(s);
        }
    }

    private static class Ingredient {
        private int spicyness;
        private int substantiality;

        public Ingredient(int spi, int sub) {
            spicyness = spi;
            substantiality = sub;
        }

        public int getSpicyness() {
            return spicyness;
        }

        public int getSubstantiality() {
            return substantiality;
        }
    }

    public static void main(String[] args) {

        int N = scanner.nextInt();
        ArrayList<String> combinationsS = combination(N);
        for(String s: combinationsS)
            System.out.println(s);

        combinationsS.remove(0);

        ArrayList<Ingredient> ingredientArr = new ArrayList<>();
        ArrayList<Set> combinations = new ArrayList<>();

        for(String joe: combinationsS)
            combinations.add(new Set(joe));

        for(int i = 0; i < N; i++)
            ingredientArr.add(new Ingredient(scanner.nextInt(), scanner.nextInt()));

        int minDiff = 0;
        boolean start = true;

        for(Set s: combinations) {
            int spice = 1;
            int filling = 0;
            for(Integer i : s.nums) {
                spice *= ingredientArr.get(i).getSpicyness();
                filling += ingredientArr.get(i).getSubstantiality();
            }
            int diff = Math.abs(spice - filling);
            if(start) {
                minDiff = diff;
                start = false;
            }
            else if(diff < minDiff)
                minDiff = diff;
        }
        System.out.println(minDiff);
    }
}
