package br.com.fabricadeprogramador.fabricaweb;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {
	public static void main(String[] args) {
		testaAutentica();
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
	
	public static void testeSalvar(){
		Usuario u = new Usuario();
		//u.setId(2);
		u.setNome("Virmerson");
		u.setLogin("virmerson");
		u.setSenha("virmerson");
		
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.salvar(u);
		
		System.out.println("Salvo com sucesso");
	}
	
	public static void testaBuscaPorId(){
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario u = uDAO.buscaPorId(1);
		
		System.out.println(u);
	}
	
	public static void testaBuscaTodos(){
		UsuarioDAO uDAO = new UsuarioDAO();
		List usuarios = uDAO.buscaTodos();
		
		usuarios.forEach(System.out::println);
	}
	
	public static void testaAutentica(){
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario user = new Usuario();
		user.setLogin("mariadesouza");
		user.setSenha("mariadesouza");
		
		Usuario saida = uDAO.autentica(user);
		
		System.out.println(saida);
	}
}
