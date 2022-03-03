 <%@page import="java.util.*"%>
    <%@page import="registration.entities.hosp_regis"%>
    <%@page import="javax.swing.text.html.HTMLDocument.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>view data</title>
  </head>
  <body>
  <h2><i>${msg}</i></h2><br>
<br>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  
  <%List<hosp_regis> ld=(List<hosp_regis>)request.getAttribute("ldata"); %>
  <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Email</th>
      <th scope="col">Name</th>
      <th scope="col">Age</th>
      <th scope="col">Disease Type</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  
  
  <tbody>
  
  <% for(hosp_regis s:ld){%>
    <tr>
      <td> <%=s.getEmail() %> </td>
	<td> <%=s.getName() %> </td>
	<td> <%=s.getAge() %> </td>
	<td> <%=s.getDistyp() %> </td>
	<td><form action="edit" method="post">
	<input type="hidden"  id="edem" name="edem" value="<%=s.getEmail() %>" >
<button type="submit" class="btn btn-success">Edit</button>
</form></td>
<td><form action="delete" method="post">
	<input type="hidden"  id="delem" name="delem" value="<%=s.getEmail() %>" >
<button type="submit" class="btn btn-danger">Delete</button>
</form></td>
    </tr>
   <% } %>
   
  </tbody>
</table>
  
  <br>
  
 <form action="regist" method="get">
<button type="submit" class="btn btn-secondary">--Registration Page</button>
</form>
  
  </body>
</html>