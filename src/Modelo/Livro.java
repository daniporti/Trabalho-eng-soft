package Modelo;
/**
 * Classe onde é feito o objeto Livro
 * @author Daniel, Igor
 */
public class Livro{
	public String nome;
	public String autor;
	public Boolean emprestimo = false;
	public Livro prox;
	public Livro ant;
	public int quantEmprest;
	
	public void setProx (Livro prox){
		this.prox=prox;
	}

	public Livro getProx(){
		return prox;
	}

	public Livro getAnt(){
		return ant;
	}

	public void setAnt (Livro ant){
		this.ant = ant;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Boolean getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Boolean emprestimo) {
		this.emprestimo = emprestimo;
	}

	public int getQuantEmprest() {
		return quantEmprest;
	}

	public void setQuantEmprest(int quantEmprest) {
		this.quantEmprest = quantEmprest;
	}

	public void Imprime(){
		System.out.println("Nome: "+nome);
		System.out.println("Nome do Autor: "+ autor);
		if(emprestimo){
			System.out.println("Indisponivel");
		}else{
			System.out.println("Disponivel");
		}
	}

}