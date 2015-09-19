package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
		} catch (SQLException | ClassNotFoundException e) {
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
			
		} catch (SQLException | ClassNotFoundException e) {
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
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void salvar(Usuario u){
		if(u.getId() != null){
			this.alterar(u);
		}else{
			this.cadastrar(u);
		}
	}
	
	/**
	 * Busca um registro no BD pela id do usuario.
	 * @param id É um inteiro que representa o número do id do usuário a ser buscado
	 * @return Um objeto usuário quando encontra dados ou null quando não encontra.
	 */
	public Usuario buscaPorId(Integer id){
		
		String sql = "select * from usuario where id=?";
		
		//pega uma conexão com o BD
		try(Connection con = ConexaoFactory.getConnection()){
			
			//prepara o sql atraves de um statement
			try(PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setInt(1, id);
				
				//executa o comando sql preparado pelo statement e guarda seu valor em um Resultset				
				try(ResultSet result = preparador.executeQuery()){
					while(result.next()){
						Usuario u = new Usuario();
						u.setId(result.getInt("id"));
						u.setNome(result.getString("nome"));
						u.setLogin(result.getString("login"));
						u.setSenha(result.getString("senha"));
						
						return u;
					}
				}
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	public List<Usuario> buscaTodos(){
		
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from usuario";
		
		//pega uma conexão com o BD
		try(Connection con = ConexaoFactory.getConnection()){
			
			//prepara o sql atraves de um statement
			try(PreparedStatement preparador = con.prepareStatement(sql)){
				
				//executa o comando sql preparado pelo statement e guarda seu valor em um Resultset				
				try(ResultSet result = preparador.executeQuery()){
					while(result.next()){
						Usuario u = new Usuario();
						u.setId(result.getInt("id"));
						u.setNome(result.getString("nome"));
						u.setLogin(result.getString("login"));
						u.setSenha(result.getString("senha"));
						
						usuarios.add(u);
					}
				}
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return usuarios;
		
	}
	
	public Usuario autentica(Usuario u){
		
		//configura o sql que será executado
		String sql = "select * from usuario where login=? and senha=?";
		
		//pega uma conexão com o BD
		try(Connection con = ConexaoFactory.getConnection()){
			
			//prepara o sql atraves de um statement
			try(PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setString(1, u.getLogin());
				preparador.setString(2, u.getSenha());
				
				//executa o comando sql preparado pelo statement
				try(ResultSet result = preparador.executeQuery()){
					if(result.next()){
						Usuario usuario = new Usuario();
						usuario.setId(result.getInt("id"));
						usuario.setNome(result.getString("nome"));
						usuario.setLogin(result.getString("login"));
						usuario.setSenha(result.getString("senha"));
						
						return usuario;
					}
				}
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
