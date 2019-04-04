import java.io.*;
import java.util.*;

public class Main {

    private static class Ingredient {
        private int spicyness;
        private int substantiality;
        int id;
        static int baseIng = 0;
        private ArrayList<Integer> combo = new ArrayList<>();

        public Ingredient(int spi, int sub) {
            spicyness = spi;
            substantiality = sub;
            id = baseIng;
            baseIng++;
        }
        public Ingredient(Ingredient i1, Ingredient i2) {
            spicyness = i1.getSpicyness() * i2.getSpicyness();
            substantiality = i1.getSubstantiality() + i2.getSubstantiality();
        }

        public int getSpicyness() {
            return spicyness;
        }

        public int getSubstantiality() {
            return substantiality;
        }

        public ArrayList<Integer> getCombo() {
            return combo;
        }

        public static boolean exists(Ingredient a, ArrayList<Ingredient> allIngs) {
            for(Ingredient ing : allIngs)
                for(Integer i : a.getCombo()) {
                int cur = 0;
                    if(ing.getCombo().indexOf(i) != -1) {
                        cur++;
                        if(cur == ing.getCombo().size())
                            return true;
                    }
                }
            return false;
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int ingredientAmount = scanner.nextInt();
        int SpicyAmounts = scanner.nextInt();
        int SubAmounts = scanner.nextInt();


        ArrayList<Ingredient> ingredientArr = new ArrayList<>();

        for(int i = 0; i < ingredientAmount; i++)
            ingredientArr.add(new Ingredient(scanner.nextInt(), scanner.nextInt()));

        while()

        int minDiff;

        int k = 0;



    }
}
