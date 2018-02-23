package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Vector;

@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setMaxInactiveInterval(10);
       Vector onlineUsers =  (Vector)httpSessionEvent.getSession().getServletContext().getAttribute("onlineUsers");
       onlineUsers.add(httpSessionEvent.getSession());

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        System.out.println("Removing Session");
        Vector onlineUsers = (Vector)httpSessionEvent.getSession().getServletContext().getAttribute("onlineUsers");
        onlineUsers.remove(httpSessionEvent.getSession());

    }
}
