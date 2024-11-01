package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import com.example.demo.model.Client;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void getTest(){
		// System.out.println(restTemplate.getForEntity("http://localhost:8080/Client/1", Client.class).getStatusCode());
		// System.out.println(restTemplate.getForEntity("http://localhost:8080/Client/1", Client.class).getStatusCode());
		// System.out.println(restTemplate.getForEntity("http://localhost:8080/Client/1", Client.class).getStatusCode());
		System.out.println();
		assertThat(restTemplate.getForEntity("/Client/1", Client.class).getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
