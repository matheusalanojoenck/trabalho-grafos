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
    
    private ArrayList<Integer> listaElementos = new ArrayList<>();

    public static void pausa(){
        System.out.println("Aperte 'Enter' para continuar...");
        try{
            System.in.read();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
    
    public  void initDado(){
        Scanner scanner;
        try {
            System.out.print("Nome do arquivo: ");
            scanner = new Scanner(System.in);
            String nomeArquivo = scanner.nextLine();
            scanner = new Scanner(new File("dados/"+ nomeArquivo + ".txt"));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
            return;
        }

        listaElementos = new ArrayList<>();

        while(scanner.hasNextInt()){
            Integer elemento = scanner.nextInt();
            listaElementos.add(elemento);
        }
    }
    
    public ArrayList<Integer> getListaElementos(){
        return listaElementos;
    }
    
}
