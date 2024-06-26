package com.example.demo.customer.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.jdbc.Sql;

import com.example.demo.doctype.DocTypeId;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	@Sql(statements = {
			"INSERT INTO customer (id, name) VALUES (1, 'John Doe')",
			"INSERT INTO doc_type (id, name) VALUES (1, 'My Document Type')"
	})
	void should_create_customer() {
		var result = template.postForEntity(
				"/customers/1/files",
				new CreateFileRequest("My Document 1", new DocTypeId(1l)),
				Object.class);

		assertThat(result.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
	}
}
