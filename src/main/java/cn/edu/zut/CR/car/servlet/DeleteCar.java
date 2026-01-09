package cn.edu.zut.CR.car.servlet;

import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.util.HuaweiUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCar")
public class DeleteCar extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        CarDaoImpl CarDao = new CarDaoImpl();
        Car byId = CarDao.getById(id);
        System.out.println(byId.getPicture());
        //delete yunpicture
        HuaweiUtil.delete(byId.getPicture());
        //delete database record
        int rows = CarDao.deleteById(id);
        if (rows>0) {
            resp.sendRedirect("/findAllCar");
        }
        else {
            req.setAttribute("error","delete failed");
            req.getRequestDispatcher("/page/error.jsp").forward(req,resp);
        }
    }
}
