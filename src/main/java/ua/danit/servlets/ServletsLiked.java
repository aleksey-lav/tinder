package ua.danit.servlets;

import ua.danit.dao.LikedDAO;
import ua.danit.model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ServletsLiked extends HttpServlet {
    private final Set<Users> likedSet;

    public ServletsLiked(Set<Users> likedSet) {
        this.likedSet = likedSet;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//        cfg.setDirectoryForTemplateLoading(new File("./src/main/java/resources/static/html/"));
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setLogTemplateExceptions(false);
//        cfg.setWrapUncheckedExceptions(true);
//        Map<String, Object> model = new HashMap<>();
//        Template template = cfg.getTemplate("people-list.html");
//        Writer out = resp.getWriter();
//        model.put("liked", likedSet);
//
//        try {
//            template.process(model, out);
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
        PrintWriter writer = resp.getWriter();
        String s = printFile("likedTemplate.html");
        LikedDAO likedDAO = new LikedDAO();
        List<Users> likedUsers = likedDAO.getUsers();
        for (Users user : likedUsers) {
            writer.format(Locale.UK, s, user.getId(), user.getName(), user.getUrl());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("chat").equals("Chat")){
            String userId = req.getParameter("userId");
            getServletContext().setAttribute("userId", userId);
            resp.sendRedirect("/messages/" + userId);
        }
    }

    private String printFile(String fileName){
        StringBuilder sb = new StringBuilder();
        String userDir = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        String filepath = userDir + sep + "\\src\\main\\java\\templates" + sep + fileName;
        try(FileReader reader = new FileReader(filepath);
            BufferedReader buffReader = new BufferedReader(reader))
        {
            String text = "";
            while((text = buffReader.readLine()) != null){
                sb.append(text);
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
}