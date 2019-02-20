import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static class Vertex {
		static Vertex[] vertices;       // A general list of all vertices

		int id;                         // ID of vertex
		int[] edges_By_Id;              // An array that holds the IDs of all adjacent edges
		Vertex pathToEnd = null;        // When a path has been found, this acts as a linked list that goes to the end


		public Vertex(int id, int[] connections) {
			this.id = id;
			edges_By_Id = connections;
		}

		public Vertex(Vertex vertex) {  // Copies the vertex given as a parameter
			this.id = vertex.id;
			this.edges_By_Id = Arrays.copyOf(vertex.edges_By_Id, vertex.edges_By_Id.length);
		}

		public boolean hasEdges() {
			for(int anEdges_By_Id : edges_By_Id)    // If the vertex has any nondeleted edges then return true
				if(anEdges_By_Id != -1)
					return true;
			return false;
		}

		public boolean edgeIsDeleted(int i) {
			return edges_By_Id[i] == -1;
		}

		public void deleteEdge(int id) {
			edges_By_Id[id] = -1;
		}
	}

	private static Vertex EulersAlgo(Vertex current, int crossedEdge, Vertex[] vertices) {
		// Deletes the road to the current vertex
		current.deleteEdge(crossedEdge);
		// Updates the vertex for this depth
		vertices[current.id] = current;

		// If the vertex doesn't have any edges then Euler is either
		// finished because all edges are deleted and successful
		// finished because there are 2 independent subgraphs

		if(!current.hasEdges()) {
			if(current.id != vertices[0].id) {      // If not a circle then faulty solution
				return null;
			}
			for(Vertex vertex: vertices)            // for any vertex
				if(vertex.hasEdges())               // If there are any edges left
					return null;                    // Then faulty solution
			return current;                 // If none of the above it must be correct
		}


		// Marker for finding the way to the exit
		Vertex foundWay;
		for(int i = 0; i < current.edges_By_Id.length; i++) {

			// If the edge is deleted then check the next edge
			if(current.edgeIsDeleted(i))
				continue;

			// Find the road back to the current vertex from the next vertex
			int j = 0;
			while(vertices[current.edges_By_Id[i]].edges_By_Id[j] != current.id)
				j++;

			// New object for the next vertex so that it doesn't override the next for loop in case it is unsuccessful
			Vertex pathTo = new Vertex(vertices[current.edges_By_Id[i]]);
			// Same with the current node
			Vertex newCurrent = new Vertex(current);
			newCurrent.deleteEdge(i);
			// And the vertex array
			Vertex[] newVertices = Arrays.copyOf(vertices, vertices.length);
			newVertices[current.id] = newCurrent;

			// If a way has been found foundWay is set to a Vertex else it is null
			foundWay = EulersAlgo(pathTo, j, newVertices);

			// If foundWay isn't null i.e. a way has been found then the recursive function keeps returning the current Vertex
			if(foundWay != null) {
				current.pathToEnd = foundWay;
				return current;                     // No difference between returning current or newCurrent as the only thing that matters now is the pathToEnd link in the object
			}
		}
		return null;
	}

	public static Vertex Euler(Vertex current) {
		// Explanations in the eulerAlgo function. This function was just used to start everything off

		if(!current.hasEdges())
			return null;

		Vertex foundWay;
		for(int i = 0; i < current.edges_By_Id.length; i++) {

			int j = 0;
			while(Vertex.vertices[current.edges_By_Id[i]].edges_By_Id[j] != current.id)
				j++;

			Vertex pathTo = new Vertex(Vertex.vertices[current.edges_By_Id[i]]);
			Vertex newCurrent = new Vertex(current);
			newCurrent.deleteEdge(i);
			Vertex[] newVertices = Arrays.copyOf(Vertex.vertices, Vertex.vertices.length);
			newVertices[current.id] = newCurrent;
			foundWay = EulersAlgo(pathTo, j, newVertices);

			if(foundWay != null) {
				current.pathToEnd = foundWay;
				return current;
			}
		}
		return null;
	}

	static Scanner scanner = new Scanner(System.in);


	/*
input for 2a)

12
0 1 5
1 0 2 4
2 1 3
3 2 4 8 11
4 1 3 5 7
5 0 4 6
6 5 7
7 4 6 8 9
8 3 7
9 7 10
10 9 11
11 3 10

input for 2b)

18
0 1 17
1 0 2
2 1 3 5 17
3 2 4
4 3 5
5 2 4 6 14
6 5 7 11 13
7 6 8
8 7 9
9 8 10
10 9 11
11 6 10 12 14
12 11 13
13 6 12
14 5 11 15 17
15 14 16
16 15 17
17 0 2 14 16

	 */

	public static void main(String args[]) {

		/*

		Input type

		1
		V + E
		V + E
		.
		.
		.

		number of nodes
		First the node's id then the id of the nodes that are adjacent to the node


		 */

		// This part only takes the input and creates the required vertex objects
		int nodeCount = Integer.parseInt(scanner.nextLine());
		Vertex.vertices = new Vertex[nodeCount];

		for(int i = 0; i < nodeCount; i++) {
			String[] arrTemp = scanner.nextLine().split(" ");
			int id = Integer.parseInt(arrTemp[0]);
			String[] arr = Arrays.copyOfRange(arrTemp, 1, arrTemp.length);
			int[] connections = new int[arr.length];
			for(int j = 0; j < arr.length; j++)
				connections[j] = Integer.parseInt(arr[j]);
			Vertex.vertices[i] = new Vertex(id, connections);
		}


		// If pathTo is null then no path has been found
		// else it is set to a Vertex object that has acts like a linked list that starts at the start and goes through each vertex in the path
		Vertex pathTo = Euler(Vertex.vertices[0]);
		if(pathTo == null)
			System.out.println("No Path");
		else {
			while(pathTo.pathToEnd != null) {
				System.out.print(pathTo.id + " ");
				pathTo = pathTo.pathToEnd;
			}
			System.out.println(0);
		}
	}
}


// Not efficient but the input size is quite small