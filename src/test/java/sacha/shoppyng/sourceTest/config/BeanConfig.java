package sacha.shoppyng.sourceTest.config;

import sacha.shoppyng.cart.Repository.CartRepository;
import sacha.shoppyng.cart.Repository.UserRepository;
import sacha.shoppyng.sourceTest.service.CartRepositoryMock;
import sacha.shoppyng.sourceTest.service.UserRepositoryMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Integration test Configuration
 */
@Profile({"productTest", "CartTest"})
@Configuration
public class BeanConfig {

    /**
     * Dans ce projet les tests peuvent pointer vers une BD embarqué initialisé via flyway par exemple
     * Etant donnes qu'on ne peut pas utiliser de BD des class Mock ont était mis en place
     */

    @Bean
    @Primary
    public UserRepository UserRepositoryMock() {
        return new UserRepositoryMock();
    }

    @Profile("productTest")
    @Bean
    @Primary
    public CartRepository CartRepositoryMock() {
        return new CartRepositoryMock();
    }

}

