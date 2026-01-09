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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Properties;

@MultipartConfig
@WebServlet("/updateCar")
public class UpdateCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            //id ? where from list
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("price.properties"));
            Integer id = Integer.parseInt(request.getParameter("id"));
            String carNumber = request.getParameter("carNumber");
            String brand = request.getParameter("brand");
            String clazz = request.getParameter("class");
            String type = request.getParameter("type");
//            String color = request.getParameter("color");
            //reflect
            String className = "cn.edu.zut.CR.util.dataUtil"+"."+ clazz;
            Class<?> aClass = Class.forName(className);
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(Properties.class);
            declaredConstructor.setAccessible(true);
            Object obj = declaredConstructor.newInstance(properties);
            Field field = aClass.getDeclaredField(type);
            field.setAccessible(true);
            Object object = field.get(obj);
            BigDecimal rentPrice = (BigDecimal) object;
//            BigDecimal deposit = new BigDecimal(request.getParameter("deposit"));
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
            car.setType(clazz);
            car.setRentPrice(rentPrice);
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
        } catch (IOException | ServletException | ClassNotFoundException | NoSuchFieldException |
                 InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
