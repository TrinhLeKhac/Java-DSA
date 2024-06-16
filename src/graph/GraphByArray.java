// Graph
// Its a non-linear data structure used for storing data
// It is a set of vertices(nodes) and a collection of edges that connects a pair of vertices
// Graph hep us implement Social Networking sites such as Facebook ,Twitter etc. It can be called as Social Networking Graph
// Names of people represent vertices of Graph
// Friendship between two people can be represented as an Edge of Graph

// Undirected graph
// If John (vertex) is friend (edge) to Max (vertex), then Max (vertex) is also friend (edge) to John (vertex)

// Adjacency Matrix Representation (Undirected Graph)

package graph;

public class GraphByArray {
    private final int V;  // number of vertices of Graph
    private int E;  // number of edges of Graph
    private final int[][] adjMatrix;

    public GraphByArray(int nodes) {
        this.V = nodes;
        this.E = 0;
        adjMatrix = new int[nodes][nodes];
    }

    public void addEdges(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;  // because it is an undirected graph
        E++;
    }

    public void displayAdjMatrix() {
        int row = this.adjMatrix.length;
        int high = this.adjMatrix[0].length;

        System.out.print("{");
        for (int i = 0; i < row - 1; i++) {
            System.out.print("{");
            for (int j = 0; j < high - 1; j++) {
                System.out.print(this.adjMatrix[i][j] + " ");
            }
            // last column
            System.out.print(this.adjMatrix[i][high - 1]);
            System.out.println("}, ");
        }
        // last row
        System.out.print("{");
        for (int j = 0; j < high - 1; j++) {
            System.out.print(this.adjMatrix[row - 1][j] + " ");
        }
        System.out.print(this.adjMatrix[row - 1][high - 1]);
        System.out.print("}");

        System.out.print("}");
    }

    public String toString() {  // overwrite toString() method
        StringBuilder sb = new StringBuilder();
//        sb.append(V + " vertices, " + E + " edges " + '\n');
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append('\n');
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (int e: adjMatrix[v]) {
                sb.append(e).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GraphByArray g = new GraphByArray(5);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 3);
        g.addEdges(3, 4);
        g.addEdges(4, 0);

//        g.displayAdjMatrix();
//        System.out.println('\n');

        System.out.println(g);
    }
}
