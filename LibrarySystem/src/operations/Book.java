package operations;

public class Book {
	private int id;
	private String titlu;
	private String autor;
	private int nrbucati;
	private double pret;
	public Book(int id, String titlu, String autor, int nrbucati, double pret) {
		super();
		this.setId(id);
		this.setTitlu(titlu);
		this.setAutor(autor);
		this.setNrbucati(nrbucati);
		this.setPret(pret);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNrbucati() {
		return nrbucati;
	}
	public void setNrbucati(int nrbucati) {
		this.nrbucati = nrbucati;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}

	
}
