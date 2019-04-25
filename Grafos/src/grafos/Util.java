/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class Util {
    
    private ArrayList<Integer> listaElementos = new ArrayList();
    Scanner scanner;
    
    public static void pausa(){
        System.out.println("Aperte 'Enter' para continuar...");
        try{
           System.in.read();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    
    public  void initDado(){
        scanner = null;
        try {
            scanner = new Scanner(new File("dados/dados 5.txt"));
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            return;
        }

        listaElementos = new ArrayList();

        while(scanner.hasNextInt()){
            Integer elemento = scanner.nextInt();
            listaElementos.add(elemento);
        }
    }
    
    public ArrayList<Integer> getListaElementos(){
        return listaElementos;
    }
    
}
