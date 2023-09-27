package com.example.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ApplicationListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("inicia la aplicación!");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "Hola a todos desde la application!");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("inicializando el request!");
        sre.getServletRequest().setAttribute("mensaje", "guardando algún valor para el request");
    }
}
 //   La diferencia fundamental entre req.getAttribute("mensaje") y getServletContext().getAttribute("mensaje")
//   radica en su alcance y duración de vida. El primero se refiere a un atributo específico almacenado en el ámbito de solicitud,
//   siendo visible solo durante la ejecución de una solicitud HTTP individual y útil para comunicar datos entre componentes
//   de esa solicitud. El segundo se refiere a un atributo almacenado en el ámbito de contexto del servlet, compartido por todas las
//   solicitudes y sesiones en la aplicación y utilizado para mantener información global o configuraciones de la aplicación.
//   Esta distinción en alcance y duración permite a los desarrolladores elegir la ubicación adecuada para almacenar y acceder a datos
//   según las necesidades de su aplicación web.


//En el proyecto universidad, se pueden aplicar los conceptos de almacenamiento de datos en Request y ServletContext
// de la siguiente manera: en el ámbito de solicitud (Request), se pueden almacenar temporalmente datos específicos de un estudiante,
// como detalles personales o errores de validación, para su uso durante la solicitud actual, como al mostrar información
// o mensajes de error. Por otro lado, el ámbito de contexto del servlet (ServletContext) es útil para almacenar datos globales
// de la aplicación, como configuraciones generales, content estático compartido o listas de materias, que deben estar disponibles
// en toda la aplicación y no cambian con frecuencia, asegurando una gestión eficiente de los recursos
// y la accesibilidad de información esencial en toda la aplicación universitaria.