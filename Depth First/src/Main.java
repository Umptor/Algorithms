import java.util.Scanner;

public class Main {
	static int[][] adjacencyMatrix;
	static boolean visited[];
	static int[] found;
	static int foundCounter = 0;
	static Scanner scanner = new Scanner(System.in);

	static void depthFirstSearch(int start) {
		found[foundCounter] = start;
		foundCounter++;
		visited[start] = true;

		for(int i = 0; i < adjacencyMatrix.length; i++)
			if(adjacencyMatrix[start][i] != 0 && !visited[i])
				depthFirstSearch(i);
	}

	public static void main(String args[]) {
		int vertexCount = Integer.parseInt(scanner.nextLine());
		adjacencyMatrix = new int[vertexCount][vertexCount];
		visited = new boolean[vertexCount];
		found = new int[vertexCount];
		for(int i = 0; i < vertexCount; i++)
			for(int j = 0; j < vertexCount; j++)
				adjacencyMatrix[i][j] = scanner.nextInt();

		depthFirstSearch(scanner.nextInt());
		for(int i : found)
			System.out.print(i + " ");
	}
}
