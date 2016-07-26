package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Aluno;
import modelo.Curso;

@Stateless
public class CursoDao {
	@PersistenceContext(unitName="CursosEAlunos2")
	private EntityManager manager;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Date makeDate(String data) {
		try {
			return sdf.parse(data);
		} catch (ParseException ex) {
			return new Date();
		}
	}
	
	public void adiciona(Object obj) {
		System.out.println("-- Salvo: " + obj);
		manager.merge(obj);
	}

	public Curso getCurso(int id) {
		return manager.find(Curso.class, id);
	}

	public Aluno getAluno(int id) {
		return manager.find(Aluno.class, id);
	}

	public void removeCurso(int id) {
		Curso obj = getCurso(id);
		obj.setDesativado(true);
		manager.merge(obj);
	}
	
	public void removeAluno(int matricula) {
		Aluno obj = getAluno(matricula);
		// Obtem o curso que o aluno esta matriculado
		Curso curso = obj.getCurso();
		// Remove o aluno do curso
		curso.getAlunos().remove(obj);
		// remove o aluno
		manager.remove(obj);
		manager.merge(curso);
	}
	
	public List<Curso> getCursos() {
		return manager.createNamedQuery("Cursos", Curso.class).getResultList();
	}
	
	public List<Aluno> getAlunos() {
		return manager.createNamedQuery("Alunos", Aluno.class).getResultList();
	}
}
