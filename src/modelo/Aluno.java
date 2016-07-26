package modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Aluno2")
@NamedQuery(name="Alunos", query="select a from Aluno as a")
public class Aluno {
	@Id
	private int matricula;
	private String email;
	private String nome;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idCurso")
	private Curso curso;

	public Aluno() {
		super();
	}

	public Aluno(int matricula) {
		super();
		this.matricula = matricula;
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
