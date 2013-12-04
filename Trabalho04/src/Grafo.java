import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

	Scanner scan = new Scanner(System.in);
	private ArrayList<Vertice> grafo = new ArrayList<Vertice>();
	private ArrayList<Integer> caminho = new ArrayList<Integer>();
	private ArrayList<Integer> custo = new ArrayList<Integer>();

	int verticeOrigemExiste = -1;
	int verticeDestinoExiste = -1;

	public Grafo() throws FileNotFoundException {
		String nomeArquivo = "c:\\x\\teste.txt";
		this.scan = new Scanner(new FileReader(nomeArquivo));
	}

	public String calculaCaminho(int origem, int destino) {

		String mensagem = "De " + origem + "";
		this.caminho.add(destino);
		int custoTotal = this.grafo.get(destino).getCusto();

		for (int i = 0; i < this.grafo.size(); i++) {
			if (this.grafo.get(i).getContador() == destino && destino != origem) {
				this.caminho.add(this.grafo.get(i).getAnterior());
				destino = this.grafo.get(i).getAnterior();
				i = 0;
			}
		}

		for (int i = caminho.size() - 1; i >= 0; i--) {
			mensagem = mensagem + " para " + this.caminho.get(i);

		}
		mensagem = mensagem + "\n Com custo total de: " + custoTotal;

		return mensagem;
	}

	public void criaGrafo() throws FileNotFoundException, IOException {
		int verticeOrigem;// = Integer.parseInt(scan.next());
		int verticeDestino;// = Integer.parseInt(scan.next());

		do {
			verticeOrigem = Integer.parseInt(scan.next());
			this.verticeOrigemExiste = verificaOrigem(verticeOrigem);

			// Nao existe vertice
			if (this.verticeOrigemExiste != -1) {
				verticeDestino = Integer.parseInt(scan.next());

				verticeDestinoExiste = verificaDestino(verticeDestino);
				if (verticeDestinoExiste == -1) {
					Vertice ver = new Vertice();

					ver.setContador(verticeDestino);

					grafo.add(ver);
				}
				grafo.get(this.verticeOrigemExiste).setVerticesAdjacentes(
						verticeDestino);
				grafo.get(this.verticeOrigemExiste).setValor(
						Integer.parseInt(scan.next()));
			} else {
				Vertice ver = new Vertice();
				ver.setContador(verticeOrigem);
				verticeDestino = Integer.parseInt(scan.next());
				this.verticeDestinoExiste = verificaDestino(verticeDestino);

				if (this.verticeDestinoExiste == -1) {
					Vertice ver2 = new Vertice();
					ver2.setContador(verticeDestino);
					grafo.add(ver2);
				}
				ver.setVerticesAdjacentes(verticeDestino);

				ver.setValor(Integer.parseInt(scan.next()));
				grafo.add(ver);
			}
		} while (scan.hasNext());
	}

	public void inicializaCusto(int origem) {
		for (int i = 0; i < grafo.size(); i++) {
			if (grafo.get(i).getContador() == origem) {
				grafo.get(i).setCusto(0);
				break;
			}
		}
	}


	public void Dijkstra() {
		int existeVerticeNaoVisitado;
		int menorCustoNaoVisitada = Integer.MAX_VALUE;
		do {
			existeVerticeNaoVisitado = 0;

			for (int i = 0; i < grafo.size(); i++) {
				if (grafo.get(i).getCusto() <= menorCustoNaoVisitada
						&& (grafo.get(i).jaVisitado() == false)) {
					menorCustoNaoVisitada = grafo.get(i).getCusto();
				}
			}

			for (int i = 0; i < grafo.size(); i++) {
				if (grafo.get(i).getCusto() == menorCustoNaoVisitada
						&& (grafo.get(i).jaVisitado() == false)) {
					grafo.get(i).setVisitado(true);

					for (int j = 0; j < grafo.get(i).getVerticesAdjacentes().size(); j++) {
						int id = grafo.get(i).getVerticesAdjacentes().get(j);

						for (int k = 0; k < grafo.size(); k++) {
							if (grafo.get(k).getContador() == id) {
								id = k;
								break;
							}
						}

						int soma = grafo.get(i).getCusto()
								+ grafo.get(i).getValor().get(j);
						if (soma < 0) {
							soma = Integer.MAX_VALUE;
						}

						if (grafo.get(id).getCusto() > soma) {
							grafo.get(id).setCusto(
									grafo.get(i).getCusto()
											+ grafo.get(i).getValor().get(j));
							grafo.get(id).setAnterior(
									grafo.get(i).getContador());
						}
					}
					menorCustoNaoVisitada = Integer.MAX_VALUE;
					break;
				}
			}

			for (int i = 0; i < grafo.size(); i++) {
				if (!grafo.get(i).jaVisitado()) {
					existeVerticeNaoVisitado++;
				}
			}

		} while (existeVerticeNaoVisitado != 0);
	}

	public int verificaOrigem(int numeroVertice) {
		this.verticeOrigemExiste = -1;
		for (int i = 0; i < grafo.size(); i++) {
			if (grafo.get(i).getContador() == numeroVertice) {
				this.verticeOrigemExiste = i;
				break;
			}
		}
		return this.verticeOrigemExiste;
	}

	public int verificaDestino(int numeroVertice) {
		this.verticeDestinoExiste = -1;
		for (int i = 0; i < grafo.size(); i++) {
			if (grafo.get(i).getContador() == numeroVertice) {
				this.verticeDestinoExiste = i;
				break;
			}
		}
		return this.verticeDestinoExiste;
	}
}