/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 * ttps://www.geeksforgeeks.org/eulerian-path-and-circuit/
 * @author mathe
 */
public class Euleriano {
    private ArrayList<ArrayList<Integer>> listaAdj;
    private int verticeImpar = 0;
    private int tipoEuleriano = -1;
    
    public Euleriano(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = new ArrayList<>();
        this.listaAdj = listaAdj;
    }
    
    /**
     * Verifica se o grafo é euleriano
     * @return 0 - Não Euleriano | 1 - Semi-Euleriano | 2 - Euleriano
     */
    public int isEuleriano(){
        Conexo conexo = new Conexo(listaAdj);
        
        if(!conexo.isConexo()) return 0;
        
        int impar = 0;

        //Procura a quantidade de vertices de grau impar
        for (int i = 0; i < listaAdj.size(); i++) {
            if(listaAdj.get(i).size()%2 != 0){
                impar++;
                verticeImpar = i; //ultimo vertice de grau impar encontrado
            }
        }
        
        if(impar > 2) return tipoEuleriano = 0;

        if(impar == 2){
            return  tipoEuleriano = 1;
        }else{
            return tipoEuleriano = 2; //Um grafo conexo nunca vai ter um vertice impar unico
        }

        //return (impar == 2) ? tipoEuleriano = 1 : tipoEuleriano = 2;
    }

    //Retorna o ultima vertice impar encontrado
    public int getVerticeImpar(){
        return verticeImpar;
    }

    //Mostra uma mensagem informando se o grafo é euleriano
    @Override
    public String toString(){
        switch (tipoEuleriano) {
            case 0:
                return "O Grafo não é Euleriano";
            case 1:
                return "O Grafo é Semi-Euleriano";
            case 2:
                return "O Grafo é Euleriano";
            default:
                return "isEuleriano não retornou 0, 1 ou 2!";
        }
    }
    
}
