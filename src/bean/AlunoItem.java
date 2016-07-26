package bean;

public class AlunoItem {
	private Integer matricula;
	private String nome;
	private String curso;
	private boolean del;

	public AlunoItem(int matricula, String nome, String curso) {
		this.del = false;
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
