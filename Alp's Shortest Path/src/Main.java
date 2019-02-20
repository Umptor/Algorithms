import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


	static int[][] connected;
	static int[] distance;
	static int vertexCount;


	/*

	private static Vertex[] vertices;

	private static class Vertex {
		Vertex[] adjacentVertices;
		private int shrtestRoad = Integer.MAX_VALUE;

		public Vertex(Vertex[] adjacentVertices) {
			this.adjacentVertices = adjacentVertices;
		}
	}

	*/

	private static void dijsktraAlgo(ArrayList<Integer> current) {
		ArrayList<Integer> nextBreadth = new ArrayList<>();

		for(int i = current.size() - 1; i >= 0; i--) {
			for(int j = 0; j < vertexCount; j++) {

				if(connected[current.get(i)][j] <= 0)
					continue;

				if(connected[current.get(i)][j] + distance[current.get(i)] < distance[j]) {
					distance[j] = connected[current.get(i)][j] + distance[current.get(i)];
					nextBreadth.add(j);
				}
			}
		}

		if(nextBreadth.size() > 0)
			dijsktraAlgo(nextBreadth);
	}


	public static void dijkstra(int start) {
		ArrayList<Integer> initial = new ArrayList<>();
		distance[start] = 0;
		initial.add(start);
		dijsktraAlgo(initial);


	}

	public static Scanner scanner = new Scanner(System.in);


/*

6
13
0 1 3
0 2 5
1 3 1
1 4 1
2 3 10
3 0 3
3 1 3
3 2 3
3 5 2
3 4 1
4 3 3
5 3 3
5 4 3
 */

	public static void main(String args[]) {

		/*
		Input type:

		number of vertices
		number of edges

		edge start vertex + edge end vertex + distance
		start + destination

		Vertex id starts from 0




		 */
		/*

8 12
0 1 12
0 5 30
0 3 4
0 4 2
2 5 3
2 6 12
4 1 8
4 3 1
4 2 8
6 1 4
6 7 5
7 1 2





		 */




		vertexCount = scanner.nextInt();
		int edgeCount = scanner.nextInt();
		connected = new int[vertexCount][vertexCount];
		distance = new int[vertexCount];

		for(int i = 0; i < distance.length; i++)
			distance[i] = Integer.MAX_VALUE;

		for(int i = 0; i < edgeCount; i++)
			connected[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();

		dijkstra(scanner.nextInt());

		for(int i: distance)
			System.out.println(i);
	}
}
