package cn.edu.zut.CR.rent.servlet;

import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.rent.dao.RentDao;
import cn.edu.zut.CR.rent.dao.impl.RentDaoImpl;
import cn.edu.zut.CR.util.ConstantUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteRent")
public class DeleteRentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer carId = Integer.parseInt(req.getParameter("carId"));

        // 单查车辆
        CarDao carDao = new CarDaoImpl();
        Car car = carDao.getById(carId);

        // 修改车辆状态
        car.setStatus(ConstantUtil.PLAN_QUIT);
        carDao.updateStatus(car);

        RentDao rentDao = new RentDaoImpl();
        int rows = rentDao.deleteById(id);
        if (rows > 0) {
            resp.sendRedirect("/findAllRent");
        } else {
            req.setAttribute("error", "删除失败");
            req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
        }
    }
}