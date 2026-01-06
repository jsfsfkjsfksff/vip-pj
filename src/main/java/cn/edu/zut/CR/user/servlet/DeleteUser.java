package cn.edu.zut.CR.user.servlet;

import cn.edu.zut.CR.user.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        UserDaoImpl userDao = new UserDaoImpl();
        int rows = userDao.deleteById(id);
        if (rows>0) {
            resp.sendRedirect("/findAllUser");
        }
        else {
            req.setAttribute("error","delete failed");
            req.getRequestDispatcher("/page/error.jsp").forward(req,resp);
        }
    }
}
