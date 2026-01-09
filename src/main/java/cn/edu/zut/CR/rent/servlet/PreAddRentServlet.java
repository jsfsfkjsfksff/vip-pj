package cn.edu.zut.CR.rent.servlet;

import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.customer.dao.CustomerDao;
import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.customer.entity.Customer;
import cn.edu.zut.CR.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/preAddRent")
public class PreAddRentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer carId = Integer.parseInt(req.getParameter("carId"));
        // 查询单个车辆
        CarDao carDao = new CarDaoImpl();
        Car car = carDao.getById(carId);
        req.setAttribute("car", car);

        // 生成出租单号
        req.setAttribute("rentSn", StringUtil.createSn("CZ"));

        // 查询所有客户
        CustomerDao customerDao = new CustomerDaoImpl();
        List<Customer> customerList = customerDao.findAll();
        req.setAttribute("customerList", customerList);

        req.getRequestDispatcher("/page/rent_add.jsp").forward(req, resp);
    }
}