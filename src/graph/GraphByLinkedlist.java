package graph;

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

    public void dfs (int s) {
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

    public static void main(String[] args) {
        GraphByLinkedlist g = new GraphByLinkedlist(5);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 3);
        g.addEdges(3, 0);
        g.addEdges(2, 4);

        System.out.println("----------------Adjacency matrix of graph-----------------------");
        System.out.println(g);

        System.out.println("----------------Breath-first search (BFS)-----------------------");
        g.bfs(0);
        System.out.println('\n');

        System.out.println("----------------Depth-first search (DFS)-----------------------");
        g.dfs(0);
        System.out.println('\n');
    }
}
