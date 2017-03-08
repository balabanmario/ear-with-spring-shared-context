/**
 * Created by Mario Balaban on 25/02/14.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import springshare.SampleService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/first", displayName = "FirstServlet", 
description = "Calls the generic SampleService from its parent ApplicationContext")
public class FirstServlet extends HttpServlet implements Servlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // For this sample, we simply perform depency lookup from the current WebApplicationContext.
        // This will query the shared parent context and find the sampleService bean.
        // In a real web app, Spring provide a better way to do dependency injection
        // of your web controllers/actions/whatever your web framework calls them.
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        SampleService service = ctx.getBean(SampleService.class);

        response.getWriter().println(service.sayHello("SampleWeb1"));
    }

}