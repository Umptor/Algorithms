import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// FAILURE BECAUSE NEED TO COUNT NUMBERS OR HOLD A SECOND ARRAY FOR POINTERS WHICH IS STUPID

public class Main {

	public static <E extends Comparable> List<E> countingSort(List<E> arr, int lowerBound, int upperBound) {
		// closed | closed

		List finished = new ArrayList<>();

		for(int i = lowerBound; i <= upperBound; i++) {
			finished.add(new E());
		}



		return arr;
	}

	// 5 6 8 9 7 8 4 3 1 2 11 17 11
	// 5 8 7 9 5 4 8 6 2 1 3 4 5 7 9 11 8 6 15 20


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String a = scanner.nextLine();
		String first[] = a.split(" ");
		List<Integer> arr = new ArrayList<>();
		for(String num : first)
			arr.add(Integer.parseInt(num));

		int lowerBound = -500, upperBound = 500;

		arr = countingSort(arr, lowerBound, upperBound);

		for(Integer item : arr)
			System.out.println(item);

	}
}
