package cn.edu.zut.CR.customer.servlet;

import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.customer.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            String customerName = request.getParameter("customerName");
            String gender = request.getParameter("gender");
            String identity = request.getParameter("identity");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            //3.get from dao
            Customer customer = new Customer();
            customer.setCustomerName(customerName);
            customer.setGender(gender);
            customer.setPhoneNumber(phoneNumber);
            customer.setIdentity(identity);
            customer.setAddress(address);
            CustomerDaoImpl customerDao = new CustomerDaoImpl();
            int rows = customerDao.insert(customer);
            //4.page-
            if (rows>0) {
                response.sendRedirect("/findAllCustomer");
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
