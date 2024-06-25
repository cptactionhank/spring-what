package com.example.demo.doctype.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.doctype.DocType;
import com.example.demo.doctype.DocTypeId;

@Repository
public interface DocTypeRepository extends ListCrudRepository<DocType, DocTypeId>{}
