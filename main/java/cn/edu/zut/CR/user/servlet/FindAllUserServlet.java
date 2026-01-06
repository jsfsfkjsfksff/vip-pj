package cn.edu.zut.CR.user.servlet;

import cn.edu.zut.CR.user.dao.UserDao;
import cn.edu.zut.CR.user.dao.impl.UserDaoImpl;
import cn.edu.zut.CR.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//"/"
@WebServlet("/findAllUser")
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        try {
            //1.filter 处处理
            //2.接受清酒
            //3.get from dao
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> all = userDao.findAll();
            //4.page-
            request.setAttribute("list",all);//作用域
            request.getRequestDispatcher("/page/user.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
