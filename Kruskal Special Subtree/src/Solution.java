import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static Scanner scanner =  new Scanner(System.in);


    static int find(int x) {
        while(x != link[x])
            x = link[x];
        return x;
    }

    static int total = 0;

    static ArrayList<Integer> heads = new ArrayList<>();

    static int join(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b)
            return -1;
        if(size[a] < size[b]) {
            int c = a;
            a = b;
            b = c;
        }
        int index = heads.indexOf(b);
        if(index != -1)
            heads.remove(index);
        size[a] += size[b];
        link[b] = a;
        return 1;
    }
    static int[] link;
    static int[] size;
    static ArrayList<Integer> num1 = new ArrayList<>();
    static ArrayList<Integer> num2 = new ArrayList<>();
    static ArrayList<Integer> num3 = new ArrayList<>();
    static boolean[] connected;

    public static void main(String[] args) {

        String[] arr = scanner.nextLine().split(" ");
        int[] g = new int[2];
        g[0] = Integer.parseInt(arr[0]);
        g[1] = Integer.parseInt(arr[1]);
        link = new int[g[1] + 1];
        size = new int[g[1] + 1];
        connected = new boolean[g[0] + 1];
        Arrays.fill(connected, false);
        connected[0] = true;
        for(int i = 0; i < g[0]; i++) {
            heads.add(i);
        }


        for(int i = 1; i <= g[0]; i++) {
            link[i] = i;
            size[i] = 1;
        }

        for(int i = 1; i <= g[1]; i++) {
            int a = scanner.nextInt();
            num1.add(a);
            int b = scanner.nextInt();
            num2.add(b);
            int w = scanner.nextInt();
            num3.add(w);
        }
        boolean done = true;
        while(done) {

            int index = num3.indexOf(Collections.min(num3));
            if(join(num1.get(index), num2.get(index)) == -1) {
                num1.remove(index);
                num2.remove(index);
                num3.remove(index);
                continue;
            }
            total += num3.get(index);
            connected[num1.get(index)] = true;
            connected[num2.get(index)] = true;

            num1.remove(index);
            num2.remove(index);
            num3.remove(index);
            boolean end = false;
            for(int i = 2; i < g[0] + 1; i++) {
                if(find(1) != find(i)) {
                    end = true;
                    break;
                }
            }
            if(end)
                continue;
            done = false;
        }
        link[1] = link[1];
        size[1] = size[1];
        System.out.println(total);

    }
}
