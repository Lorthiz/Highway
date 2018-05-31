package wspa.groupproject.highway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("usr").password("{noop}usr").roles("USER");
        auth.inMemoryAuthentication()
                .withUser("ins").password("{noop}ins").roles("INSTRUCTOR");
    }

}
