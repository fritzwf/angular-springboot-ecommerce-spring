package com.feuersoft.ecommerce.Config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by ffeuerbacher on 5/12/2021
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Do not call the parent
        // super.configure(http);

        // protect endpoint /api/orders
        http.authorizeRequests()
                .antMatchers("/api/orders/**")
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        // Add CORS filter
        http.cors();

        // Create a friendly response body for 401's
        Okta.configureResourceServer401ResponseBody(http);

        // Disable CSRF since we are not using cookies for session tracking
        http.csrf().disable();
    }
}
