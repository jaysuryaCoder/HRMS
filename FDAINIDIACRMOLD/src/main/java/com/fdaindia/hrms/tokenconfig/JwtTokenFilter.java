//package com.fdaindia.hrms.tokenconfig;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//@Order(1)
//public class JwtTokenFilter implements Filter {
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    private static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        logger.info("Filter initiated");
//        String url = httpRequest.getRequestURI();
//        logger.info("Request URL: {}", url);
//
//        // Skip the filter for specific URLs
//        if (shouldSkipFilter(url)) {
//            chain.doFilter(request, response); // Skip the filter chain
//            return;
//        }
//
//        // Extract JWT token from the Authorization header
//        String header = httpRequest.getHeader("Authorization");
//        logger.info("Authorization Header: {}", header);
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.replace("Bearer ", "");
//            logger.info("Extracted Token: {}", token);
//
//            try {
//                boolean tokenValid = false;
//                if (url.startsWith("/kendra/")) {
//                    tokenValid = jwtTokenUtil.validateToken(token, 2);
//                } else if (url.startsWith("/user/")) {
//                    tokenValid = jwtTokenUtil.validateToken(token, 1);
//                } else if (url.startsWith("/Hrms/")) {
//                    tokenValid = jwtTokenUtil.validateToken(token, 3);
//                }
//
//                if (!tokenValid) {
//                    logger.info("Token is invalid");
//                    httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                } else {
//                    logger.info("Token is valid");
//                    chain.doFilter(request, response);
//                }
//            } catch (ExpiredJwtException e) {
//                logger.error("Token has expired", e);
//                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            } catch (Exception e) {
//                logger.error("Token validation error", e);
//                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            }
//        } else {
//            logger.info("Authorization header is missing or doesn't start with Bearer");
//            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
//
//    private boolean shouldSkipFilter(String url) {
//        // Add URLs for which the filter should be skipped
//        List<String> urls = Arrays.asList(
//            "/user/registerforcard", 
//            "/user/loginforcard", 
//            "/kendra/login",
//            "/kendra/registration", 
//            "/Hrms/emp/hrmslogin", 
//            "/Hrms/emp/registration",
//            "/Hrms/emp/login",
//            "/Hrms/emp/forgot-password",
//            "/Hrms/emp/reset-password"
//        );
//        return urls.contains(url);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization code, if needed
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup code, if needed
//    }
//}
