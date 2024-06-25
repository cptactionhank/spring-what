package com.example.demo.doctype.infrastructure.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.doctype.DocTypeId;

@Component
@ReadingConverter
public class ReadDocTypeId implements Converter<Long, DocTypeId> {

    @Override
    @Nullable
    public DocTypeId convert(Long source) {
        return new DocTypeId(source);
    }
}
