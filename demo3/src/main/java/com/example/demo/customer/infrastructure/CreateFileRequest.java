package com.example.demo.customer.infrastructure;

import com.example.demo.doctype.DocTypeId;

public record CreateFileRequest(String name, DocTypeId docTypeId) {}
