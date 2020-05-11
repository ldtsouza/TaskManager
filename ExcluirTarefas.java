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


@WebServlet(name = "ExcluirTarefas.do", urlPatterns = { "/ExcluirTarefas.do" })
public class ExcluirTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.getWriter().append("Served at: ").append(request.getContextPath());
		 
			response.setContentType("text/html");
			


	
		
	    TarefasService tarefasService = new TarefasService ();
	  	
	    int id = Integer.parseInt(request.getParameter("id_tarefas"));
	    
	
		Tarefas tarefas = new Tarefas();
		
		tarefas.setId (id);
	
		tarefasService.excluir(tarefas);
		
	 
		  
	  		
		//Envia o objeto para a service
		
	
  
		PrintWriter saida = response.getWriter();
		
			
			
			saida.println ("<br> Tarefa Excluída com sucesso!<br>");
			
			saida.println ( "<p>&#128512;</p>");
		   	
			saida.println ("<br><a href='login.jsp'>Sair</a>");
			
			saida.println (" <br>" + " " );	  
			
			
			
			}

}
