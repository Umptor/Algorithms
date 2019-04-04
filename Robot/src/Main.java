import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    static class Robot {
        public int carry;
        public int price;

        public Robot(int c, int p) {
            carry = c;
            price = p;
        }
    }
    static class Customer {
        public int needCarry;
        public int maxPrice;

        public Customer(int c, int p) {
            needCarry = c;
            maxPrice = p;
        }
    }

    static int findLeastPaying(ArrayList<Customer> arr) {
        int least = 0;
        int leastIndex = 0;
        boolean start = true;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i).maxPrice < least || start) {
                least = arr.get(i).maxPrice;
                leastIndex = i;
                start = false;
            }
        }
        return leastIndex;
    }

    static int findMost(ArrayList<Robot> arr, Customer customer) {
        int most = -10;
        int mostIndex = -1;
        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i).price > most && arr.get(i).carry > customer.needCarry && arr.get(i).price >= customer.maxPrice) {
                most = arr.get(i).price;
                mostIndex = i;
            }
        }
        if(most == -10)
            return -1;
        return mostIndex;
    }

    static int leastToMost(ArrayList<Customer> customerArr, ArrayList<Robot> robotArr, int C) {

        int sold = 0;

        for(int i = 0; i < C; i++) {
            int mostIndex = findLeastPaying(customerArr);
            int cheapestIndex = findMost(robotArr, customerArr.get(mostIndex));
            if(cheapestIndex == -1)
                return sold;
            robotArr.remove(cheapestIndex);
            customerArr.remove(mostIndex);
            sold++;
        }
    return sold;
    }

    public static void main(String[] args) {
        int C = scanner.nextInt();
        int R = scanner.nextInt();

        ArrayList<Customer> customerArr = new ArrayList<>();
        ArrayList<Robot> robotArr = new ArrayList<>();

        for(int i = 0; i < C; i++)
            customerArr.add(new Customer(scanner.nextInt(), scanner.nextInt()));

        for(int i = 0; i < R; i++)
            robotArr.add(new Robot(scanner.nextInt(), scanner.nextInt()));

        int p2p = leastToMost(customerArr, robotArr, C);

        System.out.println(p2p);
    }
}
