package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author mathe
 */
public class DFS {
    
    private ArrayList<ArrayList<Integer>> listaAdj;
    private final int V;
    private int[][] arvoreGeradora;
    private int index = 0;
    
    public DFS(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = listaAdj;
        V = listaAdj.size();
        arvoreGeradora = new int[V-1][2];
    }
    
    public void dfs(int origem){
        boolean[] visitado = new boolean[V];
        dfsUtil(origem, visitado);
        System.out.println("Arvore geradora: " + Arrays.deepToString(arvoreGeradora));
    }
    
    private void dfsUtil(int origem, boolean[] visitado) {

        visitado[origem] = true;
        Iterator<Integer> i = listaAdj.get(origem).listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visitado[n]){
                arvoreGeradora[index][0] = origem;
                arvoreGeradora[index][1] = n;
                index++;
                dfsUtil(n, visitado);
            }
        }
    }
}
