package ua.danit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sun.tools.jar.CommandLine;
import ua.danit.dao.ClientDAO;
import ua.danit.model.Client;
import ua.danit.model.Users;
import ua.danit.servlets.ServletMessages;
import ua.danit.servlets.ServletUsers;
import ua.danit.servlets.ServletsLiked;
import ua.danit.servlets.StaticServlet;

import java.util.HashSet;
import java.util.Set;


public class AppTinder {
    public static void main(String[] args) throws Exception {
            //Database base = new DataBaseHashMap();
            Set<Users> likedSet = new HashSet<>();
            new Server(8080){{
                setHandler(new ServletContextHandler() {{
                               addServlet(new ServletHolder(new ServletUsers(likedSet)) ,"/users");
                               addServlet(new ServletHolder(new StaticServlet()),"/assets/*");
                              /* addServlet(new ServletHolder(new ServletsLinked(likedSet)) ,"/liked");
                               addServlet(new ServletHolder(new ServletMessages()) ,"/messages");*/
                           }}
                );
                start();
                join();
            }};

        }
public static class Main2 {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();
        client.setLogin("hrobak");
        client.setName("hr");
        client.setPassword("12");
        clientDAO.save(client);

    }
}
    }

