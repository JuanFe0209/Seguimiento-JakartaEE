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
  <title>Formulario Estudiantes</title>
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
        <div class="row mb-3">
          <label for="name" class="col-form-label col-sm-2">Name</label>
          <div class="col-sm-4"><input type="text" name="name" id="name" class="form-control"
                                       value="${param.name}"></div>
          <%
            if(errorsmap != null && errorsmap.containsKey("name")){
              out.println("<div class='row mb-3 alert alert-danger col-sm-4'" +
                      "style='color: red;'>"+ errorsmap.get("name") + "</div>");
            }
          %>
        </div>
        <div class="row mb-3">
          <label for="email" class="col-form-label col-sm-2">Email</label>
          <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control"></div>
          <%
            if(errorsmap != null && errorsmap.containsKey("email")){
              out.println("<div class='row mb-3 alert alert-danger col-sm-4' " +
                      "style='color: red;'>"+ errorsmap.get("email") + "</div>");
            }
          %>
        </div>
        <div class="row mb-3">
          <label for="career" class="col-form-label col-sm-2">Career</label>
          <div class="col-sm-4">
            <select name="career" id="career" class="form-select">
              <option value="">-- Seleccionar --</option>
              <option value="Ingenieria de software" ${param.pais.equals("Ingenieria de software")? "selected":
                      ""}>Ingenieria de software</option>
              <option value="Ingenieria Industrial" ${param.pais.equals("Ingenieria Industrial")? "selected":
                      ""}>Ingenieria Industrial</option>
              <option value="Enfermeria" ${param.pais.equals("Enfermeria")? "selected":
                      ""}>Enfermeria</option>
              <option value="Medicina" ${param.pais.equals("Medicina")? "selected":
                      ""}>Medicina</option>
              <option value="Veterinaria" ${param.pais.equals("Veterinaria")? "selected":
                      ""}>Veterinaria</option>
              <option value="Derecho" ${param.pais.equals("Derecho")? "selected":
                      ""}>Derecho</option>
              <option value="Psicologia" ${param.pais.equals("Psicologia")? "selected":
                      ""}>Psicologia</option>
              <option value="Ingenieria Civil" ${param.pais.equals("Ingenieria Civil")? "selected":
                      ""}>Ingenieria Civil</option>
              <option value="Marketing Digital" ${param.pais.equals("Marketing Digital")? "selected":
                      ""}>Marketing Digital</option>
            </select>
          </div>
          <%
            if(errorsmap != null && errorsmap.containsKey("career")){
              out.println("<small class='alert alert-danger col-sm-4'" +
                      "style='color: red;'>"+ errorsmap.get("career") + "</small>");
            }
          %>
        </div>
        <div class="row mb-3">
          <label for="semester" class="col-form-label col-sm-2">Semester</label>
          <div class="col-sm-4">
            <select name="semester" id="semester" class="form-select">
              <option value="">-- Seleccionar --</option>
            <option value="I" ${param.semester.equals("I")? "selected": ""}>I</option>
            <option value="II" ${param.semester.equals("II")? "selected": ""}>II</option>
            <option value="III" ${param.semester.equals("III")? "selected": ""}>III</option>
            <option value="IV" ${param.semester.equals("IV")? "selected": ""}>IV</option>
            <option value="V" ${param.semester.equals("V")? "selected": ""}>V</option>
            <option value="VI" ${param.semester.equals("VI")? "selected": ""}>VI</option>
            <option value="VII" ${param.semester.equals("VII")? "selected": ""}>VII</option>
            <option value="VIII" ${param.semester.equals("VIII")? "selected": ""}>VIII</option>
            <option value="IX" ${param.semester.equals("IX")? "selected": ""}>IX</option>
            <option value="X" ${param.semester.equals("X")? "selected": ""}>X</option>
            </select>
            <%
              if(errorsmap != null && errorsmap.containsKey("semester")){
                out.println("<small class='alert alert-danger col-sm-4'" +
                        "style='color: red;'>"+ errorsmap.get("semester") + "</small>");
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
              ${paramValues.lenguajes.stream().anyMatch(v->v.equals("js")).get()?"selected":""}>JavaScript</option>
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
