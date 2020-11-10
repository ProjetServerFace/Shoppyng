package arval.shoppyng.sourceTest.config;

import arval.shoppyng.cart.Repository.CartRepository;
import arval.shoppyng.cart.Repository.UserRepository;
import arval.shoppyng.security.JwtSecurityConfigurer;
import arval.shoppyng.security.JwtTokenProvider;
import arval.shoppyng.sourceTest.service.CartRepositoryMock;
import arval.shoppyng.sourceTest.service.UserRepositoryMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

