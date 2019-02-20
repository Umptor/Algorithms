import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	static void depthFirstSearch(int start, int[] found, int foundCounter, boolean[] visited, int[][] adjacencyMatrix) {
		found[foundCounter++] = start;
		visited[start] = true;

		for(int i = 0; i < adjacencyMatrix.length; i++)
			if(adjacencyMatrix[start][i] != 0 && !visited[i])
				depthFirstSearch(i, found, foundCounter, visited, adjacencyMatrix);
	}

	static boolean isConnected(int vertexCount, int[][] adjacencyMatrix) {
		/*
			From all vertics it must be possible to visit all other vertices
			A DFS is started from each vertex to see if from that vertex all other vertices will be visited
		 */
		for(int i = 0; i < vertexCount; i++) {
			boolean visited[] = new boolean[vertexCount];
			int[] found = new int[vertexCount];
			int foundCounter = 0;

			depthFirstSearch(i, found, foundCounter, visited, adjacencyMatrix);
			for(boolean b: visited)
				if(!b)
					return false;
		}
		return true;
	}

	public static void main(String args[]) {

		int vertexCount = Integer.parseInt(scanner.nextLine());
		int[][] adjacencyMatrix  = new int[vertexCount][vertexCount];
		for(int i = 0; i < vertexCount; i++)
			for(int j = 0; j < vertexCount; j++)
				adjacencyMatrix[i][j] = scanner.nextInt();

		if(isConnected(vertexCount, adjacencyMatrix))
			System.out.println("ja");
		else
			System.out.println("nein");
	}
}
