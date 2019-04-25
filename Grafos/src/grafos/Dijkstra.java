/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class Dijkstra {
    
    LinkedList<LinkedList<Integer>> matrizAdjPeso = new LinkedList<>();
    private final int V;
    
    public Dijkstra(LinkedList<LinkedList<Integer>> matrizAdjPeso, int origem){
        this.matrizAdjPeso = matrizAdjPeso;
        V = matrizAdjPeso.size();
    }
    
    private int minDistance(int dist[], Boolean sptSet[]) { 
        int min = Integer.MAX_VALUE, min_index=-1;
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    private void printSolution(int dist[]){ 
        System.out.println("Vertice   Distancia da Origem"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" \t "+dist[i]); 
    } 

    public void dijkstra(int src){ 
        int dist[] = new int[V]; 

        Boolean sptSet[] = new Boolean[V]; 
  
        for (int i = 0; i < V; i++){ 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        dist[src] = 0; 
  
        for (int count = 0; count < V-1; count++) { 

            int u = minDistance(dist, sptSet); 
  
            sptSet[u] = true; 
  
            for (int v = 0; v < V; v++) 
  
                if (!sptSet[v] && matrizAdjPeso.get(u).get(v)!=0 && 
                    dist[u] != Integer.MAX_VALUE && 
                    dist[u]+matrizAdjPeso.get(u).get(v) < dist[v]) 
                        dist[v] = dist[u] + matrizAdjPeso.get(u).get(v); 
        } 
        printSolution(dist); 
    }   
}
