package br.com.poc.opentracing.salesservice;

import io.opentracing.Span;
import io.opentracing.contrib.spring.web.interceptor.HandlerInterceptorSpanDecorator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RealwaveHandlerInterceptorSpanDecorator implements HandlerInterceptorSpanDecorator {

    @Override
    public void onPreHandle(HttpServletRequest httpServletRequest, Object o, Span span) {
        String tenant = httpServletRequest.getHeader("X-Tenant");
        span.setBaggageItem("tenant", tenant);
    }

    @Override
    public void onAfterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e, Span span) {

    }

    @Override
    public void onAfterConcurrentHandlingStarted(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Span span) {

    }
}
