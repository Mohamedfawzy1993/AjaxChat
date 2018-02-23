package Servlets;

import Beans.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@WebServlet(urlPatterns = "/online")
public class OnlineUserHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendJson(resp , onlineUsers(req));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendJson(resp , onlineUsers(req));
    }


    private void sendJson(HttpServletResponse response , Object data) throws IOException {
        response.setContentType("Application/Json");
        Gson gson = new GsonBuilder().create();
        response.getWriter().write(gson.toJson(data));
    }
    private List<String> onlineUsers(HttpServletRequest request) {
        Vector<HttpSession> httpSessions =(Vector) request.getServletContext().getAttribute("onlineUsers");

        List<String> users = new ArrayList<>();
        for(HttpSession session :  httpSessions)
        {
            User user = (User) session.getAttribute("userData");
            users.add(user.getUsername());
        }
        return users;

    }
}
