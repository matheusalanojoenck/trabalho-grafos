package grafos;

import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class Dijkstra {
    
    private LinkedList<LinkedList<Integer>> matrizAdjPeso;
    private final int V;
    
    public Dijkstra(LinkedList<LinkedList<Integer>> matrizAdjPeso){
        this.matrizAdjPeso = matrizAdjPeso;
        V = matrizAdjPeso.size();
    }

    private boolean verificaNegativo(){
        for (int i = 0; i < matrizAdjPeso.size(); i++) {
            for (int j = 0; j < matrizAdjPeso.get(i).size(); j++) {
                if(matrizAdjPeso.get(i).get(j) < 0) return true;
            }
        }
        return false;
    }

    //Encontra o vertice com a menor distancia no conjunto de vertices não visitados
    private int minDistance(int[] estimativa, boolean[] visitado) {
        int min = Integer.MAX_VALUE;//pré defini a menor distancia como infinito
        int min_index = -1; //index do vertice com menor distancia
  
        //Passando por todos os vertices do grafo
        for (int v = 0; v < V; v++){
            //vertice não visitado com distancia para origem menor que a menor distancia encontrada
            if (!visitado[v] && estimativa[v] <= min){
                min = estimativa[v]; //atualizar a menor distancia com a distancia de v para origem
                min_index = v; //salvar o index do vertice com menor distancia
            }
        }
        return min_index; //retorna o index do vertice com menor distancia para origem
    }

    private void printSolution(int[] estimativa, int[] precedente){
        System.out.println("Vertices | Distancia da Origem | Precedente" );
        for (int i = 0; i < V; i++){
            System.out.println(i + " \t\t\t\t " + estimativa[i] + "\t\t\t\t\t" + precedente[i]);
        }
    }

    public void dijkstra(int origem){
        if(verificaNegativo()){
            System.out.println("O grafo tem peso negativo!");
            return;
        }

        //vetor que guarda o valor da distancia da origem para os outros vertices
        int[] estimativa = new int[V];

        //Marca os vertices vistados
        boolean[] visitado = new boolean[V];

        //Marca o vertice precedente do menor caminho da origem ao vertice atual
        int[] precedente = new int[V];

        //Marca o precedente do vertice de origem como ele mesmo
        precedente[origem] = origem;

        //Inicializa o vetor de distancia com infinito
        //e marca todos os vertices do vetor visitado[i] como 'false'
        for (int i = 0; i < V; i++){ 
            estimativa[i] = Integer.MAX_VALUE;//maior valor de um inteiro, representando infinito
            visitado[i] = false;
        }

        //Define a distancia do vertice origem para ele mesmo como 0
        estimativa[origem] = 0;


        //Vão ocorrer V interações, sendo V a quantidade de vertices no grafo
        for (int count = 0; count < V; count++) {


            int u = minDistance(estimativa, visitado);

            visitado[u] = true;

            //Atualize estimativa[v] somente se não estiver em visitado,
            //há uma aresta de u para v e o peso total do caminho da
            //origem para v atraves de u é menor que o valor atual valor de estimativa[v]
            for (int v = 0; v < V; v++) 
  
                if (!visitado[v] &&
                    matrizAdjPeso.get(u).get(v)!=0 && //u e v são adjacentes, sendo u -> v = peso
                    estimativa[u] != Integer.MAX_VALUE && //u já teve uma estimativa calculada

                    //distancia de u para origem + peso da resta u -> v, for menor que distancia de v para origem
                    estimativa[u]+matrizAdjPeso.get(u).get(v) < estimativa[v]){

                    //distancia de v para origem é igual a distancia de u para origem + peso de u -> v
                    estimativa[v] = estimativa[u] + matrizAdjPeso.get(u).get(v);

                    //vertice u precede v no caminho da origem até v
                    precedente[v] = u;
                }

        } 
        printSolution(estimativa, precedente);
    }   
}
