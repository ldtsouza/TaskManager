package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;


@WebServlet(name = "Login.do", urlPatterns = { "/Login.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	
		String email = request.getParameter("email_usuario");
		String senha = request.getParameter("senha_usuario");
		
		UsuarioService us = new UsuarioService();
		Usuario u = us.consultar(email, senha);
		if (u!= null) {
			
			// O usuario foi encontrado!
			 
			        HttpSession sessao = request.getSession();
			        sessao.setAttribute("usuario", u);
					response.sendRedirect("tasks.jsp");
			
		}else {
			
			// O usuario não foi encontrado no banco:
		    				
			            HttpSession sessao = request.getSession();
			            
						sessao.setAttribute ("mensagem","Usuário e/ou senha inválidos!");      
				        	 
						response.sendRedirect("login.jsp");
			
        
	}
}
	
}


	