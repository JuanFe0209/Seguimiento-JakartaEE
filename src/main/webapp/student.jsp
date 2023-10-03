<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <title>JSP - Hello World</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <h3>Formulario estudiantes</h3>
    <%
    if (errores != null && !errores.isEmpty()) {
  %>
  <ul class="alert alert-danger mx-5">
    <% for (String error : errores) { %>
    <li><%= error %></li>
    <% } %>
  </ul>
    <% } %>
  <form action="student-form" method="post">
    <div class="row mb-3">
      <label for="name" class="col-form-label col-sm-2">Name</label>
      <div class="col-sm-4">
        <input type="text" name="name" id="name" class="form-control" value="${param.name}">
        <%
          if (errorsmap != null && errorsmap.containsKey("name")) {
            out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("name") + "</div>");
          }
        %>
      </div>
    </div>
    <div class="row mb-3">
      <label for="email" class="col-form-label col-sm-2">Email</label>
      <div class="col-sm-4">
        <input type="text" name="email" id="email" class="form-control">
        <%
          if (errorsmap != null && errorsmap.containsKey("email")) {
            out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("email") + "</div>");
          }
        %>
      </div>
    </div>
    <div class="row mb-3">
      <label for="semester" class="col-form-label col-sm-2">Semester</label>
      <div class="col-sm-4">
        <input type="text" name="semester" id="semester" class="form-control">
        <%
          if (errorsmap != null && errorsmap.containsKey("semester")) {
            out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("semester") + "</div>");
          }
        %>
      </div>
    </div>
    <div class="row mb-3">
      <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
      <div class="col-sm-4">
        <select name="lenguajes" id="lenguajes" multiple class="form-select">
          <option value="java" ${paramValues.lenguajes != null && paramValues.lenguajes.contains("java") ? "selected" : ""}>Java SE</option>
          <option value="jakartaee" ${paramValues.lenguajes != null && paramValues.lenguajes.contains("jakartaee") ? "selected" : ""}>Jakarta EE9</option>
          <option value="spring" ${paramValues.lenguajes != null && paramValues.lenguajes.contains("spring") ? "selected" : ""}>Spring Boot</option>
          <option value="js" ${paramValues.lenguajes != null && paramValues.lenguajes.contains("js") ? "selected" : ""}>JavaScript</option>
          <option value="angular" ${paramValues.lenguajes != null && paramValues.lenguajes.contains("angular") ? "selected" : ""}>Angular</option>
          <option value="react" ${paramValues.lenguajes != null && paramValues.lenguajes.contains("react") ? "selected" : ""}>React</option>
        </select>
        <%
          if (errorsmap != null && errorsmap.containsKey("lenguajes")) {
            out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("lenguajes") + "</div>");
          }
        %>
      </div>
    </div>
    <div class="row mb-3">
      <label for="pais" class="col-form-label col-sm-2">País</label>
      <div class="col-sm-4">
        <select name="pais" id="pais" class="form-select">
          <option value="">-- seleccionar --</option>
          <option value="ES" ${"ES".equals(param.pais) ? "selected" : ""}>España</option>
          <option value="MX" ${"MX".equals(param.pais) ? "selected" : ""}>México</option>
          <option value="CL" ${"CL".equals(param.pais) ? "selected" : ""}>Chile</option>
          <option value="AR" ${"AR".equals(param.pais) ? "selected" : ""}>Argentina</option>
          <option value="PE" ${"PE".equals(param.pais) ? "selected" : ""}>Perú</option>
          <option value="CO" ${"CO".equals(param.pais) ? "selected" : ""}>Colombia</option>
          <option value="VE" ${"VE".equals(param.pais) ? "selected" : ""}>Venezuela</option>
        </select>
        <%
          if (errorsmap != null && errorsmap.containsKey("pais")) {
            out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("pais") + "</div>");
          }
        %>
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-form-label col-sm-2">Roles</label>
      <div class="form-check col-sm-2">
        <input type="checkbox" name="roles" value="ROLE_ADMIN" ${paramValues.roles != null && paramValues.roles.contains("ROLE_ADMIN") ? "checked" : ""} class="form-check-input">
        <label class="form-check-label">Administrador</label>
      </div>
      <div class="form-check col-sm-2">
        <input type="checkbox" name="roles" value="ROLE_USER" ${paramValues.roles != null && paramValues.roles.contains("ROLE_USER") ? "checked" : ""} class="form-check-input"
        <label class="form-check-label">Usuario</label>
      </div>
      <div class="form-check col-sm-2">
        <input type="checkbox" name="roles" value="ROLE_MODERATOR" ${paramValues.roles != null && paramValues.roles.contains("ROLE_MODERATOR") ? "checked" : ""} class="form-check-input">
        <label class="form-check-label">Moderador</label>
      </div>
      <%
        if (errorsmap != null && errorsmap.containsKey("roles")) {
          out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("roles") + "</div>");
        }
      %>
    </div>
    <div class="row mb-3">
      <label class="col-form-label col-sm-2">Idiomas</label>
      <div class="form-check col-sm-2">
        <input type="radio" name="idioma" value="es" class="form-check-input" ${"es".equals(param.idioma) ? "checked" : ""}>
        <label class="form-check-label">Español</label>
      </div>
      <div class="form-check col-sm-2">
        <input type="radio" name="idioma" value="en" class="form-check-input" ${"en".equals(param.idioma) ? "checked" : ""}>
        <label class="form-check-label">Inglés</label>
      </div>
      <div class="form-check col-sm-2">
        <input type="radio" name="idioma" value="fr" class="form-check-input" ${"fr".equals(param.idioma) ? "checked" : ""}>
        <label class="form-check-label">Francés</label>
      </div>
      <%
        if (errorsmap != null && errorsmap.containsKey("idioma")) {
          out.println("<div class='alert alert-danger mt-2'>" + errorsmap.get("idioma") + "</div>");
        }
      %>
    </div>
    <div class="row mb-3">
      <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
      <div class="form-check">
        <input type="checkbox" name="habilitar" id="habilitar" checked class="form-check-input">
      </div>
    </div>
    <input type="hidden" name="secreto" value="12345">
    <div class="row mb-3">
      <div class="col-sm-2"></div>
      <div class="col-sm-4">
        <input type="submit" value="Enviar" class="btn btn-primary">
      </div>
    </div>
  </form>
  <br/>
  <a href="student-form">Vamos a StudentController</a>
</div>
</body>
</html>
