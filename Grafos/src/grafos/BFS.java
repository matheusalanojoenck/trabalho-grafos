package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class BFS {
    
    private ArrayList<ArrayList<Integer>> listaAdj;
    private final int V; //Quantidade de vertices
    private int[][] arvoreGeradora; //Vetor para guardar os vertices em ordem de visitação, [Origem, Destino]
    private int tempo = 0; //Quanto um vertice entrou na fila
    
    public BFS(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = listaAdj;
        V = listaAdj.size();
        arvoreGeradora = new int[V-1][2];
    }
    
    public void bfs(int vertice){
        //Todos os vertices são marcados como não visitados
        boolean[] visitado = new boolean[V];

        //Vetor que guarda o tempo de entrada de cada vértice;
        int[] tempoEntrada = new int [V];

        //Uma fila para o BFS
        LinkedList<Integer> fila = new LinkedList<>();

        //Marca o vertice atual como visitado
        visitado[vertice]=true;
        //Adiciona o vetice na fila
        fila.add(vertice);
        //Marca o tempo de entrada
        tempoEntrada[vertice] = tempo + 1; //O tempo inicia em zero, para questão de visialização é adicionado + 1 ao tempo para melhor entendimento

        //Repetir enquanto a fila não estiver vazia
        while (!fila.isEmpty()) {

            //Tira o primeiro vertice da fila
            vertice = fila.poll();

            //Para todos os vertice adjacentes ao vertice removido da fila:
            //Marcar como visitado os vertices não visitados e os adicionar na fila
            for (int n : listaAdj.get(vertice)) {
                if (!visitado[n]) {
                    //Adicionando o vertice ao vetor, a variavel tempo atual como index para o vetor
                    //vertice é a origem da aresta
                    arvoreGeradora[tempo][0] = vertice;

                    //Marcando o vertice adjacente como visitado
                    visitado[n] = true;
                    //Adicionando o vertice na fila
                    fila.add(n);

                    //O vertice adjacente n, é o destino da aresta
                    arvoreGeradora[tempo][1] = n;

                    //Aumenta o tempo das entradas
                    tempo++;
                    //Adiciona ao vertice o seu tempo de entrada na fila
                    tempoEntrada[n] = tempo + 1;
                }
            } 
        }
        System.out.println("Arvore geradora: " + Arrays.deepToString(arvoreGeradora));
        System.out.println("Vetor de tempo de entrada: " + Arrays.toString(tempoEntrada));
    }
}
