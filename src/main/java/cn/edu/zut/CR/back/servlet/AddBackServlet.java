package cn.edu.zut.CR.back.servlet;

import cn.edu.zut.CR.VO.Rent;
import cn.edu.zut.CR.back.dao.BackDao;
import cn.edu.zut.CR.back.dao.impl.BackDaoImpl;
import cn.edu.zut.CR.back.entity.Back;
import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.rent.dao.RentDao;
import cn.edu.zut.CR.rent.dao.impl.RentDaoImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addBack")
public class AddBackServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String backSn = req.getParameter("backSn");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date returnDate = null;
//        try {
//            returnDate = sdf.parse(req.getParameter("returnDate"));
//        } catch (Exception e) {
//            req.setAttribute("error", "日期处理失败");
//            req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
//        }
        Integer rentId = Integer.parseInt(req.getParameter("rentId"));
        String problem = req.getParameter("problem");
        BigDecimal payMoney = new BigDecimal(req.getParameter("payMoney"));
        String description = req.getParameter("description");
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("user");
        String operName = loginUser.getUserName();

        Back back = new Back();
        back.setBackSn(backSn);
//        back.setReturnDate(backSn);
        back.setRentId(rentId);
        back.setProblem(problem);
        back.setPayMoney(payMoney);
        back.setDescription(description);
        back.setOperName(operName);
        back.setCreateTime(new Date());
        back.setUpdateTime(new Date());

        BackDao backDao = new BackDaoImpl();
        int rows = backDao.insert(back);

        // 根据ID查询出租单
        RentDao rentDao = new RentDaoImpl();
        Rent rent = rentDao.getById(rentId);
        // 修改出租单状态
        rent.setStatus(ConstantUtil.CUB_ENTER);
        rentDao.updateStatus(rent);

        // 修改车辆状态
        CarDao carDao = new CarDaoImpl();
        Car car = new Car();
        car.setId(rent.getCarId());
        car.setStatus(ConstantUtil.PLAN_QUIT);
        carDao.updateStatus(car);

        if (rows > 0) {
            resp.sendRedirect("/findAllBack");
        } else {
            req.setAttribute("error", "新增失败");
            req.getRequestDispatcher("/page/error.jsp").forward(req, resp);
        }
    }
}