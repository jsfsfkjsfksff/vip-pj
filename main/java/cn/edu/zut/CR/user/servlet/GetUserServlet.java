package cn.edu.zut.CR.user.servlet;

import cn.edu.zut.CR.user.dao.impl.UserDaoImpl;
import cn.edu.zut.CR.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/getUser")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        Integer id = Integer.valueOf(req.getParameter("id"));
        User byId = userDao.getById(id);
        req.setAttribute("user",byId);
        req.getRequestDispatcher("/page/user_update.jsp").forward(req,resp);
    }
}
