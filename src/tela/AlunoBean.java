package tela;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.PersistenceException;

import dao.CursoDao;
import modelo.Aluno;
import modelo.Curso;

@ManagedBean(name = "alunoBean")
public class AlunoBean {
	@EJB
	private CursoDao dao;

	private String nome;
	private String email;
	private Integer curso;

	private String titulo;
	private String mensagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return dao.getCursos();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void salvar() {
		try {
			Curso oCurso = dao.getCurso(curso);

			if (oCurso == null) {
				titulo = "Problema";
				mensagem = "A Turma não está cadastrada";
			} else {

				Aluno obj = new Aluno();
				obj.setNome(nome);
				obj.setEmail(email);
				obj.setCurso(oCurso);

				oCurso.getAlunos().add(obj);

				dao.adiciona(obj);

				titulo = "Sucesso";
				mensagem = "Aluno cadastrado com sucesso";
			}
		} catch (PersistenceException ex) {
			titulo = "Falha";
			mensagem = "Erro no acesso ao Bando de Dados";
		}
	}
}
