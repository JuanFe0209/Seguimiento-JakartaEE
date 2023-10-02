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
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css
" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK
8M2HN" crossorigin="anonymous">
</head>
<body>
<h3><%= "Formulario estudiantes" %>
</h3>
  <%
if(errorsmap != null && errorsmap.size()>0){
%>
<ul class="alert alert-danger mx-5">
  <% for(String error: errorsmap.values()){%>
  <li><%=error%></li>
  <%}%>
</ul>
  <%}%>
<form action="student-form" method="post">
  <div class="row mb-3">
    <label for="name" class="col-form-label col-sm-2">Name</label>
    <div class="col-sm-4">
      <input type="text" name="name" id="name" class="form-control"
             value="${param.name}"></div>
    <%
      if(errorsmap != null && errorsmap.containsKey("name")){
        out.println("<div class='row mb-3 alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("name") + "</div>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label for="email" class="col-form-label col-sm-2">Email</label>
    <div class="col-sm-4"><input type="text" name="email" id="email"
                                 class="form-control"></div>
<%
    if(errorsmap != null && errorsmap.containsKey("email")){
      out.println("<div class='row mb-3 alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("email") + "</div>");
    }
%>
  </div>
  <div class="row mb-3">
    <label for="semester" class="col-form-label col-sm-2">Semester</label>
    <div class="col-sm-4"><input type="text" name="semester" id="semester"
                                 class="form-control"></div>
    <%
      if(errorsmap != null && errorsmap.containsKey("semester")){
        out.println("<div class='row mb-3 alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("semester") + "</div>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de
      programación</label>
    <div class="col-sm-4">
      <select name="lenguajes" id="lenguajes" multiple
              class="form-select">
        <option value="java"
        ${paramValues.lenguajes.stream().anyMatch(v->v.equals("java")).get()?"selected":""}>Java SE</option>
        <option value="jakartaee"
        ${paramValues.lenguajes.stream().anyMatch(v->v.equals("jakartaee")).get()?"selected":""}>Jakarta EE9</option>
        <option value="spring"
        ${paramValues.lenguajes.stream().anyMatch(v->v.equals("spring")).get()?"selected":""}>Spring Boot</option>
        <option value="js"
        ${paramValues.lenguajes.stream().anyMatch(v->v.equals("js")).get()?"selected"
                :""}>JavaScript</option>
        <option value="angular"
        ${paramValues.lenguajes.stream().anyMatch(v->v.equals("angular")).get()?"selected":""}>Angular</option>
        <option value="react"
        ${paramValues.lenguajes.stream().anyMatch(v->v.equals("react")).get()?"selected":""}>React</option>
      </select>
    </div>
    <%
      if(errorsmap != null && errorsmap.containsKey("lenguajes")){
        out.println("<small class='alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("lenguajes") + "</small>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label for="pais" class="col-form-label col-sm-2">País</label>
    <div class="col-sm-4">
    }
      <select name="pais" id="pais" class="form-select">
        <option value="">-- seleccionar --</option>
        <option value="ES" ${param.pais.equals("ES")? "selected":
                ""}>España</option>
        <option value="MX" ${param.pais.equals("MX")? "selected":
                ""}>México</option>
        <option value="CL" ${param.pais.equals("CL")? "selected":
                ""}>Chile</option>
        <option value="AR" ${param.pais.equals("AR")? "selected":
                ""}>Argentina</option>
        <option value="PE" ${param.pais.equals("PE")? "selected":
                ""}>Perú</option>
        <option value="CO" ${param.pais.equals("CO")? "selected":
                ""}>Colombia</option>
        <option value="VE" ${param.pais.equals("VE")? "selected":
                ""}>Venezuela</option>
      </select>
    </div>
    <%
      if(errorsmap != null && errorsmap.containsKey("pais")){
        out.println("<small class='alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("pais") + "</small>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Roles</label>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="roles" value="ROLE_ADMIN"
      ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_ADMIN")).get()?"checked":""}
             class="form-check-input">
      <label class="form-check-label">Administrador</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="roles" value="ROLE_USER"
             class="form-check-input"
      ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_USER")).get()?"checked":""}>
      <label class="form-check-label">Usuario</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="roles" value="ROLE_MODERATOR"
             class="form-check-input"
      ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_MODERATOR")).get()?"checked":""}>
      <label class="form-check-label">Moderador</label>
    </div>
<%
    if(errorsmap != null && errorsmap.containsKey("roles")){
      out.println("<small class='alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("roles") + "</small>");
    }
%>
  </div>
  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Idiomas</label>
    <div class="form-check col-sm-2">
      <input type="radio" name="idioma" value="es"
             class="form-check-input" ${param.idioma.equals("es")? "checked": ""}>
      <label class="form-check-label">Español</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="radio" name="idioma" value="en"
             class="form-check-input" ${param.idioma.equals("en")? "checked": ""}>
      <label class="form-check-label">Inglés</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="radio" name="idioma" value="fr"
             class="form-check-input" ${param.idioma.equals("fr")? "checked": ""}>
      <label class="form-check-label">Frances</label>
    </div>
    <%
      if(errorsmap != null && errorsmap.containsKey("idioma")){
        out.println("<small class='alert alert-danger col-sm-4'style='color: red;'>"+ errorsmap.get("idioma") + "</small>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label for="habilitar" class="col-form-label
col-sm-2">Habilitar</label>
    <div class="form-check">
      <input type="checkbox" name="habilitar" id="habilitar" checked
             class="form-check-input">
    </div>
  </div>
  <input type="hidden" name="secreto" value="12345">
  <div class="row mb-3">
    <div>
      <input type="submit" value="Enviar" class="btn btn-primary">
    </div>
  </div>
</form>
<br/>
<a href="student-form">Vamos a StudentController</a>
</body>
</html>
}