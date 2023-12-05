package Controle;
import Modelo.Input;
import Modelo.Livro;

public class Biblioteca {
    public Livro cabeca;

    /**
     * Metodo que faz a remoção de um livro
     * @author Geovanna
     */
    public void removeLivro(){
        String nomeLivro = Input.readString("Qual o nome do livro que deseja remover? ");
        
        Livro aux = cabeca;

        while (aux != null && !aux.getNome().equals(nomeLivro)){
            aux = aux.getProx();
        }

        if (aux != null){
            if (aux.getAnt() != null){
                aux.getAnt().setProx(aux.getProx());
            }else{
                cabeca = aux.getProx();
            }

            if (aux.getProx() != null){
                aux.getProx().setAnt(aux.getAnt());
            }
            System.out.println("Livro removido com sucesso!");
        }else{
            System.out.println("Livro não encontrado na biblioteca.");
        }
        menus();
    }
    /**
     * Metodo que faz a inserção de um novo livro
     * @author Brenno
     */
    public void insereLivro(){
        if(cabeca == null){
            cabeca = new Livro();

            String nomeLivro = Input.readString("Qual o nome do livro? ");
            cabeca.setNome(nomeLivro);

            String nomeAutor = Input.readString("Qual o nome do Autor? ");
            cabeca.setAutor(nomeAutor);

            cabeca.setProx(null);
            cabeca.setAnt(null);
            System.out.println("Livro inserido com sucesso! ");
        }else{
            Livro aux,novo;
			
            novo = new Livro();

            String nomeLivro = Input.readString("Qual o nome do livro? ");
            novo.setNome(nomeLivro);

            String nomeAutor = Input.readString("Qual o nome do Autor? ");
            novo.setAutor(nomeAutor);

            novo.setProx(null);
            novo.setAnt(cabeca);

            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
            novo.setAnt(aux);
            System.out.println("Livro inserido com sucesso! ");
	    }
		menus();
    }
    /**
     * Metodo para fazer a busca e impressão de um livro
     * @author Igor
     */
    public void buscaLivro(){
        String nomeLivro = Input.readString("Qual o nome do livro que deseja buscar? ");
        Livro aux = cabeca;

        while (aux != null && !aux.getNome().equals(nomeLivro)) {
            aux = aux.getProx();
        }

        if (aux != null) {
            aux.Imprime();
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
        menus();
    }

    /**
     * Metodo que atualiza as informações sobre um livro
     * @author iury
     */
    public void atualizaLivro(){
        String nomeLivro = Input.readString("Qual o nome do livro que deseja atualizar? ");
        Livro aux = cabeca;
        while (aux != null && !aux.getNome().equals(nomeLivro)) {
            aux = aux.getProx();
        }
        aux.Imprime();

        System.out.println("\n------------------------------------------\n");
        System.out.println("(1) Nome \n(2) Nome Autor \n(3) Emprestimo \n");
        System.out.println("\n------------------------------------------\n");
        int opcao = Input.readInt("O que deseja atualizar? ");
        
        switch (opcao) {
            case 1:
                String novoNome = Input.readString("Qual o novo nome do livro? ");
                aux.setNome(novoNome);
                break;
            case 2:
                String novoNomeAutor = Input.readString("Qual o novo nome do Autor? ");
                aux.setAutor(novoNomeAutor);
                break;
            case 3:
                if(aux.emprestimo){
                    aux.setEmprestimo(false);
                }else{
                    aux.setQuantEmprest(aux.getQuantEmprest() + 1);
                    aux.setEmprestimo(true);
                }
                break;
            default:
                break;
        }
        System.out.println("Livro altualizado com sucesso!");
        menus();
    }

    /**
     * Menu principal para fazer todas as alterações
     * @author Daniel
     */
    public void menus(){
        System.out.println("\n------------------------------------------\n");
        System.out.println("(1) Insere Livro \n(2) Atualizar Livro \n(3) Remove Livro \n(4) Buscar Livro \n(-1) Sair");
        System.out.println("\n------------------------------------------\n");

        int opção = Input.readInt("SELECIONE A OPÇÃO DESEJADA: ");

        switch (opção) {
            case 1:
                insereLivro();
                break;
            case 2:
                atualizaLivro();
                break;
            case 3:
                removeLivro();
                break;
            case 4:
                buscaLivro();
                break;
            case -1:
                break;
        }
    }
}
