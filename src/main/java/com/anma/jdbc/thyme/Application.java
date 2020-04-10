package com.anma.jdbc.thyme;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Application {

    public static void process(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response,
                               String template, Map<String, Object> variablesMap) throws IOException {

        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale());

        ctx.setVariables(variablesMap);

        new TemplateUtils(servletContext).getTemplateEngine().process(template, ctx, response.getWriter());

    }

}
