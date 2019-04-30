package grafos;

import java.util.ArrayList;

public class Fleury {
    
    private ArrayList<ArrayList<Integer>> adj;
    private final int vertices;
    
    public Fleury(ArrayList<ArrayList<Integer>> listaAdjOriginal){
        vertices = listaAdjOriginal.size();
        initLista(listaAdjOriginal);
    }

    /*
     * Copia a lista original, pois o algoritmo altera a lista de adjacencia
     */
    private void initLista(ArrayList<ArrayList<Integer>> listaAdjOriginal){
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < listaAdjOriginal.get(i).size(); j++) {
                adj.get(i).add(listaAdjOriginal.get(i).get(j));
            }
        }  
    }

    /*
    Primeiro verifica se o grafo é euleriano ou semi euleriano.
    Depois verifica se há um vertice impar e depois chama
    a função printEulerUtil a mostar o caminho
    */
    public void printCicloEuleriano(){
        Euleriano euleriano = new Euleriano(adj);
        int resp = euleriano.isEuleriano();
        System.out.println(euleriano.toString());
        
        if(resp == 1 || resp == 2){
            Integer u = 0;
            for (int i = 0; i < vertices ; i++) {
                if(adj.get(i).size() % 2 == 1){
                    u = i;
                    break;
                }
            }
            printEulerUtil(u);
            System.out.println();
        }
    }



    private void printEulerUtil(Integer u){

        /*
        De forma recursiva passa por todos os vertices adjacentes a vertice u.
        */
        for (int i = 0; i < adj.get(u).size(); i++) {
            Integer v = adj.get(u).get(i);

            if(isProximaArestaValida(u, v)){
                System.out.printf("%d-%d ", u, v);
                
                removeAresta(u, v);
                printEulerUtil(v);
            }
        }
    }

    /*
    Verifica se a aresta u - v pode ser removida.
     */
    private boolean isProximaArestaValida(Integer u, Integer v){

        //A aresta é valida caso:

        //O vertice v for o unico adjacente ao vertice u
        if(adj.get(u).size() == 1) {
            return true;
        }

        //Se houver mais de um vertice adjacente então:
        // a) Conte os vertices alcançáveis a partir de u
        boolean[] isVisitado = new boolean[this.vertices];
        int count1 = dfsCount(u, isVisitado);

        // b) Remova a aresta u - v e apos remover,
        //conte os vertices alcançáveis a partir u
        removeAresta(u, v);
        isVisitado = new boolean[this.vertices];
        int count2 = dfsCount(u, isVisitado);


        //Adcione a aresta que foi removida
        //Verifique se a count1 é maior que count2, se não for o vertice não é valido.
        addAresta(u, v);
        return(count1 > count2) ? false : true;
    }

    //Contar vertices alcançáveis a partir de um vertice
    private int dfsCount(Integer v, boolean[] isVisitado){

        //Marcar o vetice atual como visitado
        isVisitado[v] = true; 
        int count = 1;


        for(int adj : adj.get(v)){
            if(!isVisitado[adj]){
                count = count + dfsCount(adj, isVisitado);
            }
        }
        return count;
    }
    
    private void removeAresta(Integer u, Integer v){
        adj.get(u).remove(v);
        adj.get(v).remove(u);
    }
    
    private void addAresta(Integer u, Integer v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
} 


