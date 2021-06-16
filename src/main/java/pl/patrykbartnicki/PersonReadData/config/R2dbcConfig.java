package pl.patrykbartnicki.PersonReadData.config;


import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Configuration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
public class R2dbcConfig{

    ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
            .option(DRIVER, "h2")
            .option(PROTOCOL, "mem")
            .option(USER, "patryk")
            .option(PASSWORD, "papryk")
            .option(DATABASE, "r2dbc:h2:mem:///testH2")
            .build();

    ConnectionFactory connectionFactory = ConnectionFactories.get(options);
    Publisher<? extends Connection> connectionPublisher = connectionFactory.create();


}
