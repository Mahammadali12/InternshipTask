package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;


@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userService;
    

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{
        System.out.println("Authentication Manager 1");
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        System.out.println("Authentication Manager 2");
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
        System.out.println("Authentication Manager 3");
        return authenticationManagerBuilder.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{


        // httpSecurity.csrf().disable()
        // .authorizeRequests()
        // .requestMatchers("http://localhost:8080/Client").permitAll()
        // .anyRequest()
        // .authenticated()
        // .and()
        // .httpBasic();
        System.out.println("FIlter chain 1");

        httpSecurity.csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((authorize) -> authorize
        .requestMatchers("/register","/static/**","/form.html").permitAll()
        .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults());
        
        System.out.println("FIlter chain 2");
        

        return httpSecurity.build();
    }



    // @Bean
    // public InMemoryUserDetailsManager userDetailsService(){
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //     .username("maqa")
    //     .password("123")
    //     .roles("ADMIN")
    //     .build();
    //     return new InMemoryUserDetailsManager(user);
    // }
}
