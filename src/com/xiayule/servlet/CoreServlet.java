package com.xiayule.servlet;

import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tan on 14-6-19.
 */
@WebServlet(urlPatterns = "/CoreServlet")
public class CoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        String source = "function helloSyntaxHighlighter()\n" +
                "{\n" +
                "\treturn \"hi!\";\n" +
                "}";
        String type = "js";*/

        //     request.setAttribute("source", source);
        //   request.setAttribute("type", type);


        request.getRequestDispatcher("/display.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 /*       System.out.println(request.getParameter("username") + " " + request.getParameter("password")
        + request.getParameter("remember"));*/
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

        CodeService codeService = ctx.getBean("codeService", CodeService.class);

        Code c = new Code();
        c.setOwner("tan");
        c.setTitle("test");
        c.setType("java");
        c.setCode("protected void doGet(HttpServletRequest request, HttpServletResponse response)");
        //c.setId(2);
        if (codeService.commitCode(c)) {
            System.out.println("wowowowo");
        } else System.out.println("nonono");

        //codeService.updateCode(c);
    }
}
