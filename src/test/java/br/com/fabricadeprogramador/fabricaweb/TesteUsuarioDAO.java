package br.com.fabricadeprogramador.fabricaweb;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {
	public static void main(String[] args) {
		testeExcluir();
	}

	public static void testeCadastrar() {
		// Criando o usuario
		Usuario u = new Usuario();
		u.setNome("Jaãozão");
		u.setLogin("jaozao");
		u.setSenha("jaozao");

		// Cadastrando usuario no banco de dados
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.cadastrar(u);

		System.out.println("Cadastrado com sucesso");
	}
	
	public static void testeAlterar() {
		// Criando o usuario
		Usuario u = new Usuario();
		u.setId(4);
		u.setNome("Jaãozão da Silva");
		u.setLogin("jaozaodasilva");
		u.setSenha("jaozaodasilva");

		// Cadastrando usuario no banco de dados
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.alterar(u);

		System.out.println("Alterado com sucesso");
	}
	
	public static void testeExcluir() {
		// Criando o usuario
		Usuario u = new Usuario();
		u.setId(4);

		// Cadastrando usuario no banco de dados
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.excluir(u);

		System.out.println("Excluido com sucesso");
	}
}
