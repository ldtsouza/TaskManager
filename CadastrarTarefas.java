package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarefas;
import service.TarefasService;



@WebServlet(name = "CadastrarTarefas.do", urlPatterns = { "/CadastrarTarefas.do" })
public class CadastrarTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		// recebendo os dados das tarefas
		
	     
			String titulo = request.getParameter("titulo_tarefas");
			String descricao = request.getParameter ("descricao_tarefas");
			String fk_usuario_email = request.getParameter ("fk_usuario_email_tarefas");
			
			
			//Instanciar um objeto do tipo tarefas
			Tarefas tarefas = new Tarefas();
			tarefas.setTitulo (titulo);
			tarefas.setDescricao (descricao);
			tarefas.setFk_Usuario_Email (fk_usuario_email);
		
			
			
			//Envia o objeto para a service
			
			TarefasService tarefasService = new TarefasService ();
			
			tarefasService.cadastrar(tarefas);
		
			

			response.setContentType("text/html");
			
			PrintWriter saida = response.getWriter();
			
			saida.println ("<br> Cadastro de Tarefas realizado com sucesso!<br>");
			
			saida.println ( "<p>&#128512;</p>");
		   	
			saida.println ("<br><a href='login.jsp'>Sair</a>");
			
			saida.println (" <br>" + " " );	  
			
		
	}

}
