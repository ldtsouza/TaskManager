package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Usuario;
import service.UsuarioService;


@WebServlet(name = "ExcluirUsuario.do", urlPatterns = { "/ExcluirUsuario.do" })
public class ExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  response.getWriter().append("Served at: ").append(request.getContextPath());
		   
		   response.setContentType ("text/html"); 
		   
		    UsuarioService usuarioService = new UsuarioService();
						  
		    ArrayList<Usuario> listarUsuario = null;
		    
			String email = request.getParameter ("email");

	        Usuario usuario = new Usuario ();
			
			usuario.setEmail (email);
								
			usuarioService.excluir(usuario);
		    
			listarUsuario = usuarioService.listarUsuario();
		
			PrintWriter saida = response.getWriter();
			
			  saida.println ("<br>  <h3> Excluir Usuário  </h3> ");
		        
				 
				saida.println ("<html>");
				saida.println ("<body>");
				saida.println ("<table>");
				
								
				saida.println ("<tr>");
				
				saida.println ("<th>Email</th>");
				saida.println ("<th>Senha em Oculto</th>");
				saida.println ("<th>Nome</th>");
				saida.println ("<th>Excluir</th>");
			
			
				saida.println ("</tr>");
				
				 listarUsuario.forEach (
					    	u ->{
					    		
					    		
					    		saida.println ("<tr>");
					    		
					    		
					    		saida.println ("<td>" );
					    		
					    		saida.println(("<input type='texto' name='id_usuario'  value ='"
										+ u.getEmail() + "'> <br>"));
					    		
					    		saida.println ("</td>");
					    		
					    		saida.println ("<h2>"); 
					    		
					    		saida.println ("<td>");
					    		saida.println(("<input type=\"hidden\" name='id_usuario'  value ='"
										+ u.getSenha() + "'> <br>"));
					    		saida.println ("</td>");
					    		
					    		saida.println ("</h2>"); 
					    		
					    		
					    		
					    		saida.println ("<td>");
					    		saida.println(u.getNome());
					    		saida.println ("</td>");
					    		
					    
					    	
					    		saida.println ("<td>");
					    		saida.println("<a href= 'ExcluirUsuario.do? email="
					    				       + u.getEmail() + " ' > Excluir </a>");
					    		
					    		saida.println ("</td>");
					    		
					    		
					   
					    		saida.println ("</tr>");
					    		
					    	}
					    
					    );
					    
					    
					    saida.println ("</table>");
					   
						saida.println ("</body>");
						
						 saida.println ("</html>");
						 
							
								
		
	}
	


		
	}


