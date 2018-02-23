package Servlets;

import Beans.User;
import Database.UserOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet( urlPatterns = "/Login")
public class LoginHandler extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            checkUser(req ,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            checkUser(req ,resp);
    }

    private void checkUser(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)
            throws IOException, ServletException {

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("pass");
        PrintWriter out = httpServletResponse.getWriter();
        HashMap<String, User> userHashMap = (HashMap) getUsersMap(httpServletRequest);
        System.out.println(username);
        System.out.println(password);
        if (username != null && password != null && !username.trim().isEmpty() && !password.trim().isEmpty()){
            UserOperation userOperation = new UserOperation(userHashMap);
            User user = userOperation.getUser(username.toLowerCase());

            if(user != null)
                if(user.getPassword().equals(password))
                {
                    createUserSession(httpServletRequest , user);
                    out.write("true");
                }
                else
                    out.write("Incorrect Password");
            else
            {
                out.write("User Not Found");
            }
        }
        else
        {
            out.write("Invalid Data");
        }

    }

    private Object getUsersMap(HttpServletRequest request) {
        Object userHashMap = request.getServletContext().getAttribute("userHash");
        if( userHashMap == null)
        {
            request.getServletContext().setAttribute("userHash" , new HashMap<String , User>());
            userHashMap = request.getServletContext().getAttribute("userHash");
        }
        return userHashMap;
    }

    private void createUserSession(HttpServletRequest request , User user)
    {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("userData" , user);
    }
}
