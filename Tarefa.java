package avaliacaofinal;

import java.util.Date;

public class Tarefa {

	private int id;
	private Colaborador colaborador;
	private Date data;
	private double nrHoras;
	private Character tipo;
	private double valor;
	
	public Tarefa(int id, Colaborador colaborador, Date data, double nrHoras, Character tipo) {
		super();
		this.id = id;
		this.colaborador = colaborador;
		this.data = data;
		this.nrHoras = nrHoras;
		this.tipo = tipo;
		this.valor = this.calcularValorTarefa();
	}

	public double calcularValorTarefa() {
		return this.nrHoras * this.colaborador.getSalarioHora();
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getNrHoras() {
		return nrHoras;
	}

	public void setNrHoras(double nrHoras) {
		this.nrHoras = nrHoras;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}
	
	
}
