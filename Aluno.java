package com.ti2cc;

public class Aluno {
	private int codigo;
	private String nome;
	private String turma;
	private char sexo;
	
	public Aluno() {
		this.codigo = -1;
		this.nome = "";
		this.turma = "";
		this.sexo = '*';
	}
	
	public Aluno(int codigo, String nome, String turma, char sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
		this.sexo = sexo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Aluno [codigo=" + codigo + ", Nome=" + nome + ", Turma=" + turma + ", sexo=" + sexo + "]";
	}	
}
