package com.onyxx.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class LogFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    MDC.put("user", request.getHeader("username"));
    Enumeration<String> headerNames = request.getHeaderNames();
    Map<String, String> headerMap = new HashMap<>();
    while (headerNames.hasMoreElements()) {
      String headerKey = headerNames.nextElement();
      String headerValue = request.getHeader(headerKey);
      headerMap.put(headerKey, headerValue);
    }
    log.info("Received request: {} {} from {}", request.getMethod(), request.getRequestURI(), headerMap);
    chain.doFilter(request, response);
    log.info("Sent response: {} {} with status {}", request.getMethod(), request.getRequestURI(), response.getStatus());
    MDC.clear();
  }
}
