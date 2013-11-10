public class Nodo {

	public String valor;
	public int indice, altura;
	public Nodo dir, esq, pai;
	public boolean black = true;

	public Nodo(int indice, String valor) {

		this.indice = indice;
		this.valor = valor;
	}
}
