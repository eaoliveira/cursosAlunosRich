package tela;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.PersistenceException;

import dao.CursoDao;
import modelo.Curso;

@ManagedBean(name = "cursoBean")
public class CursoBean {
	@EJB
	private CursoDao dao;

	private String nome;
	private String desc;
	private Date data;
	private int horas = 20;

	private String titulo;
	private String mensagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setData(String data) {
		this.data = dao.makeDate(data);
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void salvar() {
		try {
			// salva os dados
			Curso obj = new Curso();
			obj.setNome(nome);
			obj.setDescr(desc);
			obj.setInicio(data);
			obj.setHoras(horas);
			
			dao.adiciona(obj);

			titulo = "Sucesso";
			mensagem = "O Curso foi cadastrado!";
		} catch (PersistenceException ex) {
			titulo = "Falha";
			mensagem = "Erro no acesso ao Bando de Dados";
		}
	}

}
