package org.mcalvot.formacion.ConsumingARestfulWebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingARestfulWebServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(Aplicacion.class);


	public static void main(String[] args) {
		SpringApplication.run(ConsumingARestfulWebServiceApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

		return args -> {
			log.info("antes de ejecutar cliente REST");

			Value citar = restTemplate.getForObject(
					"http://localhost:8080/saludo?nombre=Maria", Value.class);

			log.info(citar.toString());

		};


	}


	/*
		@Bean

	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		log.info("estoy en el metodo run");

		return args -> {
			log.info("antes de ejecutar cliente REST");

			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

			if (quote != null)
			{
				log.info(quote.getValue().getContent());
				log.info(quote.toString());
			}


		};
	}
*/
}
