package cn.edu.zut.CR.user.servlet;

import cn.edu.zut.CR.user.dao.impl.UserDaoImpl;
import cn.edu.zut.CR.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            //id ? where;
            Integer id = Integer.parseInt(request.getParameter("id"));
            String userName = request.getParameter("userName");
            String nickName = request.getParameter("nickName");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");

            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setNickName(nickName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            //3.get from dao
            UserDaoImpl userDao = new UserDaoImpl();
            int rows = userDao.update(user);
            //4.page-
            if (rows>0) {
                response.sendRedirect("/findAllUser");
            }
            else {
                request.setAttribute("error","update failed");
                request.getRequestDispatcher("/page/error.jsp").forward(request,response);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
