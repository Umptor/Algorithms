import java.util.Scanner;

public class Main {

	static int[][] adjacencyMatrix;
	static int[] shortestDist;
	static final int inf = Integer.MAX_VALUE;

	static boolean bellmanFord(int vertexCount, int depth) {

		boolean changed = false;
		boolean atEnd = false;

		if(depth > vertexCount)
			atEnd = true;

		for(int i = 0; i < vertexCount; i++) {
			if(shortestDist[i] == inf)
				continue;

			for(int j = 0; j < vertexCount; j++) {
				if(adjacencyMatrix[i][j] == 0)
					continue;

				int timeTaken = shortestDist[i] + adjacencyMatrix[i][j];

				if(timeTaken < shortestDist[j]) {
					if(!atEnd)
						shortestDist[j] = timeTaken;
					else
						return false;
					changed = true;
				}
			}
		}

		if(!changed || atEnd)
			return true;
		return bellmanFord(vertexCount, depth + 1);
	}

	/*

	9
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
0

Expected: 0 4 12 19 21 11 9 8 14
Got:      0 4 12 19 26 16 9 8 14
	 */

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int vertexCount = scanner.nextInt();

		shortestDist = new int[vertexCount];
		adjacencyMatrix = new int[vertexCount][vertexCount];

		for(int i = 0; i < vertexCount; i++)
			shortestDist[i] = inf;

		for(int i = 0; i < vertexCount; i++)
			for(int j = 0; j < vertexCount; j++)
				adjacencyMatrix[i][j] = scanner.nextInt();

		int start = scanner.nextInt();
		shortestDist[start] = 0;

		boolean doable = bellmanFord(vertexCount, 0);

		if(doable)
			for(int i = 0; i < vertexCount; i++)
				System.out.print(shortestDist[i] + " ");
		else
			System.out.println("Cycle");
	}
}
