package com.ti2cc;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "HerokuPostgreSql_TI2";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "bnzwlodolaiseg";
		String password = "2f6ebd42053e010a8b9537bcecdb437e04b061672c97d67258820b9f2f7008e3";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirAluno(Aluno aluno) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO aluno (codigo, nome, turma, sexo) "
					       + "VALUES ("+aluno.getCodigo()+ ", '" + aluno.getNome() + "', '"  
					       + aluno.getTurma() + "', '" + aluno.getSexo() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarAluno(Aluno aluno) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE aluno SET nome = '" + aluno.getNome() + "', turma = '"  
				       + aluno.getTurma() + "', sexo = '" + aluno.getSexo() + "'"
					   + " WHERE codigo = " + aluno.getCodigo();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirAluno(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM aluno WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Aluno[] getAlunos() {
		Aluno[] alunos = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM aluno");		
	         if(rs.next()){
	             rs.last();
	             alunos = new Aluno[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                alunos[i] = new Aluno(rs.getInt("codigo"), rs.getString("nome"), 
	                		                  rs.getString("turma"), rs.getString("sexo").charAt(0));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return alunos;
	}

	
	public Aluno[] getAlunosMasculinos() {
		Aluno[] alunos = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM aluno WHERE aluno.sexo LIKE 'M'");		
	         if(rs.next()){
	             rs.last();
	             alunos = new Aluno[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                alunos[i] = new Aluno(rs.getInt("codigo"), rs.getString("nome"), 
                         		                  rs.getString("turma"), rs.getString("sexo").charAt(0));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return alunos;
	}
}