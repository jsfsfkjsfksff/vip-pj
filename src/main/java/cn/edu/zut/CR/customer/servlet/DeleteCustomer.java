package cn.edu.zut.CR.customer.servlet;

import cn.edu.zut.CR.customer.dao.impl.CustomerDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        int rows = customerDao.deleteById(id);
        if (rows>0) {
            resp.sendRedirect("/findAllCustomer");
        }
        else {
            req.setAttribute("error","delete failed");
            req.getRequestDispatcher("/page/error.jsp").forward(req,resp);
        }
    }
}
