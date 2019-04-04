import java.io.*;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int people = scanner.nextInt();
        int channelCount = scanner.nextInt();
        int initalChannel = scanner.nextInt();

        ArrayList<Integer> loved = new ArrayList<>();
        ArrayList<Integer> hated = new ArrayList<>();

        for(int i = 0; i < people * 2; i++) {
            if(i%2 == 0)
                loved.add(scanner.nextInt());
            else
                hated.add(scanner.nextInt());
        }

        int currChannel = initalChannel;
        int steps = 0;

        while(hated.contains(currChannel)) {
            currChannel = loved.get(hated.indexOf(currChannel));
            steps++;
            if(currChannel == initalChannel) {
                steps = -1;
                break;
            }
        }

        System.out.println(steps);
    }
}
