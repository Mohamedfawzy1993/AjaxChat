package Servlets;

import Beans.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/Register")
public class RegisterHandler extends HttpServlet{

    private HashMap<String , User> userHashMap ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userHashMap = (HashMap)config.getServletContext().getAttribute("userHash");
        if(userHashMap == null)
        {
            config.getServletContext().setAttribute("userHash" , new HashMap<String , User>());
            userHashMap = (HashMap)config.getServletContext().getAttribute("userHash");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String res = validateInput(req);
        registerHandleMethod(req, resp, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String res = validateInput(req);
        registerHandleMethod(req, resp, res);
    }

    private void registerHandleMethod(HttpServletRequest req, HttpServletResponse resp, String res) throws IOException {
        if(res.equals("true"))
        {
            User user = new User(req.getParameter("username") , req.getParameter("pass"));
            registerUser(user);
            resp.getWriter().write("Registered Successfully !");
        }
        else
        {
            resp.getWriter().write(res);
        }
    }


    private String validateInput(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        if(username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty())
        {
            return "Invalid Data";
        }
        else if(userHashMap.get(username) != null)
        {
            return "username Already Exist !";
        }
        else
        {
            return "true";
        }
    }

    private void registerUser(User user)
    {
        userHashMap.put(user.getUsername() , user);
    }


}
