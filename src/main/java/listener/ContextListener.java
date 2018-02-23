package listener;

import Beans.Message;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Vector;

@WebListener
public class ContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("onlineUsers" , new Vector<HttpSession>());
        servletContextEvent.getServletContext().setAttribute("chatMsgs" , new Vector<Message>());

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
