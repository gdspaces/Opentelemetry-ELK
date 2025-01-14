package com.example.inventory.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;
import java.util.Enumeration;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static String App_name ="InventoryService";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID requestId = UUID.randomUUID();
        request.setAttribute("start",System.currentTimeMillis());
        request.setAttribute("request-id",requestId);
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
        }
       /*  Enumeration<String> headerNames = request.getHeaderNames();
        String header = "";

        StringBuffer posted = new StringBuffer();
        Enumeration<?> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String curr = (String) e.nextElement();
            posted.append(curr + "=");
            posted.append(request.getParameter(curr));
            if (posted.length() > 1) {
                posted.append(";");
            }
        }
            

        if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    if (header=="")
                    header =  headerNames.nextElement() + "="+ request.getHeader(headerNames.nextElement());
                    else
                        header = header +";"+ headerNames.nextElement() +"=" + request.getHeader(headerNames.nextElement());
                }
        }
*/
        log.info("App={},Request ID={},URI={},Method={},IpAddress={},Header={}" ,App_name,requestId,request.getRequestURI()+getParameters(request),request.getMethod(),ipAddress,"");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("App={},Request ID={},Response Time={} ms" ,App_name, request.getAttribute("request-id"),System.currentTimeMillis() - (long) request.getAttribute("start"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("App={},Request ID={},Completion Time={} ms,Response Code={}" , App_name,request.getAttribute("request-id"),System.currentTimeMillis() - (long) request.getAttribute("start"), response.getStatus());

    }


    private String getParameters(HttpServletRequest request) {
        StringBuilder posted = new StringBuilder();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        while (e.hasMoreElements()) {
            if (posted.length() > 1) {
                posted.append("&");
            }
            String curr = (String) e.nextElement();
            posted.append(curr).append("=");
            posted.append(request.getParameter(curr));
        }

        return posted.toString();
    }
}