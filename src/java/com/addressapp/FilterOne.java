package com.addressapp;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterOne implements Filter {
    
    private FilterConfig filterConfig = null;
    
    public FilterOne() {
    }    
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)throws IOException, ServletException {
       
        HttpServletRequest hreq = (HttpServletRequest)request;
        HttpSession session = hreq.getSession();        
        String ip = request.getRemoteAddr();
        String browser = hreq.getHeader("user-agent");
        Date d = new Date();        
        log("Log Filter Request Arrived : "+ip+" from "+browser+" at "+d);
        chain.doFilter(request, response);      
    }
    public void destroy() {
        
    }
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
