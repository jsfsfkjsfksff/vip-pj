package cn.edu.zut.CR.car.servlet;


import cn.edu.zut.CR.VO.VIPC;
import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.util.ToConvertVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//"/"
@WebServlet("/findAllCar")
public class FindAllCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        try {
            //1.filter 处处理
            //2.接受清酒
            //3.get from dao
            CarDaoImpl customerDao = new CarDaoImpl();
            List<Car> uAll = customerDao.findAll();
            List<VIPC> all = new ArrayList<>();;
            for (Car car : uAll) {
                //将后台的值进行转换为字符串
                //计算截止时间
                VIPC vipc = ToConvertVO.INSTANCE.convert(car);
                vipc.setRentType(car.getCarCustomer().getPlanLength());
                Timestamp createTime = vipc.getCreateTime();
                LocalDateTime localDateTime = createTime.toLocalDateTime();
                if (vipc.getRentType().equals("overMonth")) {
                    localDateTime = localDateTime.plusMonths(1);
                } else if (vipc.getRentType().equals("overQuarter")) {
                    localDateTime = localDateTime.plusMonths(3);
                } else if (vipc.getRentType().equals("overYear")) {
                    localDateTime = localDateTime.plusYears(1);
                }
                Timestamp deadlineTime = Timestamp.valueOf(localDateTime);
                vipc.setDeadlineTime(deadlineTime);
                all.add(vipc);
            }
            //4.page-

            request.setAttribute("list",all);//作用域
            request.getRequestDispatcher("/page/car.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
