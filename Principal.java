package com.ti2cc;

import java.util.*;

public class Principal {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		int opc = 0;
		
		dao.conectar();
		
		while(opc!=5) {
			System.out.println("Escolha uma opção:\n1- Para listar\n2- Para inserir\n3- Para excluir\n4- Para atualizar\n5- Para sair");
			opc = sc.nextInt();
			
			Aluno aluno = new Aluno();
			switch(opc) {
			case 1://listar
				System.out.println("Alunos:\n" + dao.getAlunos());
				break;
			case 2://inserir
				int codigo = 0;
				String nome, turma;
				char sexo;
				System.out.println("Informe o código do aluno:");
				codigo = sc.nextInt();
				aluno.setCodigo(codigo);
				
				System.out.println("Informe o nome do aluno");
				nome = sc.nextLine();
				aluno.setNome(nome);
				
				System.out.println("Informe a turma do aluno");
				turma = sc.nextLine();
				aluno.setTurma(turma);
				
				System.out.println("Informe o sexo do aluno");
				sexo = sc.next().charAt(0);
				aluno.setSexo(sexo);
				
				dao.inserirAluno(aluno);
				break;
			case 3://excluir
				dao.excluirAluno(aluno.getCodigo());
				break;
			case 4://atualizar
				int opc2 = 0;
				
				System.out.println("Informe o que irá atualizar nas informações do aluno:\n- Digite 1 para alterar o código\n- Digite 2 para alterar o nome\n- Digite 3 para alterar a turma\n- Digite 4 para alterar o sexo");
				opc2 = sc.nextInt();
				
				if(opc2==1) {
					int cod;
					System.out.println("Informe o novo código:");
					cod = sc.nextInt();
					
					aluno.setCodigo(cod);
					dao.atualizarAluno(aluno);
				}else if(opc2==2) {
					String name;
					System.out.println("Informe o novo nome:");
					name = sc.nextLine();
					
					aluno.setNome(name);
					dao.atualizarAluno(aluno);
				}else if(opc2==3) {
					String classe;
					System.out.println("Informe a nova turma:");
					classe = sc.nextLine();
					
					aluno.setTurma(classe);
					dao.atualizarAluno(aluno);
				}else if(opc2==4) {
					char sex;
					System.out.println("Informe o novo sexo:");
					sex = sc.next().charAt(0);
					
					aluno.setSexo(sex);
					dao.atualizarAluno(aluno);
				}else {
					System.out.println("Opção Inválida!");
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		
		dao.close();
	}
}
