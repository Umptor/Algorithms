import java.io.*;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int childNum = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Integer> namesArr = new ArrayList<>();
        int friendCount = 0;
        scanner.nextLine();

        for(int i = 0; i < childNum; i++) {
            int length = scanner.next().length();
            for(Integer j: namesArr) {
                if(j == length)
                    friendCount++;
            }
            if(namesArr.size() >= K)
                namesArr.remove(0);
            namesArr.add(length);

        }
        System.out.println(friendCount);
    }
}
