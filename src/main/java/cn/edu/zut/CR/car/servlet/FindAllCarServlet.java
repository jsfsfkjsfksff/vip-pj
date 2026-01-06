package cn.edu.zut.CR.car.servlet;


import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            List<Car> all = customerDao.findAll();
            //4.page-
            request.setAttribute("list",all);//作用域
            request.getRequestDispatcher("/page/car.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
