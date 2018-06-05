package br.com.poc.orders.configuration;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import static io.jaegertracing.Configuration.*;

@org.springframework.context.annotation.Configuration
public class TracerConfiguration {

    @Bean
    public Tracer jaegerTracer(@Value("${tracer.host}") String tracerHost,
                                @Value("${spring.application.name}") String applicationName) {
        SenderConfiguration senderConfiguration = new SenderConfiguration()
                .withAgentHost(tracerHost);
        ReporterConfiguration reporterConfiguration = new ReporterConfiguration()
                .withSender(senderConfiguration);
        SamplerConfiguration samplerConfig = new SamplerConfiguration()
                .withType("const")
                .withParam(1);
        return new Configuration(applicationName)
                .withSampler(samplerConfig)
                .withReporter(reporterConfiguration)
                .getTracer();
    }
}
