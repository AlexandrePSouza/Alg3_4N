import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	private static String DELIMITADOR = "="; // DELIMITADORdo arquivo texto

	public static void main(String[] args) throws IOException {

		FileReader arq = new FileReader("C:\\teste\\arvore.txt");
		BufferedReader lerArq = new BufferedReader(arq);
		Arvore arv = new Arvore();
		String linha = lerArq.readLine();
		Scanner aux = new Scanner(System.in);

		while (linha != null) {
			String parametros[] = linha.split(DELIMITADOR);
			arv.inserir(parametros[0].toLowerCase(), parametros[1].toLowerCase());
			linha = lerArq.readLine();
		}

		while (!aux.toString().toLowerCase().equals("fim")) {
			switch (aux.next().toLowerCase()) {

			case "inserir":
				arv.inserir(aux.next(), aux.next());
				break;

			case "excluir":
				arv.excluir(aux.next());
				break;

			case "pesquisar":
				arv.pesquisar(aux.next());
			default:
				break;
			}
		}
	}
}