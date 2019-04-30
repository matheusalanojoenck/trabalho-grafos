package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class BFS {
    
    private ArrayList<ArrayList<Integer>> listaAdj;
    private final int V;
    private int[][] arvoreGeradora;
    private int tempo = 0;
    
    public BFS(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = listaAdj;
        V = listaAdj.size();
        arvoreGeradora = new int[V-1][2];
    }
    
    public void bfs(int vertice){
        boolean[] visitado = new boolean[V];
        int[] tempoEntrada = new int [V];

        LinkedList<Integer> fila = new LinkedList<>();

        visitado[vertice]=true;
        fila.add(vertice);
        tempoEntrada[vertice] = tempo + 1;
  
        while (!fila.isEmpty()) {

            vertice = fila.poll();

            for (int n : listaAdj.get(vertice)) {

                if (!visitado[n]) {
                    arvoreGeradora[tempo][0] = vertice;
                    visitado[n] = true;
                    fila.add(n);
                    arvoreGeradora[tempo][1] = n;
                    tempo++;
                    tempoEntrada[n] = tempo + 1;
                }
            } 
        }
        System.out.println("Arvore geradora: " + Arrays.deepToString(arvoreGeradora));
        System.out.println("Vetor de tempo de entrada: " + Arrays.toString(tempoEntrada));
    }
}
