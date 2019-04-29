package dataStructure;

import java.util.ArrayList;


public class MatrizAdj {
    
    private final ArrayList<ArrayList<Integer>> matrizAdj;
 
    public MatrizAdj(ArrayList<Integer> listaElementos) {
        matrizAdj = new ArrayList();
        setMatrizAdj(listaElementos);
    }
    
    private int contaVertice(ArrayList<Integer> listaElementos){
        int qntVertice = 0;        
        for(int i : listaElementos){
            if(i == -1) qntVertice++;
        }
        
        return qntVertice;
    }
    
    private void initMatrizAdj(ArrayList<Integer> listaElementos){
        int qntVertices = contaVertice(listaElementos);
        for (int i = 0; i < qntVertices; i++) {
            matrizAdj.add(new ArrayList());
            for (int j = 0; j < qntVertices; j++) {
                matrizAdj.get(i).add(0);
            }
        }
    }
    
    private void setMatrizAdj(ArrayList<Integer> listaElementos){
        initMatrizAdj(listaElementos);
        int vertice = 0;
        for (int i = 0; i < listaElementos.size()-1; i++) {
            if(listaElementos.get(i) != -1){
                matrizAdj.get(vertice).set(listaElementos.get(i), 1);
            }else{
                vertice++;
            }
        }
        
    }
    
    public ArrayList<ArrayList<Integer>> getMatriAdj(){
        return matrizAdj;
    }
    
    public int getGrau(int vertice){
        int grau = 0;
        
        for (int i = 0; i < matrizAdj.size(); i++) {
            if(matrizAdj.get(vertice).get(i).equals(1)) grau++;
        }
        
        return grau;
    }
    
    public void addVertice(){
        matrizAdj.add(new ArrayList());
        for (int i = 0; i < matrizAdj.size(); i++){
            matrizAdj.get(matrizAdj.size()-1).add(0);
            matrizAdj.get(i).add(0);
        }
    }
    
    public void addAresta(int v1, int v2){
        matrizAdj.get(v1).set(v2, 1);
        matrizAdj.get(v2).set(v1, 1);
    }
    
    public void removeAresta(int v1, int v2){
        matrizAdj.get(v1).set(v2, 0);
        matrizAdj.get(v2).set(v1, 0);
    }
    
    public void showMatrizAdj(){
        for (int i = 0; i < matrizAdj.size(); i++) {
            for (int j = 0; j < matrizAdj.size(); j++) {
                System.out.printf("%d ", matrizAdj.get(i).get(j));
            }
            System.out.println("");
        }
    }

}