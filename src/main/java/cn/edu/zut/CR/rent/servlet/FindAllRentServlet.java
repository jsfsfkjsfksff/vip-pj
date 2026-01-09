package cn.edu.zut.CR.rent.servlet;

import cn.edu.zut.CR.rent.dao.RentDao;
import cn.edu.zut.CR.rent.dao.impl.RentDaoImpl;
import cn.edu.zut.CR.VO.Rent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllRent")
public class FindAllRentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RentDao rentDao = new RentDaoImpl();
        List<Rent> list = rentDao.findAll();

        req.setAttribute("list", list);
        req.getRequestDispatcher("/page/rent.jsp").forward(req, resp);
    }
}