package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usuario.control")
public class UsuarioController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		String nome = req.getParameter("nome");
		usuario.setNome(nome);
		String login = req.getParameter("login");
		usuario.setLogin(login);
		String senha = req.getParameter("senha");
		usuario.setSenha(senha);
		
		uDAO.salvar(usuario);
		System.out.println("Dados salvos!");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		String nome = req.getParameter("nome");
		usuario.setNome(nome);
		String login = req.getParameter("login");
		usuario.setLogin(login);
		String senha = req.getParameter("senha");
		usuario.setSenha(senha);
		
		uDAO.salvar(usuario);
		
		resp.getWriter().print("<h2><b>sucesso!</b></h2>");
		
		//System.out.println("Dados salvos! Post");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
}
