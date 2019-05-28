package grafos;

import java.util.ArrayList;
import java.util.Arrays;

public class Fleury {
    
    private ArrayList<ArrayList<Integer>> adj;
    private final int verticesQnt; //quantidade de vertices do grafo
    private int arestasQnt = 0; // quantidade de arestas do grafo
    private int [][] caminhoEuleriano; //vetor para guardar o caminho euleriano
    private int index = 0;
    
    public Fleury(ArrayList<ArrayList<Integer>> listaAdjOriginal){
        verticesQnt = listaAdjOriginal.size();
        initLista(listaAdjOriginal);
    }

    /*
     * Copia a lista original, pois o algoritmo altera a lista de adjacencia
     */
    private void initLista(ArrayList<ArrayList<Integer>> listaAdjOriginal){
        adj = new ArrayList<>();
        for (int i = 0; i < verticesQnt; i++) {
            adj.add(new ArrayList<>());
            arestasQnt = arestasQnt + listaAdjOriginal.get(i).size(); //Faz a soma dos graus dos vertices para calcular a quantidade de vertices
            for (int j = 0; j < listaAdjOriginal.get(i).size(); j++) {
                adj.get(i).add(listaAdjOriginal.get(i).get(j));
            }
        }

        arestasQnt = arestasQnt/2; //calcula a quantidade de arestas baseado na quantidade total dos graus dos vertices

        caminhoEuleriano = new int[arestasQnt][2]; //cria um vetor que vai guardar o caminho euleriano
    }

    public void printCicloEuleriano(){
        cicloEuleriano();
        System.out.println("Caminho Euleriano: " + Arrays.deepToString(caminhoEuleriano) + "\n");
    }

    /*
    Primeiro verifica se o grafo é euleriano ou semi euleriano.
    Depois depois pega um vertice de grau impar, se há algum.
    Chama a função printEulerUtil para mostar o caminho
    */
    private void cicloEuleriano(){
        Euleriano euleriano = new Euleriano(adj);
        int resp = euleriano.isEuleriano();
        System.out.println(euleriano.toString());
        
        if(resp == 1 || resp == 2){
            Integer u = euleriano.getVerticeImpar();
            printEulerUtil(u);
            System.out.println();
        }
    }



    private void printEulerUtil(Integer u){

        /*
        De forma recursiva passa por todos os verticesQnt adjacentes a vertice u.
        */
        for (int i = 0; i < adj.get(u).size(); i++) {
            Integer v = adj.get(u).get(i);

            if(isProximaArestaValida(u, v)){
                caminhoEuleriano[index][0] = u; // u é origem da aresta
                caminhoEuleriano[index][1] = v; // v é destino da aresta
                index++; // caminha no vetor 'caminhoEuleriano', cada posição do vetor é um aresta que pertence ao caminho euleriano
                removeAresta(u, v); //quando uma aresta é adicionada no caminho euleriano, se retira a mesma do grafo inicial.
                printEulerUtil(v); // chamada recursiva para o proximo vertice
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
        boolean[] isVisitado = new boolean[this.verticesQnt]; //vetor para marcar os vertices visitados, é passado como arugumento em dfsCount
        int count1 = dfsCount(u, isVisitado); //quantidade vertice alcançaveis apartir do vertice u

        // b) Remova a aresta u - v e apos remover,
        //conte os vertices alcançáveis a partir u
        removeAresta(u, v); //remove a aresta u - v
        isVisitado = new boolean[this.verticesQnt]; //vetor para marcar os vertices visitados, é passado como arugumento em dfsCount
        int count2 = dfsCount(u, isVisitado); //conta os vertices alcançaveis apartir de um vertice após a remoção da aresta

        addAresta(u, v); //Adcione a aresta que foi removida

        // Verifique se a count1 é maior que count2, se não for o vertice não é valido.
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


