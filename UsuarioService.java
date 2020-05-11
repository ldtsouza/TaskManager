package service;

import java.util.ArrayList;
import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	    public UsuarioService() {
    	this.usuarioDAO = new UsuarioDAO();
		
	}
	
	public void cadastrar (Usuario usuario) {
		this.usuarioDAO.cadastrar(usuario);
	
	}
	
	public void excluir (Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
		
	}
	
	public ArrayList<Usuario> listarUsuario(){
	return this.usuarioDAO.listarUsuario();
	}
		
	public void alterar (Usuario usuario) {
	this.usuarioDAO.alterar (usuario);

				
			
		}
		
	public Usuario consultar(String email, String senha) {
	return this.usuarioDAO.consultar(email, senha);
			
	
		
}



}
