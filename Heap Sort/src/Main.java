import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static <E extends Comparable> List<E> heapify(List<E> arr, int current) {

    	/*
    	    1)  Compares the 2 siblings with the parent (P)
    	    2)  if a sibling (A) is larger than P,
    	            Swap A and P
    	    3)  Fix the side that P went to so that P isn't smaller than any of it's children


    	*/

    	int rightIndex = 2*current + 2;
	    int leftIndex = 2*current + 1;

	    if(leftIndex > arr.size() - 1)
		    return arr;

    	E rightChild;
    	E leftChild;
    	E parent = arr.get(current);

    	if(rightIndex < arr.size()) {
    		rightChild = arr.get(rightIndex);
    		leftChild = arr.get(leftIndex);
		    if(rightChild.compareTo(leftChild) >= 0) {          // Step 1
			    if(rightChild.compareTo(parent) > 0) {          // Step 1
				    arr.set(current, rightChild);               // Step 2
				    arr.set(rightIndex, parent);                // Step 2
				    arr = heapify(arr, rightIndex);             // Step 3
			    }
		    }
		    else if(leftChild.compareTo(rightChild) >= 0) {     // Step 1
			    if(leftChild.compareTo(parent) > 0) {           // Step 2
				    arr.set(current, leftChild);                // Step 2
				    arr.set(leftIndex, parent);                 // Step 2
				    arr = heapify(arr, leftIndex);              // Step 3
			    }
		    }
	    }
	    else if(leftIndex < arr.size()) {
		    leftChild = arr.get(leftIndex);                     // Step 1 not needed because right sibling doesn't exist
		    if(leftChild.compareTo(parent) >= 0) {              // Step 2
			    arr.set(current, leftChild);                    // Step 2
			    arr.set(leftIndex, parent);                     // Step 2
		    }                                                   // Step 3 is not needed because leftChild must be a leaf
	    }
	    return arr;
    }

    public static <E extends Comparable> List<E> heapSort(List<E> arr) {

    	/*

    	Heapify "heapifies" the array which
    	    Makes a max heap which is a heap where all parent nodes are greater than their children

		After the for loop we have a max heap

		In the while loop what happens is:
			1) The largest element is put at the top by the heapify function
			2) It is then added to the final array
			3) And then swapped with the last element in the array and removed
			4) The heap is then put back into a max heap by step 1

		Repeat until initial array is empty

    	*/

        List<E> finished = new ArrayList<>();

        for(int i = arr.size() / 2 - 1; i >= 0; i--)
            arr = heapify(arr, i);

        while(arr.size() > 0) {
            arr = heapify(arr, 0);
            finished.add(0, arr.get(0));
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
        }

        return finished;
    }

    // 5 6 8 9 7 4 3 1 2 11 17
    // 5 8 7 9 5 4 8 6 2 1 3 4 5 7 9 11 8 6 15 20
    // 5 8 7 4 6 2 1 3 4 7 9 11 6 15 20
	// 6 1 7 4 6 2 5 3 4 7

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String first[] = a.split(" ");
        List<Integer> arr = new ArrayList<>();
        for(String num : first)
            arr.add(Integer.parseInt(num));

        arr = heapSort(arr);

        for(Integer item : arr)
            System.out.println(item);
    }
}
