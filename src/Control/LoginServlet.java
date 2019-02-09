package Control;

import Model.DbDao;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws
            ServletException,IOException{
        String errMsg="";
        RequestDispatcher rd;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try{
            DbDao dbDao=new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test",
                    "root", "root");


            //result of searching
//            ResultSet rs=dbDao.query("select pass from user_table where username = ?", username);
            ResultSet rs = dbDao.query("select pass from user_table where username = ?", username);

            if(rs.next()){

                if(rs.getString("password").equals(password)){

                    HttpSession session=request.getSession(true);
                    session.setAttribute("username",username);

                    rd=request.getRequestDispatcher("/welcome.jsp");

                    rd.forward(request,response);
                }else {
                    errMsg += "username and password is dismatched";
                }

            }else{
                errMsg += "the username is not setting up";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(errMsg != null && !errMsg.equals("")){
            rd = request.getRequestDispatcher("/login.jsp");
            request.setAttribute("err",errMsg);
            rd.forward(request,response);
        }

    }

}
