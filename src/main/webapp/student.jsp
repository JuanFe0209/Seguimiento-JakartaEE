<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.Map"%>
<%@ page import="java.util.List" %>
<%
  List<String> errores = (List<String>)request.getAttribute("errores");
%>
<%
  Map<String,String> errorsmap =
          (Map<String,String>)request.getAttribute("errorsmap");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Student CRUD</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <h3><%= "Formulario estudiantes" %></h3>
      <form action="student-form" method="post" class="mx-auto">
        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input type="text" name="name" id="name" class="form-control"
                 value="${param.name}">
          <% if(errorsmap != null && errorsmap.containsKey("name")){ %>
          <div class="alert alert-danger mt-2" style="color: red;">
            ${errorsmap.get("name")}
          </div>
          <% } %>
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input type="text" name="email" id="email" class="form-control">
          <% if(errorsmap != null && errorsmap.containsKey("email")){ %>
          <div class="alert alert-danger mt-2" style="color: red;">
            ${errorsmap.get("email")}
          </div>
          <% } %>
        </div>
        <div class="mb-3">
          <label for="career" class="form-label">Career</label>
          <select name="career" id="career" class="form-select">
            <option value="">-- Seleccionar --</option>
            <option value="Ingenieria de software" ${param.career.equals("Ingenieria de software")? "selected": ""}>Ingenieria de software</option>
            <option value="Ingenieria Industrial" ${param.career.equals("Ingenieria Industrial")? "selected": ""}>Ingenieria Industrial</option>
            <option value="Enfermeria" ${param.career.equals("Enfermeria")? "selected": ""}>Enfermeria</option>
            <option value="Medicina" ${param.career.equals("Medicina")? "selected": ""}>Medicina</option>
            <option value="Veterinaria" ${param.career.equals("Veterinaria")? "selected": ""}>Veterinaria</option>
            <option value="Derecho" ${param.career.equals("Derecho")? "selected": ""}>Derecho</option>
            <option value="Psicologia" ${param.career.equals("Psicologia")? "selected": ""}>Psicologia</option>
            <option value="Ingenieria Civil" ${param.career.equals("Ingenieria Civil")? "selected": ""}>Ingenieria Civil</option>
            <option value="Marketing Digital" ${param.career.equals("Marketing Digital")? "selected": ""}>Marketing Digital</option>
          </select>
          <% if(errorsmap != null && errorsmap.containsKey("career")){ %>
          <div class="alert alert-danger mt-2" style="color: red;">
            ${errorsmap.get("career")}
          </div>
          <% } %>
        </div>
        <div class="mb-3">
          <label for="semester" class="form-label">Semester</label>
          <select name="semester" id="semester" class="form-select">
            <option value="">-- Seleccionar --</option>
            <option value="1" ${param.semester.equals("1")? "selected": ""}>1</option>
            <option value="2" ${param.semester.equals("2")? "selected": ""}>2</option>
            <option value="3" ${param.semester.equals("3")? "selected": ""}>3</option>
            <option value="4" ${param.semester.equals("4")? "selected": ""}>4</option>
            <option value="5" ${param.semester.equals("5")? "selected": ""}>5</option>
            <option value="6" ${param.semester.equals("6")? "selected": ""}>6</option>
            <option value="7" ${param.semester.equals("7")? "selected": ""}>7</option>
            <option value="8" ${param.semester.equals("8")? "selected": ""}>8</option>
            <option value="9" ${param.semester.equals("9")? "selected": ""}>9</option>
            <option value="10" ${param.semester.equals("10")? "selected": ""}>10</option>
          </select>
          <% if(errorsmap != null && errorsmap.containsKey("semester")){ %>
          <div class="alert alert-danger mt-2" style="color: red;">
            ${errorsmap.get("semester")}
          </div>
          <% } %>
        </div>
        <div class="mb-3">
          <input type="submit" value="Enviar" class="btn btn-primary">
        </div>
      </form>
    </div>
  </div>
  <a href="student-form">Vamos a listar estudiantes</a>
</div>
</body>
</html>
