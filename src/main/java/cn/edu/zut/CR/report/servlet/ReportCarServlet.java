package cn.edu.zut.CR.report.servlet;
import cn.edu.zut.CR.report.pojo.Report;
import cn.edu.zut.CR.report.dao.ReportDao;
import cn.edu.zut.CR.report.dao.impl.ReportDaoImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reportCar")
public class ReportCarServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReportDao reportDao = new ReportDaoImpl();
        List<Report> list = reportDao.getCarByType();

        String json = JSON.toJSONString(list);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}