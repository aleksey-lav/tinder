package ua.danit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.danit.servlets.ServletUsers;


public class AppTinder {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        ServletHolder holder = new ServletHolder(new ServletUsers());
        handler.addServlet(holder, "/users");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}

