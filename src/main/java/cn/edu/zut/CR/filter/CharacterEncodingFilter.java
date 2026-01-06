package cn.edu.zut.CR.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getServletPath();
        if (!path.startsWith("/assets")) {
            // 设置请求的字符编码
            request.setCharacterEncoding("UTF-8");
            // 设置响应的内容类型
            response.setContentType("text/html;charset=UTF-8");
        }
        // 放行请求
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
