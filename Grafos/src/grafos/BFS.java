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
    
    public void BFS(int vertice){
        boolean visitado[] = new boolean[V];

        LinkedList<Integer> fila = new LinkedList();

        visitado[vertice]=true;
        fila.add(vertice);
  
        while (!fila.isEmpty()) {
            
            vertice = fila.poll();
            System.out.print(vertice+" ");

            Iterator<Integer> i = listaAdj.get(vertice).listIterator();
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visitado[n])
                { 
                    visitado[n] = true;
                    fila.add(n);
                } 
            } 
        } 
    }
    
}
