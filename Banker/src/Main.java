import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int availableResources[];
	static int processes[][];
	static int goals[][];
	static int processCount;
	static int resourceCount;

	// arr = currentAvailableResources

	static int[] bankersAlgo(int[] arr, int[][] currentProcesses, int current, boolean[] done) {

		// If the process is already done then no further operations are needed
		if(processHasFinished(currentProcesses[current], current,  done))
			return arr;

		// Give the required resources to the process
		for(int i = 0; i < resourceCount; i++) {
			arr[i] -= goals[current][i] - currentProcesses[current][i];
			// If there aren't enough resources then the resources are added back
			if(arr[i] < 0) {
				for(int j = i; j >= 0; j--)
					arr[i] += goals[current][i] - currentProcesses[current][i];
				// The first element of the resources is marked to show that a resource deficiency had occurred
				arr[0] = -1;
				return arr;
			}
		}

		// If resource allocation was successful then the current process is done does not need it's resources any more so it gives them back
		for(int i = 0; i < resourceCount; i++) {
			currentProcesses[current][i] = 0;
			arr[i] += goals[current][i];
		}

		// Process is marked as completed
		done[current] = true;

		// If all processes have been completed then return successfully
		if(allProcessesAreDone(done))
			return arr;

		// Loops goes through different combinations of orders that the the algorithm could go through
		for(int i = 0; i < processCount; i++) {
			// If the current process is already done, skip it
			if(done[i])
				continue;

			// Creates copies of the resources, processes and done arrays so that one combination doesn't interfere with the other
			int[] newArr = Arrays.copyOf(arr, arr.length);
			int[][] newCurrentProcesses = copy2dArray(currentProcesses);
			boolean[] newDone = Arrays.copyOf(done, done.length);

			// Recursive call
			bankersAlgo(newArr, newCurrentProcesses, i, newDone);

			// If the allocation was unsuccessful
			if(newArr[0] == -1)
				continue;


			for(int j = 0; j < done.length; j++)
				done[j] = newDone[j];
			for(int j = 0; j < currentProcesses.length; j++)
				currentProcesses[j] = newCurrentProcesses[j];
			done[i] = true;
			return newArr;
		}
		return arr;
	}

	static int[][] copy2dArray(int[][] arr) {
		int[][] done = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr[0].length; j++)
				done[i][j] = arr[i][j];
		return done;
	}

	static int bankers(int[] arr) {
		for(int i = 0; i < processCount; i++) {
			int[] newArr = Arrays.copyOf(arr, arr.length);
			int[][] newCurrentProcesses = copy2dArray(processes);
			boolean[] done = new boolean[processCount];

			bankersAlgo(newArr, newCurrentProcesses, i, done);

			if(newArr[0] == -1)
				continue;

			if(allProcessesAreDone(done))
				return 1;
		}
		return 0;
	}

	static boolean processHasFinished(int[] currentProcess, int current, boolean[] done) {
		if(done[current])
			return true;

		for(int i: currentProcess)
			if(i > 0 || i != -1) {
				done[current] = false;
				return false;
			}
		return true;
	}

	static boolean allProcessesAreDone(boolean[] done) {
		for(boolean bool: done)
			if(!bool)
				return false;
		return true;
	}


	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		processCount = scanner.nextInt();
		resourceCount = scanner.nextInt();

		availableResources = new int[resourceCount];
		processes = new int[processCount][resourceCount];
		goals = new int[processCount][resourceCount];

		for(int i = 0; i < resourceCount; i++)
			availableResources[i] = scanner.nextInt();

		for(int i = 0; i < processCount * resourceCount; i++) {
			int resource = scanner.nextInt();
			processes[i/resourceCount][i%resourceCount] = resource;
			availableResources[i%resourceCount] -= resource;
		}

		for(int i = 0; i < processCount * resourceCount; i++)
			goals[i/resourceCount][i%resourceCount] = scanner.nextInt();

		System.out.println(bankers(availableResources));
	}
}

// 3 3 13 8 9 0 2 1 1 0 1 3 1 1 6 3 3 4 3 5 5 1 1
// 3 2 16 4 7 1 5 0 2 1 12 4 7 2 4 2
