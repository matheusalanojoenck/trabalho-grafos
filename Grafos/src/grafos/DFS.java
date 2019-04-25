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
    
    public void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited); 
    }
    
    private void DFSUtil(int v,boolean visited[]) { 
        visited[v] = true; 
        System.out.print(v+" "); 
   
        Iterator<Integer> i = listaAdj.get(v).listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
    
}
