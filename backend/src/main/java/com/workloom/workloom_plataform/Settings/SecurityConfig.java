package com.workloom.workloom_plataform.Settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*
         * http
         * .authorizeHttpRequests(authorizeRequests ->
         * authorizeRequests
         * .requestMatchers("/public/**", "/client/clients").permitAll()
         * .anyRequest().authenticated()
         * )
         * .httpBasic(withDefaults())
         * .csrf(csrf -> csrf.disable())
         * .exceptionHandling(exceptionHandling ->
         * exceptionHandling
         * .authenticationEntryPoint((request, response, authException) -> {
         * response.sendError(401, "Unauthorized");
         * })
         * );
         */

       http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/**").permitAll()  
            )
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())
            .securityContext(security -> security.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .anonymous(anonymous -> anonymous.disable())
            ;
        

        return http.build();
    }

    /*
     * @Bean
     * public UserDetailsService userDetailsService() {
     * return new InMemoryUserDetailsManager(
     * User.withUsername("user")
     * .password("{noop}password")
     * .roles("USER")
     * .build()
     * );
     * }
     */
}
