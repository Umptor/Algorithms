import java.io.*;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        static Scanner scanner = new Scanner(System.in);

        public static void main (String[]args){


            String a = scanner.nextLine();
            String suffix = "-1";

            int length = a.length();
            String middle = "";
            String front = "";
            String back;

            for(int i = 1; i <= a.length() / 3; i++) {
                front = a.substring(0, i);
                back = a.substring(a.length() - i, a.length());
                if (front.equals(back)) {
                    middle = a.substring(i, length - i);
                    suffix = front;
                    break;
                }
            }
            if(middle.contains(front))
                System.out.println(suffix);
            else
                System.out.println("-1");
        }
    }
}
