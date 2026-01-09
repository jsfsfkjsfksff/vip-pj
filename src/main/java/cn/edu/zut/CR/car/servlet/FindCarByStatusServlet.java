package cn.edu.zut.CR.car.servlet;

import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.util.ConstantUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findCarByStatus")
public class FindCarByStatusServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDao carDao = new CarDaoImpl();
        List<Car> list = carDao.findByStatus(ConstantUtil.PLAN_QUIT);

        req.setAttribute("list", list);
        req.getRequestDispatcher("/page/rent_car.jsp").forward(req, resp);
    }
}