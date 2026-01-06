package cn.edu.zut.CR.customer.servlet;

import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.customer.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//"/"
@WebServlet("/findAllCustomer")
public class FindAllCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        try {
            //1.filter 处处理
            //2.接受清酒
            //3.get from dao
            CustomerDaoImpl customerDao = new CustomerDaoImpl();
            List<Customer> all = customerDao.findAll();
            //4.page-
            request.setAttribute("list",all);//作用域
            request.getRequestDispatcher("/page/customer.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
