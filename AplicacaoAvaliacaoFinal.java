package avaliacaofinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AplicacaoAvaliacaoFinal {

	static Scanner in = new Scanner(System.in);
	static List<Colaborador> colaboradores = new ArrayList<Colaborador>();
	static List<Projeto> projetos = new ArrayList<Projeto>();
	static List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	public static void main(String[] args) throws ParseException {
		
		Colaborador c1 = new Colaborador(1, "Gustavo Pacheco", 35f);
		Colaborador c2 = new Colaborador(2, "Aldo Moura", 55f);
		Colaborador c3 = new Colaborador(3, "Maria Pia", 40f);
		Colaborador c4 = new Colaborador(4, "José Fonte", 25.50f);
		colaboradores.add(c1);
		colaboradores.add(c2);
		colaboradores.add(c3);
		colaboradores.add(c4);
		
		
		Projeto p1 = new Projeto(1, "Projeto Aulão JAVA");
		Projeto p2 = new Projeto(1, "Projeto Aulão SGBD");
		projetos.add(p1);
		projetos.add(p2);
		
		
		while(true) {
			System.out.println("MENU");
			System.out.println("[1] - Registrar tarefa"
					+ "\n[2] - Consultar projeto"
					+ "\n[3] - Consultar tarefas do colaborador"
					+ "\n[0] - Sair");
			
			int escolha = in.nextInt();
			
			switch(escolha) {
				case 1:
					registrarTarefa();
					break;
					
				case 2:
					consultarProjeto();
					break;
				case 3:	
					consultarTarefasDoColaborador();
					break;
					
				default:
					System.out.println("Opção incorreta!");
					continue;
					
				case 0:
					return;
			}
		}
		
	}

	
public static void registrarTarefa() throws ParseException {
	while(true) {
		System.out.println("Informe o ID do projeto: [0] para sair");
		int id = in.nextInt();
		if(id == 0) {
			return;
		}
		Projeto projeto = localizarProjeto(id);
		
		if(projeto == null) {
			System.out.println("Este projeto não foi localizado!");
			continue;
		}
		else {
			System.out.println("Informe o ID do colaborador: [0] para sair");
			int idColaborador = in.nextInt();
			if(idColaborador == 0) {
				return;
			}
			Colaborador colaborador = localizarColaborador(idColaborador);
			if(colaborador == null) {
				System.out.println("Colaborador não localizado!");
				continue;
			}
			else {
				System.out.println("Informe a data da tarefa: (dd/mm/aaaa) ");
				String dataString = in.next();
				while(true) {
					System.out.println("Informe o número de horas trabalhadas na tarefa:");
					int horas = in.nextInt();
					if(horas <= 0) {
						System.out.println("Impossível registrar hora menor ou igual a zero");
						continue;
					}
					while(true) {
						System.out.println("Informe o tipo da tarefa (C, D ou E)");
						Character tipoServ = in.next().charAt(0);
						if(tipoServ == 'C' || tipoServ == 'D' || tipoServ == 'E') {
							System.out.println("Informe o ID desta tarefa: ");
							int idTarefa = in.nextInt();
							SimpleDateFormat dataRecebida = new SimpleDateFormat("dd/MM/yyyy");
							Date data = dataRecebida.parse(dataString);
							Tarefa t1 = new Tarefa(idTarefa, colaborador, data, horas, tipoServ );
							tarefas.add(t1);
							System.out.println("Sucesso!");
							return;
						}
						else {
							System.out.println("Tipo incorreto!");
							continue;
						}
					}
				}	
			}
		}
	}
}

public static void consultarProjeto() {
	while(true) {
		System.out.println("Informe o ID do projeto: ");
		int id = in.nextInt();
		Projeto projeto = localizarProjeto(id);
		if(projeto == null) {
			System.out.println("Projeto inexistente");
			return;
		}
		else {
			
			System.out.println("ID:" + projeto.getId());
			System.out.println("Nome:"  + projeto.getNome());
			System.out.println("Custo: " + projeto.getCusto());
			return;
		}
	}	
}

public static void consultarTarefasDoColaborador() {
	double somaTotal = 0;
	while(true) {
		System.out.println("Informe o ID do colaborador: ");
		int id = in.nextInt();
		Colaborador colaborador = localizarColaborador(id);
		if(colaborador == null) {
			System.out.println("Colaborador inexistente");
			return;
		}
		else {
			System.out.println("Id colaborador: " + colaborador.getId());
			System.out.println("Nome colaborador: " + colaborador.getNome());
			for(Tarefa tarefa: tarefas) {
				if(tarefa.getColaborador().getId() == id) {
					System.out.println("Id tarefa: " + tarefa.getId());
					System.out.println("Data:" + tarefa.getData());
					System.out.println("Nº de horas: " + tarefa.getNrHoras());
					System.out.println("Tipo: " + tarefa.getTipo());
					System.out.println("Valor: " + tarefa.getValor());
					somaTotal = somaTotal + tarefa.getValor();
					
				}
			}
			System.out.println("Valor total:" + somaTotal);
		}
	}	
}

public static Projeto localizarProjeto(int id) {
	for(Projeto projeto: projetos) {
		if(projeto.getId() == id) {
			return projeto;
		}
	}
	return null;
}

public static Colaborador localizarColaborador(int id) {
	for(Colaborador colaborador: colaboradores) {
		if(colaborador.getId() == id) {
			return colaborador;
		}
	}
	return null;
}

}
