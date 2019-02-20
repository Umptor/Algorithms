import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static void BFSAlgo(ArrayList<Integer> current, int[][] adjacencyMatrix, boolean visited[], int[] found, int foundCounter) {
		ArrayList<Integer> next = new ArrayList<>();
		if(foundCounter == visited.length)
			return;

		for(int i = 0; i < current.size(); i++) {
			for(int j = 0; j < adjacencyMatrix.length; j++) {
				if(!visited[j] && adjacencyMatrix[current.get(i)][j] != 0) {
					next.add(j);
					visited[j] = true;
					found[foundCounter++] = j;
				}
			}
		}

		BFSAlgo(next, adjacencyMatrix, visited, found, foundCounter);
	}

	static void breadthFirstSearch(int start, int[][] adjacencyMatrix, boolean visited[], int[] found, int foundCounter) {
		found[0] = start;
		visited[start] = true;
		ArrayList<Integer> next = new ArrayList<>(Arrays.asList(0));
		BFSAlgo(next, adjacencyMatrix, visited, found, foundCounter);

		for(int i: found)
			System.out.print(i + " ");
	}

	public static void main(String args[]) {
		int foundCounter = 1;
		Scanner scanner = new Scanner(System.in);
		int vertexCount = Integer.parseInt(scanner.nextLine());
		int[][] adjacencyMatrix = new int[vertexCount][vertexCount];
		boolean[] visited = new boolean[vertexCount];
		int[] found = new int[vertexCount];

		for(int i = 0; i < vertexCount; i++)
			for(int j = 0; j < vertexCount; j++)
				adjacencyMatrix[i][j] = scanner.nextInt();

		breadthFirstSearch(scanner.nextInt(), adjacencyMatrix, visited, found, foundCounter);
	}
}
