package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Curso2")
@NamedQuery(name="Cursos", query="select c from Curso as c where c.desativado = false")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCurso")
	private int Id;
	private String nome;
	@Column(name="descricao")
	private String descr;
	@Temporal(TemporalType.DATE)
	private Date inicio;
	@Column(name="numHoras")
	private int horas;
	@OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
	private List<Aluno> alunos = new ArrayList<>();
	private boolean desativado = false;

	public Curso() {
		super();
	}

	public Curso(int id) {
		super();
		Id = id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public boolean isDesativado() {
		return desativado;
	}

	public void setDesativado(boolean desativado) {
		this.desativado = desativado;
	}

	@Override
	public String toString() {
		return "Id: " + Id + "  nome: " + nome + "  descr: " + descr + "  inicio: " + inicio + "  horas: " + horas
				+ "  alunos: " + alunos + "  desativado: " + desativado;
	}

}
