package service;

import java.util.ArrayList;

import dao.TarefasDAO;
import model.Tarefas;

public class TarefasService {
	
	private TarefasDAO tarefasDAO;

	            public TarefasService() {
	        	this.tarefasDAO = new TarefasDAO();
				
			}
			
			public void cadastrar (Tarefas tarefas) {
				this.tarefasDAO.cadastrar(tarefas);
			
			}
			
			public void excluir (Tarefas tarefas) {
				this.tarefasDAO.excluir(tarefas);
				
			}
			
			public ArrayList <Tarefas> listarTarefas(String email) {
			return this.tarefasDAO.listarTarefas(email);
			}
				
			public void alterar (Tarefas tarefas) {
			this.tarefasDAO.alterar (tarefas);
					
				}
				
			public Tarefas consultar(int id) {
			return this.tarefasDAO.consultar(id);
					
			}	

	}


