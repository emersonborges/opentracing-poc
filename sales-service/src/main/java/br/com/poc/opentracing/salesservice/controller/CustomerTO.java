package br.com.poc.opentracing.salesservice.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerTO {
    private String name;
    private String fullName;
}
