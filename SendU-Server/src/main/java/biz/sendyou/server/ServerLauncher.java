package biz.sendyou.server;

import javassist.NotFoundException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by parkjaesung on 2016. 8. 31..
 */

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan
@ComponentScan
@PropertySource("config.properties")
public class ServerLauncher {

    public static void main(String[] args) throws NotFoundException {

        org.springframework.boot.SpringApplication.run(ServerLauncher.class);
    }

}
