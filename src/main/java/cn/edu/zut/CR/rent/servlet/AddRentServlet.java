package cn.edu.zut.CR.rent.servlet;

import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.rent.dao.RentDao;
import cn.edu.zut.CR.rent.dao.impl.RentDaoImpl;
import cn.edu.zut.CR.VO.Rent;
import cn.edu.zut.CR.user.entity.User;
import cn.edu.zut.CR.util.ConstantUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import static cn.edu.zut.CR.util.dataUtil.BackDate.TAKE_TIME;

@WebServlet("/addRent")
public class AddRentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rentSn = req.getParameter("rentSn");
        Integer carId = Integer.parseInt(req.getParameter("carId"));
        Integer customerId = Integer.parseInt(req.getParameter("customerId"));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date rentDate = null;
//        Date backDate = null;
//        try {
////            rentDate = sdf.parse(req.getParameter("rentDate"));
//            backDate = sdf.parse(req.getParameter("backDate"));
//        } catch (Exception e) {
//            req.setAttribute("error", "日期处理失败");
//            req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
//        }
        BigDecimal rentPrice = new BigDecimal(req.getParameter("rentPrice"));
        String status = ConstantUtil.CUB_OUTER;
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("user");
        String operName = loginUser.getUserName();

        Rent rent = new Rent();
        rent.setRentSn(rentSn);
        rent.setCarId(carId);
        rent.setCustomerId(customerId);
//        rent.setRentDate(rentDate);
        rent.setBackDate(TAKE_TIME);
        rent.setRentPrice(rentPrice);
        rent.setStatus(status);
        rent.setOperName(operName);
        rent.setCreateTime(new Date());
        rent.setUpdateTime(new Date());

        RentDao rentDao = new RentDaoImpl();
        int rows = rentDao.insert(rent);

        // 修改车辆状态
        CarDao carDao = new CarDaoImpl();
        Car car = new Car();
        car.setId(carId);
        car.setStatus(ConstantUtil.PLAN_GONING);
        carDao.updateStatus(car);

        if (rows > 0) {
            resp.sendRedirect("/findAllRent");
        } else {
            req.setAttribute("error", "新增失败");
            req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
        }
    }
}