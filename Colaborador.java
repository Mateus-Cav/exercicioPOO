package avaliacaofinal;

public class Colaborador {

	private int id;
	private String nome;
	private double salarioHora;
	
	public Colaborador(int id, String nome, double salarioHora) {
		super();
		this.id = id;
		this.nome = nome;
		this.salarioHora = salarioHora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}

	public int getId() {
		return id;
	}
	
	
	
}
