/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mathe
 */
public class DFS {
    
    private ArrayList<ArrayList<Integer>> listaAdj = new ArrayList();
    private final int V;
    
    public DFS(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = listaAdj;
        V = listaAdj.size();
    }
    
    public void DFS(int origem){
        boolean visitado[] = new boolean[V];
        DFSUtil(origem, visitado);
    }
    
    private void DFSUtil(int origiem, boolean visitado[]) {
        visitado[origiem] = true;
        System.out.print(origiem+" ");
   
        Iterator<Integer> i = listaAdj.get(origiem).listIterator();
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visitado[n])
                DFSUtil(n, visitado);
        } 
    } 
    
}
