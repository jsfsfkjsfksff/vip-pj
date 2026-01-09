package cn.edu.zut.CR.back.servlet;

import cn.edu.zut.CR.VO.Rent;
import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.customer.dao.CustomerDao;
import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.customer.entity.Customer;
import cn.edu.zut.CR.rent.dao.RentDao;
import cn.edu.zut.CR.rent.dao.impl.RentDaoImpl;
import cn.edu.zut.CR.util.ConstantUtil;
import cn.edu.zut.CR.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/preAddBack")
public class PreAddBackServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rentIdStr = req.getParameter("rentId");

        // 查询状态为未归还的出租单
        RentDao rentDao = new RentDaoImpl();
        List<Rent> rentList = rentDao.findByStatus(ConstantUtil.CUB_OUTER);

        // 判断rentId是否为空
        // 如果为空，表示用户还未选择出租单
        if (StringUtil.validateString(rentIdStr)) {
            // 不为空，表示用户已经选择出租单，进行数据查询
            // 根据ID查询出租单
            Integer rentId = Integer.parseInt(rentIdStr);
            Rent rent = rentList.stream().filter(r -> r.getId().equals(rentId)).findFirst().orElse(null);

            // 根据ID查询客户
            CustomerDao customerDao = new CustomerDaoImpl();
            Customer customer = customerDao.getById(rent.getCustomerId());

            // 根据ID查询车辆
            CarDao carDao = new CarDaoImpl();
            Car car = carDao.getById(rent.getCarId());

            // 生成归还单号
            String backSn = StringUtil.createSn("GH");

            req.setAttribute("rent", rent);
            req.setAttribute("customer", customer);
            req.setAttribute("car", car);
            req.setAttribute("backSn", StringUtil.createSn("CZ"));
        }
        req.setAttribute("rentList", rentList);

        req.getRequestDispatcher("/page/back_add.jsp").forward(req, resp);
    }
}