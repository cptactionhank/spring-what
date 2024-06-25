package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

@Configuration
public class DemoConfiguration extends AbstractJdbcConfiguration {

    @Autowired
    List<Converter<?, ?>> additionalConverters;
    
    @Override
    protected List<Converter<?, ?>> userConverters() {
        return additionalConverters;
    }
}
