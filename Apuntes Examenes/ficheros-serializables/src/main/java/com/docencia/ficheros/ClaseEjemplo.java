package com.docencia.ficheros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClaseEjemplo {

    private static final Logger logger = LoggerFactory.getLogger(ClaseEjemplo.class);

    public ClaseEjemplo() {
        String variable = "Soy variable";
        String otra = "otra";
        logger.info("Soy un mensaje {}, y otra {}", variable, otra);
        Exception exception = new Exception("Hubo un error");
        logger.error("El mensaje que quiero {} y la exepcion", variable, exception);
    }
}
