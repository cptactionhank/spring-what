package com.example.demo.doctype;

import org.springframework.data.annotation.Id;

public class DocType {
    @Id
    final DocTypeId id;
    final String name;

    public DocType(DocTypeId id, String name) {
        this.id = id;
        this.name = name;
    }

    public DocTypeId id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "DocType{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
