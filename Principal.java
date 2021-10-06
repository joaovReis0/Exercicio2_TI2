package com.ti2cc;

import java.util.*;

public class Principal {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		int opc = 0;
		
		dao.conectar();
		
		while(opc!=5) {
			System.out.println("Escolha uma opÁ„o:\n1- Para listar\n2- Para inserir\n3- Para excluir\n4- Para atualizar\n5- Para sair");
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
				System.out.println("Informe o cÛdigo do aluno:");
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
				
				System.out.println("Informe o que ir· atualizar nas informaÁıes do aluno:\n- Digite 1 para alterar o cÛdigo\n- Digite 2 para alterar o nome\n- Digite 3 para alterar a turma\n- Digite 4 para alterar o sexo");
				opc2 = sc.nextInt();
				
				if(opc2==1) {
					int cod;
					System.out.println("Informe o novo cÛdigo:");
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
					System.out.println("OpÁ„o Inv·lida!");
				}
				break;
			default:
				System.out.println("OpÁ„o inv·lida!");
				break;
			}
		}

		/*
		//Inserir um elemento na tabela
		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inser√ß√£o com sucesso -> " + usuario.toString());
		}
		
		//Mostrar usu√°rios do sexo masculino		
		System.out.println("==== Mostrar usu√°rios do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usu√°rio
		usuario.setSenha("nova senha");
		dao.atualizarUsuario(usuario);

		//Mostrar usu√°rios do sexo masculino
		System.out.println("==== Mostrar usu√°rios === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		//Excluir usu√°rio
		dao.excluirUsuario(usuario.getCodigo());
		
		//Mostrar usu√°rios
		usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usu√°rios === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}*/
		
		dao.close();
	}
}