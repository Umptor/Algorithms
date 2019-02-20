import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



	public static <E extends Comparable> List<E> quickSortAlgo(List<E> arr, int start, int end) {

		/*
		close | close
		*/

		if(end - start <= 0)
			return arr;
		if(end - start == 1) {
			if(arr.get(start).compareTo(arr.get(end)) > 0) {
				E temp = arr.get(end);
				arr.set(end, arr.get(start));
				arr.set(start, temp);
			}
			return arr;
		}

		E pivot = arr.get(start);
		int front = start + 1;
		int back = end;

		while(front < back) {
			while(front < end && arr.get(front).compareTo(pivot) <= 0)
				front++;
			while(back > start && arr.get(back).compareTo(pivot) > 0 && back != front - 1)
				back--;
			if(back == front - 1) {
				break;
			}
			E temp = arr.get(front);
			arr.set(front, arr.get(back));
			arr.set(back, temp);
		}

		arr.set(start, arr.get(back));
		arr.set(back, pivot);

		arr = quickSortAlgo(arr, start, back - 1);
		arr = quickSortAlgo(arr,back + 1 ,end);

		return arr;


	}

	// 5 6 8 9 7 8 4 3 1 2 11 17 11
	// 5 8 7 9 5 4 8 6 2 1 3 4 5 7 9 11 8 6 15 20
	// 8 5 2 9 6 3 7 4 1 8 5 2 9 5 1 7 5 3 6 4

    public static <E extends Comparable> List<E> quickSort(List<E> arr) {

        /*
            Pick a pivot element and sort the array such that:
            1) Everything to the left of the pivot element is smaller
            2) Everything to the right of the pivot element is larger

            Then recursively send the left side and the right side to Quicksort so that:
            The next element is also sorted.

            After each run of quickSort the final position of the pivot element is found and it is put in the right place

        */

        return quickSortAlgo(arr, 0, arr.size() - 1);


    }

    /*

    public static <E extends Comparable> List<E> quickSortab(List<E> arr) {

	    List<E> first = new ArrayList<>();
	    List<E> second = new ArrayList<>();

	    if(arr.size() <= 1)
		    return arr;
	    if(arr.size() == 2) {
		    if(arr.get(0).compareTo(arr.get(1)) > 0) {
			    E temp = arr.get(0);
			    arr.set(0, arr.get(1));
			    arr.set(1, temp);
		    }
		    return arr;
	    }

	    E pivot = arr.get(0);
	    int pivotIndex = 0;
	    int front = pivotIndex + 1;
	    int back = arr.size() - 1;

	    while(front < back) {
		    while(front < arr.size() - 1 && arr.get(front).compareTo(pivot) <= 0)
			    front++;
		    while(back > 0 && arr.get(back).compareTo(pivot) > 0 && back != front - 1)
			    back--;
		    if(back == front - 1) {
			    break;
		    }
		    E temp = arr.get(front);
		    arr.set(front, arr.get(back));
		    arr.set(back, temp);
	    }

	    arr.set(0, arr.get(back));
	    arr.set(back, pivot);

	    for(int i = 0; i < back; i++)
		    first.add(arr.get(i));
	    for(int i = arr.size() - 1; i > back; i--)
		    second.add(0, arr.get(i));

	    first = quickSort(first);
	    second = quickSort(second);
	    first.add(pivot);
	    first.addAll(second);

	    return first;
    }

	*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String first[] = a.split(" ");
        List<Integer> arr = new ArrayList<>();
        for(String num : first)
            arr.add(Integer.parseInt(num));

        arr = quickSort(arr);

        for(Integer item : arr)
            System.out.println(item);

    }
}
