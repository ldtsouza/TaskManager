<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.open-button {
  background-color: #555;
  color: white;
  padding: 10px 20px;
  border: none;
  bottom: 15px;
  right: 5px;
  width: 200px;
}

/* The popup form - hidden by default */
.form-popup {
  display: inline;
  position: static;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 4;
  
}



h1{
  background-color: #368;
  padding:10px;
  text-align: center;
  font-size: 35px;
  color:white;

}


fieldset{

  background-color:LightGray;
  padding:10px;
  text-align: center;
  font-size: 15px;
  color:#368;


}


div{

  background-color:lightblue;
  padding:10px;
  font-size: 12px;
  color:black;
}

input{
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

</style>

<head>
<meta charset="UTF-8">

<title>Login-TasksManager</title>
</head>
<body>


 <h1>Login - TasksManager 👨‍🏫 </h1>  

<%
   if (session.getAttribute("mensagem") != null) {
	   
	   out.println(session.getAttribute ("mensagem"));
	   session.removeAttribute("mensagem");
   }

%>

 <fieldset> 

<form  method="post"  action="Login.do"  >



      <br> &#128512; E-mail: <input type="email"  name="email_usuario">
   
       <br>  &#128567; Senha: <input type="password"  name="senha_usuario"> <br>
       
       <br> <button type="reset"  class="btn btn-secondary">Limpar</button> 
        <button type="submit" class="btn btn-secondary">Entrar</button> <br> 
       
 
 </form>     
             
      
 </fieldset>	 


       <p>  <br> <button class="open-button" onclick="openForm()">Cadastre-se</button> </p>    
 <div class="form-popup" id="myForm">
 
     <form action="CadastrarUsuario.do"   method="post"  >
     
    <h3>Insira seus dados</h3>


    
   Email: <input type="text" name="email_usuario"  /> <br> <br>
   Senha: <input type="password" name="senha_usuario" /> <br> <br>
   Nome:<input type="text" name="nome_usuario" /> <br>  <br>
   
  
    <button type="submit" class="btn btn-secondary"> Cadastrar </button> <br> <br>
    <button type="button" class="btn btn-secondary" onclick="closeForm()">Fechar</button>
    
   </form>   

</div>
       <script>
        function openForm() {
        document.getElementById("myForm").style.display = "block";
        }
        function closeForm() {
       document.getElementById("myForm").style.display = "none";
       }
       </script>
   </body>
</html>