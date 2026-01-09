package cn.edu.zut.CR.back.servlet;

import cn.edu.zut.CR.VO.Rent;
import cn.edu.zut.CR.back.dao.BackDao;
import cn.edu.zut.CR.back.dao.impl.BackDaoImpl;
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

@WebServlet("/deleteBack")
public class DeleteBackServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer rentId = Integer.parseInt(req.getParameter("rentId"));

        // 根据ID查询出租单
        RentDao rentDao = new RentDaoImpl();
        Rent rent = rentDao.getById(rentId);
        // 修改出租单状态
        rent.setStatus(ConstantUtil.CUB_OUTER);
        rentDao.updateStatus(rent);

        // 修改车辆状态
        CarDao carDao = new CarDaoImpl();
        Car car = new Car();
        car.setId(rent.getCarId());
        car.setStatus(ConstantUtil.PLAN_GONING);
        carDao.updateStatus(car);

        BackDao backDao = new BackDaoImpl();
        int rows = backDao.deleteById(id);
        if (rows > 0) {
            resp.sendRedirect("/findAllBack");
        } else {
            req.setAttribute("error", "删除失败");
            req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
        }
    }
}