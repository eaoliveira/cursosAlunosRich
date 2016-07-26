package bean;

public class CursoItem {
	private Integer id;
	private String nome;
	private String descr;
	private boolean del;

	public CursoItem(int id, String nome, String descr) {
		this.del = false;
		this.id = id;
		this.nome = nome;
		this.descr = descr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
