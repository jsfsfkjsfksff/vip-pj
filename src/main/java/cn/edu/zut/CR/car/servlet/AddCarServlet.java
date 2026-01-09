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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;

@MultipartConfig
@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受请求
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("price.properties"));
            String carNumber = request.getParameter("carNumber");
            String brand = request.getParameter("brand");
            String type = request.getParameter("type");
            String clazz = request.getParameter("class");
            //class,通过反射机制获取字段值
            String className = "cn.edu.zut.CR.util.dataUtil"+"."+ clazz;
            Class<?> aClass = Class.forName(className);
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(Properties.class);
            declaredConstructor.setAccessible(true);
            Object obj = declaredConstructor.newInstance(properties);
            Field field = aClass.getDeclaredField(type);
                field.setAccessible(true);
                Object object = field.get(obj);
                BigDecimal rentPrice = (BigDecimal) object;
            String description = request.getParameter("description");
            String status = request.getParameter("status");
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
            car.setType(clazz);
//            car.setColor(color);
            car.setRentPrice(rentPrice);
//            car.setDeposit(deposit);
            car.setDescription(description);
            car.setStatus(status);
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
        } catch (IOException | ServletException | ClassNotFoundException | NoSuchMethodException |
                 NoSuchFieldException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
