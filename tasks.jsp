<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="java.util.Date" %>    
<%@ page import="java.util.ArrayList,
                model.Usuario,
                service.UsuarioService" %>
                
 <%@ page import="model.Tarefas,
                  service.TarefasService" %>               
                
                
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Tasks</title>
</head>
<body>

<%

Usuario usuario;
usuario = (Usuario)session.getAttribute("usuario");

ArrayList<Tarefas> lista = new ArrayList<>();
TarefasService tarefasService = new TarefasService();
 
lista = tarefasService.listarTarefas(usuario.getEmail());


%>


 <header> 👨‍🏫  Tasks Manager </header>
  
  <h2> <%= new Date () %> <br>
  
  Olá, 👤   <%=usuario.getNome()%>
 
  <br> <a href="Login.do">Sair</a> 🏃
  </h2> 

   <h4> Lista de Tarefas 📝  </h4>
   
 <table> 
 <tr> 
    <th> Id</th>
    <th> Titulo</th>
    <th> Descricao</th>
      <th> 🗑️ </th> 
  </tr>

 <% 
 for(Tarefas t :lista){
	
	 %>
	  <tr>
	  <td><%= t.getId()%> </td>
	  
	  <td><%= t.getTitulo()%>  </td>
	  
	  <td><%= t.getDescricao()%>  </td>
	  
	  <form method="get"  action="ExcluirTarefas.do"> 
	   <td> <a href="ExcluirTarefas.do?id=<%=t.getId() %>"> <button type="button" class="delete">Excluir </button> </a> </td>
	 </form>
	  </tr>  
	  
     <%
 }  
 
 %>
  </table>


 
 <div class="card-body">


<h3> Alterar Tarefa ✏️ </h3>

 <form  method="post"  action="AlterarTarefas.do">  
  <table> 
 <tr> 
    <th> Id</th>
    <th> Titulo</th>
    <th> Descricao</th>
    <th>Email </th>
    <th> ✏️ </th>
 
  </tr>

 <% 
 for(Tarefas t :lista){
	
	 %>
	  <tr>
	  
	  <td><%= t.getId()%> </td>
	  
	  <td> <input type="text" name="titulo_tarefas" /> <br></td>
	  
	  <td> <input type="text" name="descricao_tarefas" /> <br></td>
	  
	  <td><%=usuario.getEmail()%><td>
	  
	  <a href="AlterarTarefas.do?id=<%=t.getId() %>" >Alterar </a>
	    
	  </tr>  
	  
     <%
 }   
 
 %>
  </table>
  
   <input type="reset"  value="Limpar">
    
    
   </form>

	  
<p> <br> <button class="open-button" onclick="openForm()"> Add Tasks 📋 </button> </p>
 
 <fieldset>
 <div class="form-popup" id="myForm">
<h3> Cadastrar Tarefas 📋 </h3> 

 <form method="post"  action="CadastrarTarefas.do">
    <br> <button type="button" class="btn btn-secondary" onclick="closeForm()">Fechar</button> 
     <br> 
    
      <br>
      Titulo: <input type="text" name="titulo_tarefas" /> <br>
      <br>
      Descricao: <input type="text" name="descricao_tarefas" /> <br>
      <br>
      Email:<input type="text" name="fk_usuario_email_tarefas" /> <br>
      <br>
        
      <br>
    <input type="submit"  value="Cadastrar"> 
     <input type="reset"  value="Limpar">  <br>
     
  </form>
     
        <script>
         function openForm() {
        document.getElementById("myForm").style.display = "block";
        }
        
       function closeForm() {
       document.getElementById("myForm").style.display = "none";
       }
       </script>
 </div>
 
 </fieldset>
  
  <br>



<footer>
  <p>Universidade São Judas Tadeu - Desenvolvimento Web - Prof. Igor Moreira - 2020</p>
   <p>Aluna: Laudilene Dantas da Trindade de Souza - RA 819157991</p>
</footer>


</body>


<style>

h4 {
  font-size:20px;
  text-align:left;
  color: blue;
  padding:5px;
   
}


table{
  padding-top: 5px;
  padding-bottom: 5px;
  text-align:center;
  color: #f2f3f2;
  width: 70%;
 
}

tr{
  background-color: #ffa79e;
  color:black;
}

th{
  background-color:lightblue;
  color:black;
}



h2 {
  background-color: #361;
  padding:10px;
  text-align: right;
  font-size: 15px;
  color: white;
}

a{

 font-size: 14px;
  color:white;

}


header {
  background-color: LightGray;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: black;
}


fildset{

  background-color:#f1f1f1;
  float: right;
  color: white;
  padding: 10px 20px;
  border: none;
  bottom: 15px;
  right: 5px;
  width: 70%;
  height: 100px;
}

section:after {
  content: "";
  display: table;
  clear: both;
}

footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

.form-popup {
  display: inline;
  text-align: right;
  position: static;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 4;
  
}

.open-button {
  background-color: #555;
  float: right;
  background-color: green;
  color: white;
  padding: 10px 20px;
  border: none;
  bottom: 15px;
  right: 5px;
  width: 200px;
}


</style>

</html>