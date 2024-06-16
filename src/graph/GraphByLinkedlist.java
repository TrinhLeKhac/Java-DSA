package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphByLinkedlist {

    private final int V; // number of vertices
    private int E; // number of edges
    LinkedList<Integer>[] adjMatrix;

    public GraphByLinkedlist(int nodes) {
        this.V  = nodes;
        this.E = 0;
        adjMatrix = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            adjMatrix[i] = new LinkedList<>();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append('\n');
        for (int i = 0; i < V; i++) {
            sb.append(i).append(": ");
            for (int e: adjMatrix[i]) {
                sb.append(e).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void addEdges (int u, int v) {
        this.adjMatrix[u].add(v);
        this.adjMatrix[v].add(u);
        E++;
    }

    public void bfs(int s) {  // breath-first search
        boolean[] isVisited = new boolean[this.V];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        isVisited[s] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v: adjMatrix[u]) {
                if (!isVisited[v]) {
                    queue.offer(v);
                    isVisited[v] = true;
                }
            }
        }
    }

    public void dfsByStack(int s) {
        boolean[] isVisited = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        isVisited[s] = true;
        while(!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");
            for (int v: adjMatrix[u]) {
                if (!isVisited[v]) {
                    stack.push(v);
                    isVisited[v] = true;
                }
            }
        }
    }

    public void dfsByRecursive(int s) {
        boolean[] isVisited = new boolean[this.V];
        dfsRecursive(s, isVisited);
    }

    public void dfsRecursive(int v, boolean[] isVisited) {
        isVisited[v] = true;
        System.out.print(v + " ");
        // Reverse order of LinkedList
        Collections.reverse(adjMatrix[v]);
        for (int e: adjMatrix[v]) {
            if (!isVisited[e]) {
                dfsRecursive(e, isVisited);
            }
        }
    }

    // ConnectedComponent
    // record is special kind of class introduced in Java 14 and made stable in Java 16
    // It is used to create immutable data classes without having to write boilerplate code
    // like getters, equals, hashCode and toString methods

    public record ConnectedComponent(int count, int[] componentId) {
        public int getCountCC() {
            return count;
        }

        public boolean isConnected(int x, int y) {
            return componentId[x]  == componentId[y];
        }
    }

    public ConnectedComponent dfsConnectedComponent() {
        boolean[] isVisited = new boolean[this.V];
        int[] componentId = new int[this.V];  // vertex is belonged to which componentId
        int count = 0;
        for (int v = 0; v < V; v++) {
            if (!isVisited[v]) {
                dfsCC(v, isVisited, componentId, count);  // find all vertical that are belonged to the same component
                count++;
            }
        }
        return new ConnectedComponent(count, componentId);
    }

    public void dfsCC(int v, boolean[] isVisited, int[] componentId, int count) {
        isVisited[v] = true;
        componentId[v] = count;
//        Collections.reverse(adjMatrix[v]);
        for (int w: adjMatrix[v]) {
            if (!isVisited[w]) {
                dfsCC(w, isVisited, componentId, count);
            }
        }
    }

    public static void main(String[] args) {
        GraphByLinkedlist g = new GraphByLinkedlist(5);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 3);
        g.addEdges(3, 0);
        g.addEdges(2, 4);

        System.out.println("----------------Adjacency matrix of graph G1-----------------------");
        System.out.println(g);

        System.out.println("----------------Breath-first search (BFS)-----------------------");
        g.bfs(0);
        System.out.println('\n');

        System.out.println("----------------Depth-first search (DFS) by stack-----------------------");
        g.dfsByStack(0);
        System.out.println('\n');

        System.out.println("----------------Depth-first search (DFS) by recursive-----------------------");
        g.dfsByRecursive(0);
        System.out.println('\n');

        GraphByLinkedlist g2 = new GraphByLinkedlist(6);
        g2.addEdges(0, 1);
        g2.addEdges(0, 3);
        g2.addEdges(2, 4);

        System.out.println("----------------Adjacency matrix of graph G2-----------------------");
        System.out.println(g2);

        System.out.println("----------------Find ConnectedComponent-----------------------");
        ConnectedComponent cc = g2.dfsConnectedComponent();
        System.out.println("There are totally " + cc.getCountCC() + " connected-component in graph");
        int vertex1 = 1;
        int vertex2 = 2;
        if (cc.isConnected(vertex1, vertex2)) {
            System.out.println("The vertex " + vertex1 + " and " + vertex2 + " is connected");
        } else {
            System.out.println("The vertex " + vertex1 + " and " + vertex2 + " is NOT connected");
        }
    }
}
