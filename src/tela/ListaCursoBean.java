package tela;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.persistence.PersistenceException;

import bean.CursoItem;
import dao.CursoDao;
import modelo.Curso;

@ManagedBean(name = "listaCursoBean")
public class ListaCursoBean {
	@EJB
	private CursoDao dao;

	private ListDataModel<CursoItem> cursos;
	private String titulo;
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public int getCount() {
		return getCursos().getRowCount();
	}

	public ListDataModel<CursoItem> getCursos() {
		List<Curso> lista = dao.getCursos();
		List<CursoItem> novaLista = new ArrayList<>();

		for (Curso item : lista) {
			novaLista.add(new CursoItem(item.getId(), item.getNome(), item.getDescr()));
		}

		cursos = new ListDataModel<>(novaLista);
		return cursos;
	}

	@SuppressWarnings("unchecked")
	public void remove() {
		int removidos = 0;
		try {
			for (CursoItem item : (List<CursoItem>) cursos.getWrappedData()) {
				if (item.isDel()) {
					dao.removeCurso(item.getId());
					removidos++;
				}
			}

			if (removidos == 0) {
				titulo = "Atenção";
				mensagem = "Não existem Cursos selecionados";
			} else {
				titulo = "Sucesso";
				mensagem = "Foram excluídos " + removidos + " Cursos";
			}
		} catch (PersistenceException ex) {
			titulo = "Falhar";
			mensagem = "Erro no acesso ao Bando de Dados";
		}

	}
}
