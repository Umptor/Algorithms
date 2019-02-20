import java.util.Scanner;

public class Main {

	static int[][] edgeWeights;
	static int[] distance;
	static int vertexCount;
	static final int defaultValue = Integer.MIN_VALUE;

	public static Scanner scanner = new Scanner(System.in);


	public static void kruskal() {



	}

	public static void main(String args[]) {

		vertexCount = scanner.nextInt();
		int edgeCount = scanner.nextInt();
		edgeWeights = new int[vertexCount][vertexCount];
		distance = new int[vertexCount];

		for(int i = 0; i < edgeWeights.length; i++)
			for(int j = 0; j < edgeWeights.length; j++)
				edgeWeights[i][j] = defaultValue;

		for(int i = 0; i < distance.length; i++)
			distance[i] = Integer.MAX_VALUE;

		for(int i = 0; i < edgeCount; i++)
			edgeWeights[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();

		for(int i = 0; i < edgeCount; i++) {

		}

	}
}
