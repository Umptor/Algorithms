import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int maxResources[];
	static int processes[][];
	static int requiredResource[][];
	static int processCount;
	static int resourceCount;

	static int[] bankersAlgo(int[] arr, int current) {

		if(isDone(current)) {
			return arr;
		}

		boolean finished = true;
		for(int i = 0; i < processCount; i++) {
			if(processes[current][i] != 0 && processes[current][i] != -1) {
				finished = false;
				break;
			}
		}

		if(finished) {
			return arr;
		}

		for(int i = 0; i < resourceCount; i++) {

		}

		if(isDone(current)) {
			killProcess(arr, current);
		}

		for(int i = 0; i < processCount; i++) {
			int[] used = Arrays.copyOf(arr, maxResources.length);
			for(int j = 0; j < processCount; j++)
				used[j] -= processes[current][j];
			if(used[i] < 0) {
				used[i] = -1;
				return arr;
			}
			used = bankersAlgo(used, i);
			boolean doable = true;
			for(int j = 0; j < processCount; j++) {
				if(used[i] < 0) {
					doable = false;
					break;
				}
			}
			if(doable)
				return used;
			else {
				arr[1] = -1;
				return arr;
			}
		}
		return arr;
	}

	static void killProcess(int[] arr, int current) {
		for(int i = 0; i < resourceCount; i++) {
			arr[i] += requiredResource[current][i];
		}
	}

	static boolean isDone(int current) {
		for(int[] arr: processes) {
			for(int i: arr)
				if(i != 0)
					return false;
		}
		return true;
	}

	static int bankers(int[] arr) {
		for(int i = 0; i < processCount; i++) {
			int[] used = Arrays.copyOf(arr, maxResources.length);
			used = bankersAlgo(used, i);
			boolean doable = true;
			for(int j = 0; j < processCount && doable; j++) {
				if(used[j] < 0) {
					doable = false;
					break;
				}
			}
			if(doable)
				return 1;
			else return 0;
		}
		return 0;
	}


	// 3 3 13 8 9 0 2 1 1 0 1 3 1 1 6 3 3 4 3 5 5 1 1


	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		processCount = scanner.nextInt();
		resourceCount = scanner.nextInt();

		maxResources = new int[resourceCount];
		processes = new int[processCount][resourceCount];
		requiredResource = new int[processCount][resourceCount];

		for(int i = 0; i < resourceCount; i++)
			maxResources[i] = scanner.nextInt();

		for(int i = 0; i < processCount * processCount; i++) {
			int resource = scanner.nextInt();
			processes[i/processCount][i%resourceCount] = resource;
			maxResources[i%3] -= resource;
		}

		for(int i = 0; i < resourceCount * resourceCount; i++)
			requiredResource[i/processCount][i%resourceCount] = scanner.nextInt();

		System.out.println(bankers(maxResources));


	}
}
