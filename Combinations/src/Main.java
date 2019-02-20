import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> comboAlgo(ArrayList<ArrayList<Integer>> combos, ArrayList<Integer> current, ArrayList<Integer> input, boolean take, int depth) {

		if(depth == input.size()) {
			if(take && current.size() != 1)
				combos.add(current);
			return combos;
		}
		ArrayList<Integer> newCurrent = new ArrayList<>(current);
		if(take)
			newCurrent.add(input.get(depth));

		combos = comboAlgo(combos, newCurrent, input, true, depth + 1);
		return comboAlgo(combos, newCurrent, input, false, depth + 1);

	}

	static ArrayList<ArrayList<Integer>> getCombos(ArrayList<Integer> input) {
		ArrayList<ArrayList<Integer>> combos = new ArrayList<>();
		if(input.size() == 1) {
			combos.add(input);
			return combos;
		}
		combos = comboAlgo(combos, new ArrayList<>(), input, true, 0);
		return comboAlgo(combos, new ArrayList<>(), input, false, 0);
	}

	static Scanner scanner = new Scanner(System.in);

	static int getSingleGCD(int a, int b) {
		if(a == 0)
			return b;
		return getSingleGCD((b%a), a);
	}

	static int getGCD(ArrayList<Integer> arr, int n) {
		int result = arr.get(0);
		for(int i = 0; i < n; i++)
			result = getSingleGCD(arr.get(i), result);
		return result;
	}

	void printCombos(ArrayList<ArrayList<Integer>> combos) {
		for(ArrayList<Integer> arr2 : combos) {
			for(Integer i : arr2)
				System.out.print(i + " ");
			System.out.println("");
		}
	}

	public static void main(String args[]) {
		//int times = scanner.nextInt();

		String str = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		ArrayList<Integer> arr = new ArrayList<>();
		while(st.hasMoreTokens())
			arr.add(Integer.parseInt(st.nextToken()));
		ArrayList<ArrayList<Integer>> combos = getCombos(arr);


	}
}
