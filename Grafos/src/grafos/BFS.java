/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class BFS {
    
    private ArrayList<ArrayList<Integer>> listaAdj = new ArrayList();
    private final int V;
    
    public BFS(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = listaAdj;
        V = listaAdj.size();
    }
    
    public void BFS(int s){
        boolean visited[] = new boolean[V]; 
 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        visited[s]=true; 
        queue.add(s); 
  
        while (!queue.isEmpty()) { 
            
            s = queue.poll(); 
            System.out.print(s+" "); 

            Iterator<Integer> i = listaAdj.get(s).listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    }
    
}
