package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Tarefas;

public class TarefasDAO {
	
	private Connection conexao;

	public TarefasDAO() {
		

		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Tarefas tarefas) {
			
		String inserir = "INSERT INTO tarefas "
				+ " (id, titulo, descricao, email) "
				+ " VALUES (?, ?, ?,?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, tarefas.getId());
			pst.setString(2, tarefas.getTitulo());
			pst.setString(3, tarefas.getDescricao());
			pst.setString(4, tarefas.getFk_Usuario_Email());		
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
		}
	}
		
	
	
	public void excluir(Tarefas tarefas) {
		
		String excluir = "DELETE FROM tarefas "
				+ " WHERE id = ? ";
					
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, tarefas.getId());
		
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
		}
	}
	
	
	public ArrayList<Tarefas> listarTarefas(String email) {
		
		String consultar = "SELECT * FROM tarefas WHERE email = ? " ;
		                  
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			    pst.setString(1, email);
			
			
			System.out.println(pst);  
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Tarefas> lista = new ArrayList<>();
			
			while (resultado.next()) {
				Tarefas t = new Tarefas();
				t.setId(resultado.getInt("id"));
				t.setTitulo(resultado.getString("titulo"));
				t.setDescricao(resultado.getString("descricao"));
				t.setFk_Usuario_Email(resultado.getString("email"));
			
				lista.add(t);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tabelas.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
public Tarefas consultar(int id) {
		
		String consultar = "SELECT * FROM tarefas "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Tarefas t = new Tarefas();
			if (resultado.next()) {
				t.setId(id);
				t.setTitulo(resultado.getString("titulo"));
				t.setDescricao(resultado.getString("descricao"));
				t.setFk_Usuario_Email(resultado.getString("fk_usuario_email"));
				
			}
			return t;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}


public void alterar(Tarefas tarefas) {
	
	String inserir = "UPDATE tarefas "
			+ "SET id = ?, titulo = ?, descricao = ? "
			+ " WHERE email = ? ";
	
	try ( PreparedStatement pst = 
			conexao.prepareStatement(inserir) ) {
		
		pst.setInt(1, tarefas.getId());
		pst.setString(2, tarefas.getTitulo());
		pst.setString(3, tarefas.getDescricao());
		pst.setString(4, tarefas.getFk_Usuario_Email());
		
		pst.execute();
		
	} catch (SQLException ex) {
		
		System.err.println("Nao foi possivel manipular "
				+ "a tabela Tarefas.");
		ex.printStackTrace();
		
	}
}

	
		
	}


