package com.leleProperty.LeleProperty.configuration;

import com.leleProperty.LeleProperty.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig {

    private final CustomAuthenticationSuccessHandler successHandler;

    public WebSecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/",
                    "/css/**",
                    "/image/**",
                    "/music/**",
                    "/login",
                    "/registration",
                    "/api/register",
                    "/property",
                    "/api/getAllProperty",
                    "/productlist",
                    "/service",
                    "/contact",
                    "/actuator/**" // health checks if enabled
                ).permitAll()
                .requestMatchers("/us").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN", "CREATOR")
                .requestMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
                .requestMatchers("/delete/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(successHandler)
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .exceptionHandling(eh -> eh.accessDeniedPage("/403"));

        return http.build();
    }

    // CORS config to support frontend API calls
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Allow all for now
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
