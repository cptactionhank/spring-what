package com.example.demo.customer.infrastructure.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.customer.domain.CustomerFileId;

@Component
@ReadingConverter
public class ReadCustomerFileId implements Converter<Long, CustomerFileId> {

    @Override
    @Nullable
    public CustomerFileId convert(Long source) {
        return new CustomerFileId(source);
    }
    
}
