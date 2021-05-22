
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class MainClass {
    public static void main(String[] args) throws Exception {
        final String url = "http://localhost:" + 8080;
        URI uri = URI.create(url);
        ResourceConfig serverConfig = new ResourceConfig(JerseyApplication.class);

        Server server = JettyHttpContainerFactory.createServer(uri, serverConfig, false);

        try {
            server.start();
            server.join();
        }
        finally{
            server.stop();
        }
    }
}

 /*

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        server.setHandler(getJerseyHandler());
        server.start();
        server.join();
    }

    private static Handler getJerseyHandler() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");
        ServletHolder servlet = handler.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        servlet.setInitOrder(0);
        servlet.setInitParameter("jersey.config.server.provider.classnames", MyEndpoint.class.getCanonicalName());

        return handler;
    }
}


  */