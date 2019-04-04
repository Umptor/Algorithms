import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int money = scanner.nextInt();
        List<Integer> cookies = new ArrayList<>();
        for(int i = 0; i < n; i++)
            cookies.add(scanner.nextInt());

        int max = 0;
        int j = 0;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            while(sum < money && j + 1 <= n) {
                sum += cookies.get(j);
                if(sum > money) {
                    sum -= cookies.get(j);
                    break;
                }
                j++;
            }
            if(j - i + 1 > max)
                max = j - i;
            sum -= cookies.get(i);
        }
    System.out.println(max);
    }
}
