package cn.edu.zut.CR.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
@MultipartConfig
@WebServlet("/testUpload")
public class TestUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //part是上传文件对象
        Part file = req.getPart("file");
        String submittedFileName = file.getSubmittedFileName();
        long size = file.getSize();
        System.out.println("上传的文件："+submittedFileName+"，大小："+size);
        new File("D:/upload").mkdirs();
        file.write("D:/upload/"+submittedFileName);
    }
}
