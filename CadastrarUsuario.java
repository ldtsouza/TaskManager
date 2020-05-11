package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;


@WebServlet(name = "CadastrarUsuario.do", urlPatterns = { "/CadastrarUsuario.do" })
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
			usuarioService.cadastrar(usuario);
		

			response.setContentType("text/html");
			
			PrintWriter saida = response.getWriter();
			
			saida.println ("<br> Cadastro realizado com sucesso!<br>");
			
			saida.println ( "<p>&#128512;</p>");
		   	
			saida.println ("<br><a href='login.jsp'>Sair</a>");
			
			saida.println (" <br>" + " " );	  
			
			
			
			
	}

}


