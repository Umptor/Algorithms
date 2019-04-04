import java.io.*;
import java.util.*;

public class Main {


    private static class Ingredient {
        private int spicyness;
        private int filling;

        public Ingredient(int spi, int sub) {
            spicyness = spi;
            filling = sub;
        }

        public int getSpicyness() {
            return spicyness;
        }

        public int getFilling() {
            return filling;
        }

    }

    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Ingredient> combine(ArrayList<Ingredient> arr, ArrayList<Ingredient> arr2) {

        ArrayList<Ingredient> resultIngre = new ArrayList<>();

        for(int i = 0; i < arr.size(); i++) {
            for(int j = i + 1; j < arr.size(); j++) {
                int newSpice = arr.get(i).getSpicyness() * arr.get(j).getSpicyness();
                int newFill = arr2.get(i).getFilling() + arr2.get(j).getFilling();
                resultIngre.add(new Ingredient(newSpice, newFill));
            }
        }
        return resultIngre;
    }

    public static void main(String[] args) {
        ArrayList<Integer> spicyAmounts =  new ArrayList<>();
        ArrayList<Integer> fillAmounts =  new ArrayList<>();

        int ingredientAmount = scanner.nextInt();

        ArrayList<Ingredient> ingredientArr = new ArrayList<>();

        for(int i = 0; i < ingredientAmount; i++)
            ingredientArr.add(new Ingredient(scanner.nextInt(), scanner.nextInt()));


    }
}


