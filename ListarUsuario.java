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


@WebServlet(name = "ListarUsuario.do", urlPatterns = { "/ListarUsuario.do" })
public class ListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 UsuarioService usuarioService = new UsuarioService();
		  
		    ArrayList<Usuario> listarUsuario= null;
			 
			listarUsuario = usuarioService.listarUsuario();
				
			response.setContentType ("text/html"); 
			
			PrintWriter saida = response.getWriter();
			
	        saida.println ("<br>  <h3> Lista de Usuários </h3> ");
			
		   		 
			saida.println ("<html>");
			saida.println ("<body>");
			saida.println ("<table>");
			
			saida.println ("<tr>");
			
			saida.println ("<th>Email</th>");
			saida.println ("<th>Senha</th>");
			saida.println ("<th>Nome</th>");
		
		
			saida.println ("</tr>");
		
						 listarUsuario.forEach (
						    	u ->{
						    		
						    		
						    		saida.println ("<tr>");
						    		
						    		saida.println ("<td>" );
						    		saida.println(u.getEmail());
						    		saida.println ("</td>");
						    		
						    	
						    		
						    		saida.println ("<td>");
						    		saida.println(u.getSenha());
						    		saida.println ("</td>");
						    		
						    	    saida.println (" <br>" + " " );	  
						    		
						    		saida.println ("<td>");
						    		saida.println(u.getNome());
						    		saida.println ("</td>");
						    		
						    		saida.println ("</tr>");							    						    	
						    	
						}
							    
			);
						            saida.println ("</table>");
									saida.println ("</body>");
									
									 saida.println ("</html>");
					
	}

	
		
	}


