package com.example.demo.customer.infrastructure.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.customer.domain.CustomerId;

@Component
@ReadingConverter
public class ReadCustomerId implements Converter<Long, CustomerId> {

    @Override
    @Nullable
    public CustomerId convert(Long source) {
        return new CustomerId(source);
    }
    
}
