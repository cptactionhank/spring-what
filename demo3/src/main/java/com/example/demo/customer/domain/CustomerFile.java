package com.example.demo.customer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import com.example.demo.doctype.DocType;
import com.example.demo.doctype.DocTypeId;

public class CustomerFile {
        @Id
        final CustomerFileId id;
        final String name;
        final AggregateReference<DocType, DocTypeId> docType;

        public CustomerFile(CustomerFileId id, String name, AggregateReference<DocType, DocTypeId> docType) {
                this.id = id;
                this.name = name;
                this.docType = docType;
        }

        public CustomerFileId id() {
                return id;
        }

        public String name() {
                return name;
        }

        public AggregateReference<DocType, DocTypeId> docType() {
                return docType;
        }

        @Override
        public String toString() {
                return "CustomerFile{" + "id=" + id + ", name='" + name + '\'' + ", docType=" + docType + '}';
        }
}
