package com.example.demo.doctype.infrastructure.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.doctype.DocTypeId;

@Component
@ReadingConverter
public class ReadDocTypeId2 implements Converter<String, DocTypeId> {

    @Override
    @Nullable
    public DocTypeId convert(String source) {
        return new DocTypeId(Long.valueOf(source));
    }
}
