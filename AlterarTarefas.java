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




@WebServlet(name = "AlterarTarefas.do", urlPatterns = { "/AlterarTarefas.do" })
public class AlterarTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		  response.getWriter().append("Served at: ").append(request.getContextPath());
		  
		// recebendo os dados do usuário
			
			

		          int id = Integer.parseInt(request.getParameter("id_tarefas"));
			    String titulo = request.getParameter ("titulo_tarefas");
				String descricao = request.getParameter ("descricao_tarefas");
				String email = request.getParameter("email_tarefas");
				
				
				
				//Instanciar um objeto do tipo Usuario
				Tarefas tarefas = new Tarefas();
				tarefas.setId(id);
				tarefas.setTitulo (titulo);
				tarefas.setDescricao (descricao);
				tarefas.setFk_Usuario_Email(email);
			
				
				
				//Envia o objeto para a service
				
				TarefasService tarefasService = new TarefasService ();
				tarefasService.alterar(tarefas);
		  
		  
		   
				response.setContentType("text/html");
				
				PrintWriter saida = response.getWriter();
				
				saida.println ("<br> Alterado com sucesso!<br>");
				
				saida.println ( "<p>&#128512;</p>");
			   	
				saida.println ("<br><a href='login.jsp'>Sair</a>");
				
				saida.println (" <br>" + " " );	  
		
		
		
	}

}


		
		
		
		
		
		
		
		

		
