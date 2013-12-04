import java.util.ArrayList;

public class Vertice {
	private boolean visitado = false;
	private ArrayList<Integer> valor = new ArrayList<Integer>();
	private int custo = Integer.MAX_VALUE;
	private int contador;
	private int anterior = -1;
	private ArrayList<Integer> verticesAdjacentes = new ArrayList<Integer>();


	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean jaVisitado() {
		return visitado;
	}
	
	public void setValor(int valor) {
		this.valor.add(valor);
	}

	public ArrayList<Integer> getValor() {
		return valor;
	}
	
	public void setCusto(int custo) {
		this.custo = custo;
	}

	public int getCusto() {
		return custo;
	}

	public void setAnterior(int anterior) {
		this.anterior = anterior;
	}

	public int getAnterior() {
		return anterior;
	}

	public void setVerticesAdjacentes(int valor) {
		this.verticesAdjacentes.add(valor);
	}

	public ArrayList<Integer> getVerticesAdjacentes() {
		return verticesAdjacentes;
	}
		
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}



}