package Graphs;
import java.util.*;

/**
 * @author ambarmodi
 * 
 */
public class GraphTraversal {

	public static void main(String[] args) {
		// Create the graph
		Graph graph = createGraph();
		graph.printGraph();
		traverse(graph);
	}

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
	 * This is the graph traversal for the Disconnected Graph.
	 * 
	 * @param graph represented as an Adjacency List.
	 */
	public static void traverse(Graph graph) {

		/*We use the visited array of the vertices as there could be a back-edge in the Graph so can go in infinite loop*/
		boolean[] visited = new boolean[graph.getNumVertices()];
		System.out.println("BFS Visit:");
		
		for(int v=0; v<graph.getNumVertices(); v++) {
			if(!visited[v])
				bfs_Visit(graph, visited, v);
		}
		
		visited = new boolean[graph.getNumVertices()];
		System.out.println("\nDFS Visit:");
		
		for(int v=0; v<graph.getNumVertices(); v++) {
			if(!visited[v])
				dfs_visit(graph, visited, v);
		}
	}

	/**
	 * DFS: 
	 * Recursive implementation of DFS_Visit (uses Backtracking) 
	 * Uses stack of recursive calls
	 * 
	 * TC: O(V+E)
	 * 
	 * Extension: 
	 * 1. Edge classification. Tree edge(parent)
	 * 2. cycle detection
	 */
	public static void dfs_visit(Graph graph, boolean[] visited, int vertex) {
		visited[vertex]=true;
		System.out.print(vertex +" ");
		for(int v: graph.getAdjVertx(vertex)){
			if(!visited[v]) {
				dfs_visit(graph, visited, v);
			}
		}
	}

	/**
	 * BFS: Explore the graph layer by layer. Can get the shortest path.
	 * Iterative implementation of BFS Visit. 
	 * Uses Queue.
	 * 
	 * TC: O(V+E)
	 * 
	 * Extension: We can add the level and parent pointers to check the shortest
	 * path and distance of shortest path
	 */
	public static void bfs_Visit(Graph graph, boolean[] visited, int startVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(graph.getVertex(startVertex));
		while (!queue.isEmpty()) {
			int vertex = queue.remove();
			System.out.print(vertex + " ");
			visited[startVertex] = true;
			for (int v : graph.getAdjVertx(vertex)) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}

}
