package Graphs;

import java.util.*;

/**
 * Can do shortest path with BFS. (cannot do it with DFS as it wont give
 * shortest
 * 
 * @author ambarmodi
 */
public class ShortestPath {
	public static void main(String[] args) {
		Graph graph = createGraph();

		int startVertex = 0;
		int targetVertex = 4;
		findShortestPath(graph, startVertex, targetVertex);
	}

	/**
	 * @return Adjacency List representation of a graph.
	 */
	private static Graph createGraph() {
		Graph graph = new Graph(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(2, 0);
		graph.addEdge(4, 4);

		return graph;
	}

	/**
	 * The function finds the shortest path from startVertex to targetVertex. It
	 * uses the BFS and maintains the parent list to find the shortest path.
	 * 
	 * We also maintain the distance of each node from starting Vertex.
	 *
	 * TC: O(E+V)
	 */
	private static void findShortestPath(Graph graph, int startVertex, int targetVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[graph.getNumVertices()];
		// Parent maintains the parent for each node for shortest path.
		HashMap<Integer, Integer> parent = new HashMap<>();
		// Distance maintain the distance of each node from starting vertex.
		int[] distance = new int[graph.getNumVertices()];

		queue.add(startVertex);
		parent.put(startVertex, null);
		visited[startVertex] = true;

		while (!queue.isEmpty()) {
			int v = queue.remove();
			//System.out.print(v + " ");
			for (int vertex : graph.getAdjVertx(v)) {
				if (!visited[vertex]) {
					queue.add(vertex);
					// Update parent
					parent.put(vertex, v);
					// update the distance
					distance[vertex] = distance[v] + 1;

					visited[vertex] = true;

					if (vertex == targetVertex) {
						System.out.println("Distance = " + distance[vertex]);
						printShortestPath(parent, vertex);
						break; // Break as path is found.
					}
				}
			}
		}
	}

	/**
	 * Prints the shortest path. Note: The parent of the starting vertex null.
	 */
	private static void printShortestPath(HashMap<Integer, Integer> parent, int vertex) {
		int count = 0;
		int key = vertex;
		System.out.print(key);
		while (parent.get(key) != null) {
			int par = parent.get(key);
			System.out.print(" <-- " + par);
			key = par;
			count++;
		}

		System.out.println("\nNumber of edges (same as distance) = " + count);
	}
}
