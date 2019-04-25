package grafos;

import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class ListaAdj {
    
    private final ArrayList<ArrayList<Integer>> listaAdj;
    
    public ListaAdj(ArrayList<Integer> listaElementos){
        listaAdj = new ArrayList();
        setListaAdj(listaElementos);
    }
    
    private void setListaAdj(ArrayList<Integer> listaElementos){
        listaAdj.add(new ArrayList());
        int j = 0;
        for (int i = 0; i < listaElementos.size()-1; i++) {
            if(listaElementos.get(i) != -1){
                listaAdj.get(j).add(listaElementos.get(i));
            }else{
                listaAdj.add(new ArrayList());
                j++;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> getListaAdj(){
        return listaAdj;
    }
    
    public int getGrau(int vertice){
        return listaAdj.get(vertice).size();
    }
    
    public void addVertice(){
        listaAdj.add(new ArrayList());
    }
    
    public void addArrresta(Integer v1, Integer v2){
        listaAdj.get(v1).add(v2);
        listaAdj.get(v2).add(v1);
    }
    
    public void removeAresta(Integer v1, Integer v2){
        listaAdj.get(v1).remove(v2);
        listaAdj.get(v2).remove(v1); 
    }
    
    public void showListaAdj(){
        for (int j = 0; j < listaAdj.size(); j++) {
            System.out.printf("%d: ", j);
            for (int k = 0; k < listaAdj.get(j).size(); k++) {
                System.out.printf("%d ", listaAdj.get(j).get(k));
            }
            System.out.println();
        }
    }
}
