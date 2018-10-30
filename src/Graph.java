import java.util.*;

class Edge implements Comparable<Edge> {
	private int startIndex;
	private int endIndex;
	private int weight;

	public Edge(int startIndex, int endIndex, int weight) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.weight = weight;
	}

    public int compareTo(Edge compareEdge) {
        return this.weight-compareEdge.weight;
    }

	public int getStartIndex() {
		return startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public int getWeight() {
		return weight;
	}
}

// class Vertex {
// 	private int inDegree;
// 	private int outDegree;
// 	private int value;

// 	public Edge(int inDegree, int outDegree, int value) {
// 		this.inDegree = inDegree;
// 		this.outDegree = outDegree;
// 		this.value = value;
// 	}
// }

public class Graph {
	private int[] vertices;
	private List<Edge> edges = new ArrayList<>();
	// private ArrayList<Vertex> vertices;

	public Graph(int vertices) {
		this.vertices = new int[vertices];
	}

	public void addEdge(int startIndex, int endIndex, int weight) {
		this.edges.add(new Edge(startIndex, endIndex, weight));
	}

	public void printKruskalMST() {
		int index = 0;
		// int numberOfIncludedVertices = 0;
		List<Edge> includedEdges = new ArrayList<>();

		Boolean[] verticesIncluded = new Boolean[this.vertices.length];
		Collections.sort(this.edges);
		Arrays.fill(verticesIncluded, false);
//		Arrays.stream(verticesIncluded).forEach(value -> verticesIncluded[index[0]++] = false);

		while (includedEdges.size() != this.vertices.length && index < this.edges.size()) {
			Edge currentEdge = this.edges.get(index);
			index++;

			if (!isFormingCycle(currentEdge, verticesIncluded)) {
				includedEdges.add(currentEdge);
				includeEdgeVertices(currentEdge, verticesIncluded);
			}
		}
		System.out.println("Following are the edges in the constructed MST");
		printGraph(includedEdges);
	}

	public void printPrimsMST() {
		int[] weightOfVertices = new int[this.vertices.length];
		int[] parent = new int[this.vertices.length];
		Boolean[] verticesIncluded = new Boolean[this.vertices.length];
		Arrays.fill(verticesIncluded, false);
		Arrays.fill(parent, -1);
		Arrays.fill(weightOfVertices, Integer.MAX_VALUE);

		weightOfVertices[0] = 0;

		for(int i = 0; i < this.vertices.length - 1; i++) {
			int indexOfVertex = findMinValueVertex(weightOfVertices);
			verticesIncluded[indexOfVertex] = true;
			updateAdjacentVerticesWeight(indexOfVertex, weightOfVertices);

		}
	}

	private void updateAdjacentVerticesWeight(int indexOfVertex, int[] weightOfVertices) {

	}

	private int findMinValueVertex(int[] weightOfVertices) {
		int minValueIndex = 0;
		for(int i=1; i < weightOfVertices.length; i++) {
			if(weightOfVertices[i] < weightOfVertices[minValueIndex]){
				minValueIndex = i;
			}
		}
		return minValueIndex;
	}

	private void printGraph(List<Edge> edges) {
		for(Edge edge : edges) {
			System.out.println(edge.getStartIndex() + " -- " +
					edge.getEndIndex() + " == " + edge.getWeight());
		}
	}

	private void includeEdgeVertices(Edge edge, Boolean[] verticesIncluded) {
		verticesIncluded[edge.getStartIndex()] = true;
		verticesIncluded[edge.getEndIndex()] = true;
	}

	private boolean isFormingCycle(Edge edge, Boolean[] verticesIncluded) {
		return verticesIncluded[edge.getStartIndex()] && verticesIncluded[edge.getEndIndex()];
	}

	public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int vertices = 4;  // Number of vertices in graph
        // int edges = 5;  // Number of edges in graph
        // Graph graph = new Graph(V, E);
        Graph graph = new Graph(vertices);
 
        // add edge 0-1
        graph.addEdge(0, 1, 10);
        // graph.edge[0].src = 0;
        // graph.edge[0].dest = 1;
        // graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.addEdge(0, 2, 6);
        // graph.edge[1].src = 0;
        // graph.edge[1].dest = 2;
        // graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.addEdge(0, 3, 5);
        // graph.edge[2].src = 0;
        // graph.edge[2].dest = 3;
        // graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.addEdge(1, 3, 15);
        // graph.edge[3].src = 1;
        // graph.edge[3].dest = 3;
        // graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.addEdge(2, 3, 4);
        // graph.edge[4].src = 2;
        // graph.edge[4].dest = 3;
        // graph.edge[4].weight = 4;
		graph.printKruskalMST();
	}
}