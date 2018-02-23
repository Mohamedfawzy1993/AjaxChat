package Servlets;

import Beans.Message;
import Beans.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jndi.toolkit.url.Uri;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(urlPatterns = "/chat")
public class ChatHandler extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String msg = req.getParameter("msg");
        User user = (User) req.getSession(false).getAttribute("userData");
        Vector<Message> allMsgs = (Vector)req.getServletContext().getAttribute("chatMsgs");
        Message message = new Message();
        message.setId(Integer.toString(allMsgs.size()));
        message.setMsg(msg);
        message.setSender(user.getUsername());
        setMsg(req , message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        Gson gson = new GsonBuilder().create();
        resp.getWriter().write(gson.toJson(getMessages(id , req)));
    }


    private void setMsg(HttpServletRequest request , Message msg)
    {
        Vector<Message> messageVector= (Vector<Message>) request.getServletContext().getAttribute("chatMsgs");
        messageVector.add(msg);
    }

    private Vector<Message> getMessages(int lastIndex , HttpServletRequest request)
    {
        Vector<Message> messages = new Vector<>();
        Vector<Message> allMsgs = (Vector)request.getServletContext().getAttribute("chatMsgs");
        for(int start = lastIndex+1 ; start < allMsgs.size() ; start++)
        {
            messages.add(allMsgs.get(start));
        }
        System.out.println(messages.size());
        return messages;
    }






}