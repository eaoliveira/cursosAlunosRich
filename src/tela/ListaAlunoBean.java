package tela;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.persistence.PersistenceException;

import bean.AlunoItem;
import dao.CursoDao;
import modelo.Aluno;

@ManagedBean(name = "listaAlunoBean")
public class ListaAlunoBean {
	@EJB
	private CursoDao dao;

	private ListDataModel<AlunoItem> alunos;
	private String titulo;
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public int getCount() {
		return getAlunos().getRowCount();
	}

	public ListDataModel<AlunoItem> getAlunos() {
		List<Aluno> lista = dao.getAlunos();
		List<AlunoItem> novaLista = new ArrayList<>();

		for (Aluno item : lista) {
			novaLista.add(new AlunoItem(item.getMatricula(), item.getNome(), item.getCurso().getNome()));
		}

		alunos = new ListDataModel<>(novaLista);
		return alunos;
	}

	@SuppressWarnings("unchecked")
	public void remove() {
		int removidos = 0;
		try {
			for (AlunoItem item : (List<AlunoItem>) alunos.getWrappedData()) {
				if (item.isDel()) {
					dao.removeAluno(item.getMatricula());
					removidos++;
				}
			}
			
			if (removidos == 0) {
				titulo = "Atenção";
				mensagem = "Não existem Alunos selecionados";
			} else {
				titulo = "Sucesso";
				mensagem = "Foram excluídos " + removidos + " Alunos";
			}
		} catch (PersistenceException ex) {
			titulo = "Falhar";
			mensagem = "Erro no acesso ao Bando de Dados";
		}
	}
}
