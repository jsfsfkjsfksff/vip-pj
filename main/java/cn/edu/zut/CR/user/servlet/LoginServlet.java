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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username").trim();
        String password = req.getParameter("password");
        //
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getByUsername(userName);
        //
        if (user!=null) {
            if (password.equals(user.getPassword())) {
                //在session中存放自己的session，以后省份认证
                // 跳转首页面
                HttpSession session = req.getSession(true);
                session.setAttribute("user",user);
                resp.sendRedirect("/page/index.jsp");
            }
            else {
                req.setAttribute("error","password failed");
                req.getRequestDispatcher("/page/error.jsp").forward(req,resp);
            }
        }
        else {
            req.setAttribute("error","username failed");
            req.getRequestDispatcher("/page/error.jsp").forward(req,resp);
        }
    }
}
