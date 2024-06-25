package com.example.demo.doctype;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.doctype.domain.DocTypeRepository;

@Service
public class DocTypeService {

    private final DocTypeRepository docTypeRepository;

    DocTypeService(DocTypeRepository docTypeRepository) {
        this.docTypeRepository = docTypeRepository;
    }
    
    public Optional<DocType> findById(DocTypeId id) {
        return docTypeRepository.findById(id);
    }
}
