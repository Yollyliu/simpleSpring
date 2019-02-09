package Control;


import Model.DbDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet (name="register",urlPatterns = {"/register"})

public class RegisterServlet extends HttpServlet {

    public void service(HttpServletResponse response, HttpServletRequest request)
        throws ServletException,IOException{
        String errMsg="";
        RequestDispatcher rd;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String conPass=request.getParameter("conPass");

        if(username.length()==0||(password.length()==0||!password.equals(conPass))){
            errMsg += "Register failed. Username and password should not be empty";
        }
        else{
            try{
                DbDao dbDao=new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test",
                        "root", "root");
                ResultSet rs=dbDao.query("select password from user_table where" +
                        "username = ? "+ username);
                if(rs.next()){
                    errMsg += "This username already exist.";
                }else{
                    boolean addUser=dbDao.insert("insert into user_table" +
                            "(username, password) value(?,?)",username,password);
                    if(!addUser){
                        errMsg +=" Register Fail";
                    }

                    HttpSession session=request.getSession(true);
                    session.setAttribute("username",username);

                    rd=request.getRequestDispatcher("/welcome.jsp");
                    rd.forward(request,response);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(errMsg!=null && !errMsg.equals("")){
            rd=request.getRequestDispatcher("/register.jsp");
            request.setAttribute("err",errMsg);
            rd.forward(request,response);
        }

    }
}
