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
import java.io.IOException;
import java.math.BigDecimal;
@MultipartConfig
@WebServlet("/updateCar")
public class UpdateCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            //id ? where from list
            Integer id = Integer.parseInt(request.getParameter("id"));
            String carNumber = request.getParameter("carNumber");
            String brand = request.getParameter("brand");
            String type = request.getParameter("type");
            String color = request.getParameter("color");
            BigDecimal rentPrice = new BigDecimal(request.getParameter("rentPrice"));
            BigDecimal deposit = new BigDecimal(request.getParameter("deposit"));
            String status = request.getParameter("status");
            String description = request.getParameter("description");
            String picture = request.getParameter("oldPicture");
            Part part = request.getPart("pictureUrl");
            String submittedFileName = part.getSubmittedFileName();
            if (StringUtil.validateString(submittedFileName)) {
                String newFileName = StringUtil.getStringTime() + submittedFileName.substring(submittedFileName.lastIndexOf("."));
//                String s = request.getServletContext().getRealPath("/upload/") + newFileName;
//                System.out.println(s);
//                part.write(s);
                //set new picture
                HuaweiUtil.upload(part.getInputStream(),newFileName);
                picture = newFileName;
            }
            Car car = new Car();
            car.setId(id);
            car.setCarNumber(carNumber);
            car.setBrand(brand);
            car.setType(type);
            car.setColor(color);
            car.setRentPrice(rentPrice);
            car.setDeposit(deposit);
            car.setStatus(status);
            car.setDescription(description);
            car.setPicture(picture);
            //3.get from dao
            CarDaoImpl carDao = new CarDaoImpl();
            int rows = carDao.update(car);
            int rows2 = carDao.updateStatus(car.getId(),car.getStatus());
            //4.page-
            if (rows*rows2>0) {
                response.sendRedirect("/findAllCar");
            }
            else {
                request.setAttribute("error","update failed");
                request.getRequestDispatcher("/page/error.jsp").forward(request,response);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
