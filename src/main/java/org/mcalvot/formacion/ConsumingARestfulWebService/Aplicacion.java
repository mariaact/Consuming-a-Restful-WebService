package org.mcalvot.formacion.ConsumingARestfulWebService;

import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class Aplicacion {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Aplicacion.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    }
}
