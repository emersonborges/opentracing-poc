package br.com.poc.opentracing.configuration;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Bean;

import static io.jaegertracing.Configuration.*;

@org.springframework.context.annotation.Configuration
public class TracerConfiguration {

    @Bean
    public Tracer jaegerTracker() {
        SenderConfiguration senderConfiguration = new SenderConfiguration()
                .withAgentHost("localhost");
        ReporterConfiguration reporterConfiguration = new ReporterConfiguration()
                .withSender(senderConfiguration);
        SamplerConfiguration samplerConfig = new SamplerConfiguration()
                .withType("const")
                .withParam(1);
        return new Configuration("service1")
                .withSampler(samplerConfig)
                .withReporter(reporterConfiguration)
                .getTracer();
    }
}
