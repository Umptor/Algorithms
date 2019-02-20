import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


	static int[][] connected;
	static int[] distance;
	static int vertexCount;

	private static class QueueElement {
		int id;
		int roadLength;
		int startDistance;
		QueueElement parent = null;
		QueueElement child = null;

		public QueueElement(int id, int roadLength, int startDistance, QueueElement parent) {
			this.id = id;
			this.roadLength = roadLength;
			this.startDistance = startDistance;
			this.parent = parent;
			if(parent != null)
				parent.child = this;
		}
	}

	private static class MinQueue {
		QueueElement front = null;

		public void add(Integer vertex, int roadLength, int startDistance) {
			if(front == null) {
				front = new QueueElement(vertex, roadLength, startDistance, null);
				return;
			}

			QueueElement current = front;
			while(current.child != null) {
				if(current.roadLength + current.startDistance < roadLength + startDistance)
					current = current.child;
				else
					break;
			}
			new QueueElement(vertex, roadLength, startDistance, current);
		}

		public QueueElement pop() {
			QueueElement returnValue = front;
			front = front.child;
			if(front != null)
				front.parent = null;
			return returnValue;
		}

		public boolean isEmpty() {
			return front == null;
		}

	}

	public static void dijkstra(int start) {

		MinQueue queue = new MinQueue();
		queue.add(start, 0, 0);
		distance[start] = 0;

		while(!queue.isEmpty()) {
			QueueElement current = queue.pop();
			if(current.startDistance + current.roadLength > distance[current.id])
				continue;

			for(int i = 0; i < vertexCount; i++) {
				if(connected[current.id][i] <= 0)
					continue;

				if(current.startDistance + current.roadLength >= distance[i])
					continue;

				queue.add(i, connected[current.id][i], distance[current.id]);
				distance[i] = connected[current.id][i] + distance[current.id];
			}
		}
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

/*

8
16
0 1 10
0 2 20
0 4 38
1 4 10
1 3 50
2 4 33
2 3 20
2 6 59
3 4 20
3 5 2
3 7 38
4 6 10
4 5 1
4 7 94
6 5 60
7 5 15
0
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
