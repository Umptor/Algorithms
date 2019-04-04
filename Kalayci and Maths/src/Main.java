import java.io.*;
import java.util.*;

/*
Compare each element with the one on it's right
while right is bigger remove left, move index left one
while at end of arrayList remove until no more needed
*/

public class Main {

        private static Scanner scanner = new Scanner(System.in);

        private static ArrayList<Character> remove(ArrayList<Character> charArr, int removeCount) {

            int i = 0;
            int removed = 0;
            while(i < charArr.size()) {
                while(i == charArr.size() - 1) {
                    charArr.remove(i);
                    removed++;
                    if(removed >= removeCount)
                        return charArr;
                    i--;

                }
                while(charArr.get(i) < charArr.get(i+1)) {
                    charArr.remove(i);
                    removed++;
                    if(i != 0)
                        i--;
                    if(removed >= removeCount)
                        return charArr;
                }
                i++;
            }
            return charArr;
        }

        public static void main(String[] args) {

            int charCount = scanner.nextInt();
            int removeCount = scanner.nextInt();

            String input = scanner.next();
            ArrayList<Character> charArr = new ArrayList<>();

            for(int i = 0; i < input.length(); i++)
                charArr.add(input.charAt(i));

            charArr = remove(charArr, removeCount);

            for(Character c: charArr)
                System.out.print(c);
        }
}
