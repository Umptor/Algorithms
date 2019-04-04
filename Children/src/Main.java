
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

            int nameLength = scanner.next().length();
            for(int j = 1; j < K + 1; j++) {
                if(i-j < 0)
                    break;
                if(namesArr.get(i-j) == nameLength)
                    friendCount++;
            }
            namesArr.add(nameLength);
        }
        System.out.println(friendCount);
    }
}
