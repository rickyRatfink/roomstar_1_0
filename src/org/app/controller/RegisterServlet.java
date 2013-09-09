
package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.app.model.User;
import org.app.service.RegisterService;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fName = request.getParameter("firstName");
        String mName = request.getParameter("middleName");
        String lName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        User user = new User(fName,mName,lName, email,userId, password);
                
        try {        
            RegisterService registerService = new RegisterService();
            boolean result = registerService.register(user);            
            out.println("<html>");
            out.println("<head>");            
            out.println("<title>Registration Successful</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if(result){
                out.println("<h1>Registration Successful</h1>");
                out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
            }else{
                out.println("<h1>Registration Unsuccessful</h1>");
                out.println("To try again<a href=register.jsp>Click here</a>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
