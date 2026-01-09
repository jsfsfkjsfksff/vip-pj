package cn.edu.zut.CR.rent.servlet;

import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.car_customer.CarCustomer;
import cn.edu.zut.CR.util.dataUtil.PriceCalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/toCalculate")
public class ToCalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        /**
         * level == clazz
         */
        String level = req.getParameter("clazz");
        String type = req.getParameter("type");
        String rentSn = req.getParameter("rentSn");
        String carId = req.getParameter("carId");
        String carNumber = req.getParameter("carNumber");
        String customerId = req.getParameter("customerId");

        // 2. 调用 Java 方法计算
        BigDecimal finalPrice = PriceCalculator.calculate(level, type);

        // 3. 把结果存入 request
        CarCustomer carCustomer = new CarCustomer();
        carCustomer.setPlanLength(type);
        carCustomer.setPlanType(level);
        req.setAttribute("finalPrice", finalPrice);
        req.setAttribute("level", level);
        req.setAttribute("type", type);
        req.setAttribute("rentSn",rentSn);
        req.setAttribute("carId",carId);
        req.setAttribute("carNumber",carNumber);
        req.setAttribute("customerId",customerId);
        // 4. 跳转到结算结果展示页面
        req.getRequestDispatcher("/page/result.jsp").forward(req, resp);
    }
}
