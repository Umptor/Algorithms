import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int getDigit(int num, int step) {
		int digit;
		digit = num / (int)Math.pow(10,step);
		digit = digit % 10;
		return digit;
	}

	public static Integer[] radixSortAlgo(Integer[] arr, int step, int maxSteps) {
		if(step >= maxSteps)
			return arr;
		int[] digits = new int[10];
		Integer[] sorted = new Integer[arr.length];

		for(int i = 0; i < 10; i++)
			digits[i] = 0;
		for(int i = 0; i < sorted.length; i++)
			sorted[i] = 0;

		for(int i = 0; i < arr.length; i++) {
			int lastDigit = getDigit(arr[i], step);
			digits[lastDigit]++;
		}
		for(int i = 1; i < digits.length; i++)
			digits[i] += digits[i-1];
		for(int i = arr.length - 1; i >= 0; i--) {
			int lastDigit = getDigit(arr[i], step);
			sorted[digits[lastDigit] - 1] = arr[i];
			digits[lastDigit]--;
		}

		arr = radixSortAlgo(sorted, step + 1, maxSteps);
		return arr;
	}

	// 5 8 9 7 6 4 2 1 3 5 1 4
	// 1 1 2 3 4 4 5 5 6 7 8 9

	public static Integer[] radixSort(Integer[] arr) {
		int maxSteps = 1;
		int max = arr[0];
		for(int i: arr)
			if(i > max)
				max = i;
		while(max/10 > 0) {
			max /= 10;
			maxSteps++;
		}

		return radixSortAlgo(arr, 0, maxSteps);

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String first[] = a.split(" ");
		Integer[] arr = new Integer[first.length];

		for(int i = 0; i < first.length; i++) {
			arr[i] = Integer.parseInt(first[i]);
		}

		arr = radixSort(arr);

		for(Integer item : arr)
			System.out.println(item);

	}

}
