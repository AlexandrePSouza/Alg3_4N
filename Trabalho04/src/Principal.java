import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        Grafo grafo = new Grafo();
        int origem, destino;
        
        grafo.criaGrafo();
        
        System.out.print("Informe o vertice de ORIGEM: ");
        origem = scan.nextInt();
        
        System.out.print("Digite o vertice de DESTINO: ");
        destino = scan.nextInt();
        
        System.out.println("\n Calculando Custo de "+origem+" para "+destino);
        
        grafo.inicializaCusto(origem);
       
        grafo.Dijkstra();
        
        System.out.println("O menor caminho de "+origem+" para "+destino+ " é:\n"+grafo.calculaCaminho(origem, destino));
    }
}