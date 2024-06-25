package com.example.demo;

import com.example.demo.customer.domain.Customer;
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

	// @Autowired
	// private TestRestTemplate template;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DocTypeRepository docTypeRepository;

	// @Test
	// @Rollback
	// @Transactional
	// @Sql(statements = "INSERT INTO customer (name) VALUES ('John Doe')")
	// void should_return_list_of_customers() {
	// var customers = controller.findAll();
	// assertThat(customers).hasSize(1);

	// assertThat(controller.findById(new CustomerId(1l))).isNotNull();
	// }

	@Test
	@Rollback
	@Transactional
	@Sql(statements = "INSERT INTO doc_type (name) VALUES ('My Document Type')")
	void should_create_customer() {
		// assertThat(conversionService.canConvert(Long.class, DocTypeId.class)).isTrue();
		// assertThat(conversionService.canConvert(DocTypeId.class, Long.class)).isTrue();

		var types = docTypeRepository.findAll();

		var entity = new Customer(null, "Jane Doe", new HashSet<>());
		entity.addFile("file1", types.get(0).id());
		entity.addFile("file2", types.get(0).id());

		var customer = customerRepository.save(entity);
		assertThat(customer).isNotNull();
		assertThat(customer.id().id()).isEqualTo(1);
		assertThat(customer.name()).isEqualTo("Jane Doe");
		assertThat(customer.files()).hasSize(2);

		System.out.println("\n\n\n\nCustomer: " + customer + "\n\n\n\n");

		var customers = customerRepository.findAll();
		assertThat(customers).hasSize(1);
		assertThat(customers.get(0).id().id()).isEqualTo(1);

		var file = customers.get(0).files().iterator().next();
		assertThat(file.docType().getId().id()).isEqualTo(1);

		var docType = docTypeRepository.findById(file.docType().getId()).orElseThrow();
		assertThat(docType.id().id()).isEqualTo(1);
	}
}
