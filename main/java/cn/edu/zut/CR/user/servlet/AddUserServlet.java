package cn.edu.zut.CR.user.servlet;

import cn.edu.zut.CR.user.dao.impl.UserDaoImpl;
import cn.edu.zut.CR.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            String userName = request.getParameter("userName");
            String nickName = request.getParameter("nickName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            //3.get from dao
            User user = new User();
            user.setUserName(userName);
            user.setNickName(nickName);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            UserDaoImpl userDao = new UserDaoImpl();
            int rows = userDao.insert(user);
            //4.page-
            if (rows>0) {
                response.sendRedirect("/findAllUser");
            }
            else {
                request.setAttribute("error","新增失败");
                request.getRequestDispatcher("/page/error.jsp").forward(request,response);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
