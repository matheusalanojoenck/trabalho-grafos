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
    
    LinkedList<LinkedList<Integer>> matrizAdjPeso;
    private final int V;
    
    public Dijkstra(LinkedList<LinkedList<Integer>> matrizAdjPeso){
        this.matrizAdjPeso = matrizAdjPeso;
        V = matrizAdjPeso.size();
    }

    //Encontra a menor distancia do conjunto de vertices não visitados
    private int minDistance(int estimativa[], Boolean visitado[]) {
        int min = Integer.MAX_VALUE, min_index=-1;
  
        for (int v = 0; v < V; v++)
            if (visitado[v] == false && estimativa[v] <= min)
            {
                min = estimativa[v];
                min_index = v;
            }
  
        return min_index; 
    }

    private void printSolution(int[] estimativa, int[] precedente){
        System.out.println("Vertices | Distancia da Origem | Precedente" );
        for (int i = 0; i < V; i++){
            System.out.println(i + " \t\t\t\t " + estimativa[i] + "\t\t\t\t\t" + precedente[i]);


        }
    }

    public void dijkstra(int origem){

        //vetor que guarda o valor da distancia da origem para os outros vertices
        int[] estimativa = new int[V];

        //Marca os vertices vistados
        Boolean visitado[] = new Boolean[V];

        //Marca o vertice precedente do menonor caminho da origem ao vertice atual;
        int[] precedente = new int[V];

        //Inicializa o vetor de distancia com infinito
        //e marca todos os vertices do vetor visitado[i] como 'false'
        for (int i = 0; i < V; i++){ 
            estimativa[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        //Define a distancia do vertice origem para ele mesmo como 0
        estimativa[origem] = 0;


        for (int count = 0; count < V; count++) {

            int u = minDistance(estimativa, visitado);

            visitado[u] = true;

            //Atualize estimativa[v] somente se não estiver em visitado,
            //há uma aresta de u para v e o peso total do caminho da
            //origem para v atraves de u é menor que o valor atual valor de estimativa[v]
            for (int v = 0; v < V; v++) 
  
                if (!visitado[v] && matrizAdjPeso.get(u).get(v)!=0 &&
                    estimativa[u] != Integer.MAX_VALUE &&
                    estimativa[u]+matrizAdjPeso.get(u).get(v) < estimativa[v]){

                    estimativa[v] = estimativa[u] + matrizAdjPeso.get(u).get(v);
                    precedente[v] = u;
                }

        } 
        printSolution(estimativa, precedente);
    }   
}
