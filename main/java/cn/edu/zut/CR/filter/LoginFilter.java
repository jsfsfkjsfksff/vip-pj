package cn.edu.zut.CR.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String servletPath = request.getServletPath();
        if (!servletPath.startsWith("/assets")) {
            if (!servletPath.equals("/login")&&!servletPath.equals("/page/login.jsp")) {
                HttpSession session = request.getSession();
                Object user = session.getAttribute("user");
                if (user==null){
                    response.sendRedirect("/page/login.jsp");
                }
                else {
                    filterChain.doFilter(request,response);
                }
            }else {
                filterChain.doFilter(request,response);
            }
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
