/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class MatrizAdjPeso {
    
    private final LinkedList<LinkedList<Integer>> matrizAdjPeso = new LinkedList();
    private final LinkedList<LinkedList<Integer>> listaAdjPeso = new LinkedList();;
    private  int V = 0; //Maior numero dos vertices
    
    public MatrizAdjPeso(ArrayList<Integer> listaElementosPeso){
        initListaAdjPeso(listaElementosPeso);
        initMatrizAdjPeso();
        setMatrizAdjPeso();
    }
    
    private void initListaAdjPeso(ArrayList<Integer> listaElementosPeso){
        int index = 0;
        listaAdjPeso.add(new LinkedList());
        for (int i = 0; i < listaElementosPeso.size(); i++) { /*para não contar o ultimo -1 da entrado de dados*/
            Integer elemento = listaElementosPeso.get(i);
            if(elemento != -1){
                listaAdjPeso.get(index).add(elemento);
            }else{
                if(listaAdjPeso.get(index).get(0)>V) V = listaAdjPeso.get(index).get(0); /*Verfica o maior vertice*/
                if(listaAdjPeso.get(index).get(1)>V) V = listaAdjPeso.get(index).get(1); /*para saber a quantidade de vertices*/
                listaAdjPeso.add(new LinkedList());
                index++;
            }
        }
        listaAdjPeso.removeLast(); /*remove a ultima lista, porconta do ultimo -1 da entrada de dados*/
        V++; //Os vertices começam em zero, então o total de vertices é V + 1
    }
    
    private void initMatrizAdjPeso(){
        for (int i = 0; i < V; i++) {
            matrizAdjPeso.add(new LinkedList());
            for (int j = 0; j < V; j++) {
                matrizAdjPeso.get(i).add(0);
            }
        }
    }
    
    private void setMatrizAdjPeso(){
        for (int i = 0; i < listaAdjPeso.size(); i++) {
            addAresta(listaAdjPeso.get(i).get(0), listaAdjPeso.get(i).get(1), listaAdjPeso.get(i).get(2));
        }
    }
    
    public void addAresta(int orig, int dest, int peso){
        matrizAdjPeso.get(orig).set(dest, peso);
    }
    
    public void removerAresta(int orig, int dest){
        matrizAdjPeso.get(orig).set(dest, 0);
    }
    
    public void showMatriz(){
        for (int i = 0; i < matrizAdjPeso.size(); i++) {
            for (int j = 0; j < matrizAdjPeso.size(); j++) {
                System.out.printf("%d ", matrizAdjPeso.get(i).get(j));
            }
            System.out.println("");
        }
    }
    
    public LinkedList<LinkedList<Integer>> getMatrizAdjPeso(){
        return matrizAdjPeso;
    }
}
