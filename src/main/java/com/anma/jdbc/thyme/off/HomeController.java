package com.anma.jdbc.thyme.off;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeController implements IGTVGController {

    public void process(final HttpServletRequest request,
                        final HttpServletResponse response,
                        final ServletContext servletContext,
                        final ITemplateEngine templateEngine)
            throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();

        WebContext ctx =
                new WebContext(request, response, servletContext, request.getLocale());

        ctx.setVariable("today", dateFormat.format(cal.getTime()));

        templateEngine.process("home", ctx, response.getWriter());

    }


}
