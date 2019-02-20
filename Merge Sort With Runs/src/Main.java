import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static <E extends Comparable> E[] naturalMergeSort(E[] arr) {
		List<Integer> runs = new ArrayList<>();

		int parity = 0;
		runs.add(-1);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i].compareTo(arr[i - 1]) < 0)
				runs.add(i - 1);
		}
		runs.add(arr.length - 1);

		while(runs.size() != 2) {
			int initialSize = runs.size();
			int i;
			for(i = 0; i < runs.size()/2; i++) {
				if(2*i + 2 >= runs.size())
					break;
				else
					combine(arr, runs.get(2*i), runs.get(2*i + 1), runs.get(2*i + 2));
			}
			if(runs.size()%2 == 0) {
				combine(arr, runs.get(2*(i - 1)), runs.get(2*i), runs.get(2*i + 1));
			}
			for(int j = 1; j < runs.size(); j++) {
				if(initialSize%2 == 0 && j == runs.size() - 3)
					runs.remove(j);
				runs.remove(j);

			}
		}
		return arr;
	}

	// 5 2 3 1 5 8 3 6 7 1
	// 5 8 7 9 4 6 5 2 1 3 4 7 8 4

	public static <E extends Comparable> void combine(E[] arr, int firstStart, int firstEnd, int secondEnd) {
		int pnt1 = firstStart + 1;
		int pnt2 = firstEnd + 1;
		List<E> sorted = new ArrayList<>();

		while(true) {
			if(pnt1 > firstEnd) {
				while(pnt2 <= secondEnd) {
					sorted.add(arr[pnt2]);
					pnt2++;
				}
				break;
			}
			else if(pnt2 > secondEnd) {
				while(pnt1 <= firstEnd) {
					sorted.add(arr[pnt1]);
					pnt1++;
				}
				break;
			}

			if(pnt1 <= firstEnd && arr[pnt1].compareTo(arr[pnt2]) <= 0) {
				sorted.add(arr[pnt1]);
				pnt1++;
				continue;
			}
			if(pnt2 <= secondEnd && arr[pnt1].compareTo(arr[pnt2]) > 0) {
				sorted.add(arr[pnt2]);
				pnt2++;
			}
		}

		for(int i = 0; i < sorted.size(); i++) {
			arr[firstStart + i + 1] = sorted.get(i);
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String first[] = a.split(" ");
		Integer[] arr = new Integer[first.length];

		for(int i = 0; i < first.length; i++) {
			arr[i] = Integer.parseInt(first[i]);
		}

		arr = naturalMergeSort(arr);

		for(Integer item : arr)
			System.out.println(item);

	}
}
