/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import dataStructure.ListaAdj;
import dataStructure.MatrizAdj;
import grafos.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class MenuGrafoND {
    private final MatrizAdj matrizAdj;
    private final ListaAdj listaAdj;
    private Conexo conexo;
    private Euleriano euleriano;
    private Fleury fleury;
    private DFS dfs;
    private BFS bfs;
    
    private final Scanner scanner = new Scanner( System.in );
    
    public MenuGrafoND(ArrayList<Integer> listaElementos){
        listaAdj = new ListaAdj(listaElementos);
        matrizAdj = new MatrizAdj(listaElementos);
    }
    
    
    public void menuPrincipal(){
        int opcao;
        do{
            System.out.println("1)  Matriz de Adjacência");
            System.out.println("2)  Lista de Adjacência");
            System.out.println("3)  Adicionar Aresta");
            System.out.println("4)  Adicionar Vértice");
            System.out.println("5)  Verificar se o grafo é Conexo");
            System.out.println("6)  Verificar se o grafo é Euleriano");
            System.out.println("7)  Algoritmo de Fleury");
            System.out.println("8)  DFS");
            System.out.println("9)  BFS");
            System.out.println("0)  Sair");
            System.out.print(">> ");
            opcao = scanner.nextInt();
            switch (opcao){
                case 0:
                    break;
                case 1:
                    subMenuMatrizAdj();
                    break;
                case 2:
                    subMenuListaAdj();
                    break;
                case 3:
                    subMenuAddAresta();
                    break;
                case 4:
                    listaAdj.addVertice();
                    matrizAdj.addVertice();
                    break;
                case 5:
                    conexo = new Conexo(listaAdj.getListaAdj());
                    System.out.println(conexo.toString());
                    break;
                case 6:
                    euleriano = new Euleriano(listaAdj.getListaAdj());
                    System.out.println(euleriano.toString());
                    break;
                case 7:
                    fleury = new Fleury(listaAdj.getListaAdj());
                    fleury.printCicloEuleriano();
                    break;
                case 8:
                    subMenuDFS();
                    break;
                case 9:
                    subMenuBFS();
                    break;
                default:
                    System.out.println("Opção incorreta!");
                    Util.pausa();
                    break;
            }
        }while(opcao != 0);
    }
    
    
    private void subMenuBFS(){
        int verticeInicio;
        System.out.printf("Número de vértices no Grafo atual: %d \n", listaAdj.getListaAdj().size());
        System.out.println("Escolha o vértice de inicio: ");
        verticeInicio = scanner.nextInt();
        if(verticeInicio < 0 || verticeInicio > listaAdj.getListaAdj().size()-1){
            System.out.println("Opção invalida!");
            Util.pausa();
        }else{
            bfs = new BFS(listaAdj.getListaAdj());
            bfs.BFS(verticeInicio);
            System.out.println();
        }
    }
    
    private void subMenuDFS(){
        int verticeInicio;
        System.out.printf("Número de vértices no Grafo atual: %d \n", listaAdj.getListaAdj().size());
        System.out.println("Escolha o vértice de inicio: ");
        verticeInicio = scanner.nextInt();
        if(verticeInicio < 0 || verticeInicio > listaAdj.getListaAdj().size()-1){
            System.out.println("Opção invalida!");
            Util.pausa();
        }else{
            dfs = new DFS(listaAdj.getListaAdj());
            dfs.DFS(verticeInicio);
            System.out.println();
        }
    }

    private void subMenuAddAresta(){
        int v1, v2;
        System.out.print("Vértice 1: ");
        v1 = scanner.nextInt();
        System.out.print("Vértice 2: ");
        v2 = scanner.nextInt();
        listaAdj.addArrresta(v1, v2);
        matrizAdj.addAresta(v1, v2);
    }

    private void subMenuMatrizAdj(){
        matrizAdj.showMatrizAdj();
    }

    private void subMenuListaAdj(){
        listaAdj.showListaAdj();
    }
    
}
