package com.example.demo.customer.infrastructure;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import com.example.demo.customer.infrastructure.converters.WriterCustomerFileId;
import com.example.demo.customer.infrastructure.converters.WriterCustomerId;
import com.example.demo.customer.infrastructure.converters.ReadCustomerFileId;
import com.example.demo.customer.infrastructure.converters.ReadCustomerId;

// @Configuration
public class CustomerConfiguration extends AbstractJdbcConfiguration {

    // @Override
    // protected List<Converter<?, ?>> userConverters() {
    //     return List.of(
    //             new CustomerIdToLongConverter(), new LongToCustomerIdConverter(),
    //             new CustomerFileIdToLongConverter(), new LongToCustomerFileIdConverter());
    // }
}
