package cn.edu.zut.CR.customer.servlet;

import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.customer.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.filter 处处理
            //2.接受清酒
            //id ? where;
            Integer id = Integer.parseInt(request.getParameter("id"));
            String customerName = request.getParameter("customerName");
            String identity = request.getParameter("identity");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");

            Customer customer = new Customer();
            customer.setCustomerName(customerName);
            customer.setId(id);
            customer.setIdentity(identity);
            customer.setGender(gender);
            customer.setAddress(address);
            customer.setPhoneNumber(phoneNumber);
            //3.get from dao
            CustomerDaoImpl customerDao = new CustomerDaoImpl();
            int rows = customerDao.update(customer);
            //4.page-
            if (rows>0) {
                response.sendRedirect("/findAllCustomer");
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
