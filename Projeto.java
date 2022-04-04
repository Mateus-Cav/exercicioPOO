package avaliacaofinal;

public class Projeto {

	private int id;
	private String nome;
	private double custo;
	
	public void computarCusto(Tarefa tarefa) {
		if(tarefa.getTipo() == 'D' || tarefa.getTipo() == 'E') {
			custo = tarefa.getValor();
		}
	}

	public Projeto(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.custo = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public int getId() {
		return id;
	}
	
	
	
}
