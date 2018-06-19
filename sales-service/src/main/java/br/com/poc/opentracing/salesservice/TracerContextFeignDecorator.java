package br.com.poc.opentracing.salesservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Response;
import feign.opentracing.FeignSpanDecorator;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class TracerContextFeignDecorator implements FeignSpanDecorator {

    private final Tracer tracer;
    private final ObjectMapper objectMapper;

    public TracerContextFeignDecorator(Tracer tracer, ObjectMapper objectMapper) {
        this.tracer = tracer;
        this.objectMapper = objectMapper;
    }

    @Override
    public void onRequest(Request request, Request.Options options, Span span) {
        tracer.activeSpan().log(String.format("body: %s", new String(request.body(), Charset.forName("UTF-8"))));
    }

    @Override
    public void onResponse(Response response, Request.Options options, Span span) {
        tracer.activeSpan().log(response.body().toString());
    }

    @Override
    public void onError(Exception e, Request request, Span span) {

    }
}
