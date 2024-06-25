package com.example.demo.customer.infrastructure.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import com.example.demo.customer.domain.CustomerFileId;

@Component
@WritingConverter
public class WriterCustomerFileId implements Converter<CustomerFileId, Long> {

    @Override
    public Long convert(CustomerFileId source) {
        return source.id();
    }
   
}
