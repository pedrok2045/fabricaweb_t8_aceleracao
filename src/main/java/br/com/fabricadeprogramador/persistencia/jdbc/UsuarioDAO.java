package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	
	public void cadastrar(Usuario u) {
		
		//configura o sql que será executado
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		
		//pega uma conexão com o BD
		try(Connection con = ConexaoFactory.getConnection()){
			
			//prepara o sql atraves de um statement
			try(PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setString(1, u.getNome());
				preparador.setString(2, u.getLogin());
				preparador.setString(3, u.getSenha());
				
				//executa o comando sql preparado pelo statement
				preparador.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario u) {
		
		//configura o sql que será executado
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		//pega uma conexão com o BD
		try(Connection con = ConexaoFactory.getConnection()){
			
			//prepara o sql atraves de um statement
			try(PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setString(1, u.getNome());
				preparador.setString(2, u.getLogin());
				preparador.setString(3, u.getSenha());
				preparador.setInt(4, u.getId());
				
				//executa o comando sql preparado pelo statement
				preparador.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Usuario u) {
		//configura o sql que será executado
		String sql = "delete from usuario where id=?";
		
		//pega uma conexão com o BD
		try(Connection con = ConexaoFactory.getConnection()){
			
			//prepara o sql atraves de um statement
			try(PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setInt(1, u.getId());
				
				//executa o comando sql preparado pelo statement
				preparador.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
