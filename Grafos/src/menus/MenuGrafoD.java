/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import dataStructure.MatrizAdjPeso;
import grafos.Dijkstra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class MenuGrafoD {
    
    private final Scanner scanner = new Scanner(System.in);
    
    private final MatrizAdjPeso matrizAdjPeso;
    private Dijkstra dijkstra;
    
    public MenuGrafoD(ArrayList<Integer> listaElementos){
        matrizAdjPeso = new MatrizAdjPeso(listaElementos);
    }
    
    public void menuPrincipal(){
        int opcao;
        do{
            System.out.println("-- GRAFO COM PESO --");
            System.out.println("1) Matriz de Adjacencia");
            System.out.println("2) Adicionar Aresta");
            System.out.println("3) Remover Aresta");
            System.out.println("4) Dijkstra");
            System.out.println("0) Sair");
            System.out.print  (">> ");
            opcao = scanner.nextInt();
            switch (opcao){
                case 0: break;
                case 1: matrizAdjPeso.showMatriz(); break;
                case 2: subMenuAddAresta(); break;
                case 3: subMenuRemoveAresta(); break;
                case 4: subMenuDijkstra(); break;
                default: break;
            }
        }while(opcao != 0); 
    }
    
    private void subMenuAddAresta(){
        int v1, v2, peso;
        System.out.println("Vertice origem: ");
        v1 = scanner.nextInt();
        
        System.out.println("Vertice destino: ");
        v2 = scanner.nextInt();
        
        System.out.println("Peso do vertice: ");
        peso = scanner.nextInt();
        
        matrizAdjPeso.addAresta(v1, v2, peso);
                
    }
    
    private void subMenuRemoveAresta(){
        int v1, v2;
        System.out.println("Vertice origem: ");
        v1 = scanner.nextInt();
        
        System.out.println("Vertice destino: ");
        v2 = scanner.nextInt();
        
         matrizAdjPeso.removerAresta(v1, v2);
    }

    private void subMenuDijkstra() {
        int v1;
        System.out.println("Vertice origem: ");
        v1 = scanner.nextInt();
        
        dijkstra = new Dijkstra(matrizAdjPeso.getMatrizAdjPeso());
        dijkstra.dijkstra(v1);
    }
}
