package grafos;

import java.util.Scanner;

/**
 * Alunos: Matheus Alano | Gabriel
 * @author mathe
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Util util = new Util();
        int opcao;
        do{
            System.out.println("Qual o tipo do Grafo?");
            System.out.println("1) Não direcionado e sem peso");
            System.out.println("2) Direcionado e com peso");
            System.out.println("0) Sair");
            System.out.print  (">> ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();
            if(opcao == 1 || opcao == 2) util.initDado(); //Somente le os dados se não for 0;
            switch (opcao){
                case 0: break;
                case 1:
                    MenuGrafoND menuND = new MenuGrafoND(util.getListaElementos());
                    menuND.menuPrincipal();
                    break;
                case 2:
                    MenuGrafoD menuD = new MenuGrafoD(util.getListaElementos());
                    menuD.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção incorreta!");
                    Util.pausa();
                    break;               
            }           
        }while (opcao != 0);
    }
}
