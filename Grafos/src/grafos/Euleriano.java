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
    
    public Euleriano(ArrayList<ArrayList<Integer>> listaAdj){
        this.listaAdj = new ArrayList();
        this.listaAdj = listaAdj;
    }
    
    /**
     * 
     * @return 0 - Não Euleriano | 1 - Semi-Euleriano | 2 - Euleriano
     */
    public int isEuleriano(){
        Conexo conexo = new Conexo(listaAdj);
        
        if(!conexo.isConexo()) return 0;
        
        int impar =0;
        for (int i = 0; i < listaAdj.size(); i++) {
            if(listaAdj.get(i).size()%2 != 0) impar++;
        }
        
        if(impar > 2) return 0;
        
        return (impar == 2)?1 : 2;
    }
    
    @Override
    public String toString(){
        int resposta = isEuleriano();
        
        switch (resposta) {
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
