/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public final class Conexo {
    private ArrayList<ArrayList<Integer>> listaAdj = new ArrayList();
    private final int vertices;
    private int qntComponentes;
    
    public Conexo(ArrayList<ArrayList<Integer>> listaAdj){
        this.vertices = listaAdj.size();
        this.listaAdj = listaAdj;
        conexo();
    }
    
    public void conexo(){
        boolean[] visitado = new boolean[vertices];
        for (int verticeAtual = 0; verticeAtual < vertices; verticeAtual++) {
            if(!visitado[verticeAtual]){
                DFSutil(verticeAtual, visitado);
                qntComponentes++;
            }
        }
    }
    
    private void DFSutil(int verticeAtual, boolean[] visitado){
        visitado[verticeAtual] = true;
        for(int x = 0; x < listaAdj.get(verticeAtual).size(); x++){
            if(!visitado[listaAdj.get(verticeAtual).get(x)]){
                DFSutil(listaAdj.get(verticeAtual).get(x), visitado);
            }
        }
    }
    
    public  boolean isConexo(){
        return qntComponentes == 1;
    }
    
    @Override
    public String toString(){
        if(qntComponentes > 1){
            return"Grafo não é Conexo | Quantidade de componentes: " + qntComponentes;
        }else if(qntComponentes == 1){
            return"É Conexo";
        }else{
            return"qntComponentes: " + qntComponentes;
        }
    }
    
}
