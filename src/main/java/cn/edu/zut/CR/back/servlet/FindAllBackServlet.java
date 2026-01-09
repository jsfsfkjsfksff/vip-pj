package cn.edu.zut.CR.back.servlet;

import cn.edu.zut.CR.back.dao.BackDao;
import cn.edu.zut.CR.back.dao.impl.BackDaoImpl;
import cn.edu.zut.CR.back.entity.Back;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllBack")
public class FindAllBackServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BackDao backDao = new BackDaoImpl();
        List<Back> list = backDao.findAll();

        req.setAttribute("list", list);
        req.getRequestDispatcher("/page/back.jsp").forward(req, resp);
    }
}