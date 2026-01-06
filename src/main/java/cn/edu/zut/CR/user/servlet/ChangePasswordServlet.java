package cn.edu.zut.CR.user.servlet;

import cn.edu.zut.CR.user.dao.impl.UserDaoImpl;
import cn.edu.zut.CR.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            //id ? where;
            String password = request.getParameter("password");
            //
            HttpSession session = request.getSession();
            Object object = session.getAttribute("user");
            User user = (User)object;
            user.setPassword(password);
            //3.get from dao
            UserDaoImpl userDao = new UserDaoImpl();
            int rows = userDao.changePassword(user);
            //4.page-
            if (rows > 0) {
                request.setAttribute("error", "密码修改成功");
                request.getRequestDispatcher("/page/change_password.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "密码修改失败");
                request.getRequestDispatcher("/page/error.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
