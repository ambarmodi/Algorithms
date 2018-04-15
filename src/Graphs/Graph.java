package Graphs;

import java.util.*;

/**
 * Graph can be represented in various ways viz. 
 * 1. Adjacency list. SC: O(V+E)
 * 2. Adjacency Matrix 
 * 3. Object-Oriented: Each vertex v as objects(Nodes). V.neighbors will
 * be the Adj[V].
 * 4. Implicit representation where we compute the neighbors on the fly. This takes less space. Usage is representing state of a rubix cube.
 * Rubix cube has bajillion states and each state is a vertex. 
 * 
 * Below is the implementation of Graph using Adjacency List as it is convenient
 * if we have multiple graphs for the same vertices. In that case we can have
 * graph1, graph2, graph3 talk about same vertices. Object oriented
 * representation is cleaner if we have only one graph.
 * 
 * Consideration: 1. We are considering the vertices are integer and hence graph
 * is array of Integers. 2. Graph is directional and hence graph[v]--> W
 * represent the edge from V-->W
 * 
 * 
 * NOTE: If the vertices are not integer, we can create the vertices array and
 * map the index to a vertex of any data type. The graph is the unidirectional
 * graph.
 * 
 * 
 * @author ambarmodi
 *
 */
public class Graph {

	private int numVertex;
	private LinkedList<Integer> graph[];

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Graph(int v) {
		graph = new LinkedList[10];
		numVertex = v;

		for (int i = 0; i < v; i++) {
			graph[i] = new LinkedList();
		}
	}

	/**
	 * The edge is added from V --> W
	 */
	public void addEdge(int v, int w) {
		graph[v].add(w);
	}

	/**
	 * Prints the Graph in V-->W format. If the vertex doesnot have the edge it
	 * wont be printed
	 */
	public void printGraph() {
		for (int i = 0; i < numVertex; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				System.out.println(i + "-->" + graph[i].get(j));
			}
		}
	}

	/**
	 * @return Number of vertices
	 */
	public int getNumVertices() {
		return numVertex;
	}

	/**
	 * Returns the index of the vertex. In this graph index and vertex-name is
	 * the same.
	 */
	public int getVertex(int i) {
		return i;
	}

	public List<Integer> getAdjVertx(int vertex) {
		return graph[vertex];
	}

}
