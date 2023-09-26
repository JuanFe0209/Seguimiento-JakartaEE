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
 //   En resumen, la diferencia fundamental entre req.getAttribute("mensaje") y getServletContext().getAttribute("mensaje")
//   radica en su alcance y duración de vida. El primero se refiere a un atributo específico almacenado en el ámbito de solicitud,
//   siendo visible solo durante la ejecución de una solicitud HTTP individual y útil para comunicar datos entre componentes
//   de esa solicitud. El segundo se refiere a un atributo almacenado en el ámbito de contexto del servlet, compartido por todas las
//   solicitudes y sesiones en la aplicación y utilizado para mantener información global o configuraciones de la aplicación.
//   Esta distinción en alcance y duración permite a los desarrolladores elegir la ubicación adecuada para almacenar y acceder a datos
//   según las necesidades de su aplicación web.