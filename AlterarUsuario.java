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


@WebServlet(name = "AlterarUsuario.do", urlPatterns = { "/AlterarUsuario.do" })
public class AlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		  response.getWriter().append("Served at: ").append(request.getContextPath());
		  
		// recebendo os dados do usuário
			
			
				String email = request.getParameter("email_usuario");
				String senha = request.getParameter ("senha_usuario");
				String nome = request.getParameter ("nome_usuario");
				
				
				//Instanciar um objeto do tipo Usuario
				Usuario usuario = new Usuario();
				usuario.setEmail (email);
				usuario.setSenha (senha);
				usuario.setNome (nome);
			
				
				
				//Envia o objeto para a service
				
				UsuarioService usuarioService = new UsuarioService ();
				usuarioService.alterar(usuario);
		  
		  
		   
		   response.setContentType ("text/html"); 
		   
		
						  
		    ArrayList<Usuario> listarUsuario = null;
		    
			usuario.setEmail (email);
		  
			listarUsuario = usuarioService.listarUsuario();
		
			PrintWriter saida = response.getWriter();
			
			  saida.println ("<br>  <h3>Alterar Usuário  </h3> ");
		        
				 
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
					    		
					    		saida.println(("<input type='texto' name='email_usuario'  value ='"
										+ u.getEmail() + "'> <br>"));
					    		
					    		saida.println ("</td>");
					    		
					    		saida.println ("<h2>"); 
					    		
					    		saida.println ("<td>");
					    		saida.println(("<input type='texto' name='senha_usuario'  value ='"
										+ u.getSenha() + "'> <br>"));
					    		saida.println ("</td>");
					    		
					    		saida.println ("</h2>"); 
					    		
					    		
					    		
					    		saida.println ("<td>");
					    		saida.println(("<input type='texto' name='nome_usuario'  value ='"
										+ u.getNome() + "'> <br>"));
					    		saida.println ("</td>");
					    		
					    		
					    		
					    
					    	
					    		saida.println ("<td>");
					    		

								saida.println ("<input type='submit' value='Alterar'>");
													    		
					    		saida.println ("</td>");
					    		
					    		
					   
					    		saida.println ("</tr>");
					    		
					    	}
					    
					    );
					    
					    
					    saida.println ("</table>");
					   
						saida.println ("</body>");
						
						 saida.println ("</html>");
						 
							
						 response.setContentType("text/html");
							
							
							
							saida.println ( "<p>&#128512;</p>");
						   	
							saida.println ("<br><a href='login.jsp'>Sair</a>");
							
							saida.println (" <br>" + " " );	  		

		
		
		
	}

}
