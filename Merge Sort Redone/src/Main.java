import java.util.Scanner;

public class Main {

	public static Integer[] mergeAlgorithm(Integer[] arr, int beginning, int end) {
		if(beginning == end)
			return arr;

		Integer[] sorted = new Integer[end - beginning + 1];
		int counter = 0;

		mergeAlgorithm(arr, beginning, (end + beginning)/2);
		mergeAlgorithm(arr, (end + beginning)/2 + 1, end);

		int pnt1 = beginning;
		int pnt2 = (end + beginning)/2 + 1;
		while(pnt1 != (end + beginning)/2 + 1 && pnt2 != end + 1) {
			if(arr[pnt1].compareTo(arr[pnt2]) < 0) {
				sorted[counter] = arr[pnt1];
				counter++;
				pnt1++;
			}
			else {
				sorted[counter] = arr[pnt2];
				counter++;
				pnt2++;
			}
			if(pnt1 == (end + beginning)/2 + 1) {
				while(pnt2 <= end) {
					sorted[counter] = arr[pnt2];
					counter++;
					pnt2++;
				}
				break;
			}
			if(pnt2 == end + 1) {
				while(pnt1 != (end + beginning)/2 + 1) {
					sorted[counter] = arr[pnt1];
					counter++;
					pnt1++;
				}
				break;
			}
		}

		for(int i = 0; i < counter; i++)
			arr[beginning + i] = sorted[i];

		return arr;
	}

	public static Integer[] mergeSort(Integer[] arr) {

		// Closed closed
		// 0-5 | 6-10

		return mergeAlgorithm(arr, 0, arr.length - 1);
	}


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String a = scanner.nextLine();
		String first[] = a.split(" ");
		Integer[] arr = new Integer[first.length];
		int i = 0;
		for (String num : first) {
			arr[i] = Integer.parseInt(num);
			i++;
		}

		arr = mergeSort(arr);

		for (Integer item : arr)
			System.out.println(item);

	}
}
