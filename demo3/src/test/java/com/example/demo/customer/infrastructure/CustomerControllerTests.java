package com.example.demo.customer.infrastructure;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.domain.CustomerFile;
import com.example.demo.customer.domain.CustomerId;
import com.example.demo.customer.domain.CustomerRepository;
import com.example.demo.doctype.DocTypeId;
import com.example.demo.doctype.domain.DocTypeRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@Transactional
@Rollback
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	@Rollback
	@Transactional
	@Sql(statements = {
			"INSERT INTO customer (id, name) VALUES (1, 'John Doe')",
			"INSERT INTO doc_type (id, name) VALUES (1, 'My Document Type')"
	})
	void should_create_customer() {
		System.out.println("\n\n\n\n\n"+template.getRootUri());
		var result = template
				.postForEntity("/customers/1/files",
						new CreateFileRequest("My File", new DocTypeId(1l)),
						Object.class);

		assertThat(result).isNull();
	}
}
