package ch4;

import java.util.LinkedList;
import java.util.Queue;

/*Given a directed graph, design an algorithm to find out whether there is a rout between two nodes*/
public class Solution4_1 {

	// Graph class which use adjancent matrix to represent
	public class Graph {
		private Object[] vertices; // Save the node information
		private int[][] arcs;// Save the edge information
		private int vexnum;// Number of nodes
		private boolean[] visited;// track which node has been visited

		/* Initialize a graph which has n vertices */
		public Graph(int n) {
			vexnum = n;
			setVertices(new Object[n]);
			arcs = new int[n][n];
			visited = new boolean[n];
			for (int i = 0; i < vexnum; i++) {
				for (int j = 0; j < vexnum; j++) {
					arcs[i][j] = 0;
				}
			}

		}

		// Add vertices to the graph
		public void addVertex(Object[] obj) {
			this.setVertices(obj);
		}

		// Add edgs to the graph
		public void addEdge(int i, int j) {
			if (i == j)
				return;
			arcs[i][j] = 1;
			arcs[j][i] = 1;
		}

		// Find the first adjancent vertice of i
		public int firstAdjVex(int i) {
			for (int j = 0; j < vexnum; j++) {
				if (arcs[i][j] > 0)
					return j;
			}
			return -1;
		}

		// Find the next adjancent vertice of i
		public int nextAdjVex(int i, int k) {
			for (int j = k + 1; j < vexnum; j++) {
				if (arcs[i][j] > 0)
					return j;
			}
			return -1;
		}

		// Search the graph to check if there is a path between vertice start
		// and vertice end
		boolean search(int start, int end) {
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < vexnum; i++) {
				visited[i] = false;
			}
			// Use BFS
			q.add(start);
			visited[start] = true;
			while (!q.isEmpty()) {
				int j = (Integer) q.remove().intValue();

				for (int k = this.firstAdjVex(j); k >= 0; k = this.nextAdjVex(j, k)) {
					if (!visited[k]) {
						if (k == end)
							return true;
						else {
							q.add(k);
							visited[k] = true;
						}
					}
				}

			}

			return false;
		}

		public Object[] getVertices() {
			return vertices;
		}

		public void setVertices(Object[] vertices) {
			this.vertices = vertices;
		}

	}

	public static void main(String[] args) {
		Solution4_1 t = new Solution4_1();
		Graph g = t.new Graph(8);
		Character[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		g.addVertex(vertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 7);
		g.addEdge(2, 5);
		g.addEdge(2, 6);

		System.out.println(g.search(0, 7));
	}
}
