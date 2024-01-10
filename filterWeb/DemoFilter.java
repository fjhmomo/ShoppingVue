//package com.example.demo.FilterWeb;
//
//import com.example.demo.utils.JwtUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@ServletComponentScan
//@Slf4j
//@WebFilter(urlPatterns = "/*")
//public class DemoFilter implements Filter {
//    @Override //初始化方法, 只调用一次
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("666");
//    }
//
//    @Override //拦截到请求之后调用, 调用多次
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String url=req.getRequestURL().toString();
//
//        if(url.contains("mycartxxx")){
//            String jwt=req.getHeader("jwtToken");
//            System.out.println(jwt);
//            if((!StringUtils.hasLength(jwt))||jwt==null){
//                log.info("没有令牌");
//                return;
//            }
//            log.info("没有结束");
//            try{
//                JwtUtils.parseJWT(jwt);
//            }catch(Exception e){
//                log.info("解析失败");
//                return;
//            }
//            log.info("合法");
//            chain.doFilter(request,response);
//        }
//        }
//
//
//
//    @Override //销毁方法, 只调用一次
//    public void destroy() {
//        System.out.println("destroy 销毁方法执行了");
//    }
//}