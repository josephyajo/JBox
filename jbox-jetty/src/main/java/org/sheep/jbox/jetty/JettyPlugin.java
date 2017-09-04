package org.sheep.jbox.jetty;

import org.sheep.jbox.api.Plugin;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 16:40 2017/7/31
 */
public class JettyPlugin implements Plugin {
    public void init() {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});
        ServletContextHandler jettyContext = new ServletContextHandler();
        jettyContext.setContextPath("/");
        jettyContext.addServlet(HelloServlet.class, "/hello");
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{jettyContext, new DefaultHandler()});
        server.setHandler(handlers);
        server.start();
        server.join();
    }

    public boolean start() {
        return false;
    }

    public boolean restart() {
        return false;
    }

    public boolean stop() {
        return false;
    }
}
