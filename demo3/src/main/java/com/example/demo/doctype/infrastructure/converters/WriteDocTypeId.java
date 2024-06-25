package com.example.demo.doctype.infrastructure.converters;

import java.sql.JDBCType;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.mapping.JdbcValue;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.doctype.DocTypeId;

@Component
@WritingConverter
public class WriteDocTypeId implements Converter<DocTypeId, JdbcValue> {

    @Override
    @Nullable
    public JdbcValue convert(DocTypeId source) {
        return JdbcValue.of(source.id(), JDBCType.BIGINT);
    }
}
