package cn.edu.zut.CR.customer.servlet;


import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;
import cn.edu.zut.CR.customer.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCustomer")
public class GetCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        Integer id = Integer.valueOf(req.getParameter("id"));
        Customer byId = customerDao.getById(id);
        req.setAttribute("customer",byId);
        req.getRequestDispatcher("/page/customer_update.jsp").forward(req,resp);
    }
}
