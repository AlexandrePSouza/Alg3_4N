public class Arvore {

	private String chave;
	private String valor;
	private Nodo raiz;
	private Nodo tio;
	private int altura = 0;

	public void inserir(String chave, String valor) {
		Nodo novoNodo = new Nodo(chave.hashCode(), valor);
		if (raiz == null) {
			novoNodo.black = true;
			raiz = novoNodo;
			raiz.altura = 0;
			raiz.pai = null;
			raiz.dir = null;
			raiz.esq = null;
			return;
		}

		Nodo nodoAux = raiz;
		while (novoNodo.pai == null) {
			if (novoNodo.indice > nodoAux.indice) {
				altura++;
				if (nodoAux.dir == null) {
					nodoAux.dir = novoNodo;
					novoNodo.pai = nodoAux;
					novoNodo.dir = null;
					novoNodo.esq = null;
					novoNodo.altura = altura;
				}

				nodoAux = nodoAux.dir;
			}

			if (novoNodo.indice < nodoAux.indice) {
				altura++;
				if (nodoAux.esq == null) {
					nodoAux.esq = novoNodo;
					novoNodo.pai = nodoAux;
					novoNodo.dir = null;
					novoNodo.esq = null;
					novoNodo.altura = altura;
				}
				nodoAux = nodoAux.esq;
			}
		}
	}

	public void pesquisar(String chave) {
		int indice = chave.hashCode();
		Nodo nodoAux = raiz;

		while (nodoAux.indice != indice) {
			if (indice > nodoAux.indice) {
				if (nodoAux.dir.indice == indice) {
					System.out.println("Pai: " + nodoAux.dir.pai.valor
							+ "\r\n" + "valor: " + nodoAux.dir.valor);
				}
				nodoAux = nodoAux.dir;
			}

			if (indice < nodoAux.indice) {
				if (nodoAux.esq == null) {
					System.out
							.println("Pai: " + nodoAux.esq.pai.valor
									+ "\r\n" + "valor: "
									+ nodoAux.esq.valor);
				}
				nodoAux = nodoAux.esq;
			}
		}
	}

	public void excluir(String next) {
	}
	// Nao implementado
}