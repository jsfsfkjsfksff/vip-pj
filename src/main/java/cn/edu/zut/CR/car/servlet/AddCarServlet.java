package cn.edu.zut.CR.car.servlet;

import cn.edu.zut.CR.car.dao.impl.CarDaoImpl;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.util.HuaweiUtil;
import cn.edu.zut.CR.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@MultipartConfig
@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受请求
            String carNumber = request.getParameter("carNumber");
            String brand = request.getParameter("brand");
            String type = request.getParameter("type");
//            String color = request.getParameter("color");
            /**
             * 这里的强制类型转换是错误的，应该使用new BigDecimal(request.getParameter("rentPrice"))来转换字符串为BigDecimal类型
             */
            BigDecimal rentPrice = new BigDecimal(request.getParameter("rentPrice"));
//            BigDecimal deposit = new BigDecimal(request.getParameter("deposit"));
            String description = request.getParameter("description");
            String picture = "";
            //todo:文件上传
            //shangchuanduixiang
            Part part = request.getPart("picture");
            //wenjianmingcheng
            String submittedFileName = part.getSubmittedFileName();
            //shifoushangchuan
            if (StringUtil.validateString(submittedFileName)) {
                String newFileName = StringUtil.getStringTime() + submittedFileName.substring(submittedFileName.lastIndexOf("."));
                //cunchu
//                new File("D:/upload/car/").mkdirs();
//                picture1.write("D:/upload/car/" + newFileName);
//                String s = request.getServletContext().getRealPath("/upload/") + newFileName;
//                System.out.println(s);
//                part.write(s);
                HuaweiUtil.upload(part.getInputStream(),newFileName);
                picture = newFileName;
            }
            //3.get from dao
            Car car = new Car();
            car.setCarNumber(carNumber);
            car.setBrand(brand);
            car.setType(type);
//            car.setColor(color);
            car.setRentPrice(rentPrice);
//            car.setDeposit(deposit);
            car.setDescription(description);
            car.setPicture(picture);
            CarDaoImpl carDao = new CarDaoImpl();
            int rows = carDao.insert(car);
            //4.page-
            if (rows>0) {
                response.sendRedirect("/findAllCar");
            }
            else {
                request.setAttribute("error","新增失败");
                request.getRequestDispatcher("/page/error.jsp").forward(request,response);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
