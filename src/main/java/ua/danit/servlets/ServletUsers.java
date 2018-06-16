package ua.danit.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import ua.danit.model.Users;
import ua.danit.model.UsersLst;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class ServletUsers extends HttpServlet {

    private final Set<Users> likedSet;
    UsersLst userList = new UsersLst();
    int index = 0;

    public ServletUsers(Set<Users> likedSet) {
        this.likedSet = likedSet;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("./src/main/java/ua/danit/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        Map<String, Object> model = new HashMap<>();
        model.put("user", "Alexei");

        model.put("name", userList.get().get(index).getName());
        model.put("link", userList.get().get(index).getUrl());
        Template template = cfg.getTemplate("template1.ftlh");
        Writer out = resp.getWriter();


        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("answer") != null && req.getParameter("answer").equals("yes") || req.getParameter("answer").equals("no")) {
            if (index < userList.get().size() - 1) {
                index++;
            } else index = 0;
        }
        /*if (req.getParameter("direction") != null && req.getParameter("direction").equals("back")) {
            if (index > 0) {
                index--;
            } else index = usersLst.get().size() - 1;
        }*/
        if (req.getParameter("answer") != null && req.getParameter("answer").equals("yes")) {
            likedSet.add(userList.get().get(index));
        }
        doGet(req, resp);
    }
}