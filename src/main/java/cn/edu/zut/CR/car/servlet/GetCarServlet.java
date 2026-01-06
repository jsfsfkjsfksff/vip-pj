package cn.edu.zut.CR.car.servlet;


import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCar")
public class GetCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDaoImpl carDao = new CarDaoImpl();
        Integer id = Integer.valueOf(req.getParameter("id"));
        Car byId = carDao.getById(id);
        req.setAttribute("car",byId);
        req.getRequestDispatcher("/page/car_update.jsp").forward(req,resp);
    }
}
