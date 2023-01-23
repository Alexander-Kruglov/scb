package scb.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableAspectJAutoProxy
public class MyConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/")
                        .defaultSuccessUrl("/deliveries")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }


    //todo inMemory -> database

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> usersList = new ArrayList<>();
        usersList.add(new User(
                "Vasya", encoder.encode("vasya123"),
                List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))));
        usersList.add(new User(
                "Masha", encoder.encode("masha123"),
                List.of(new SimpleGrantedAuthority("ROLE_MANAGER"))));
        return new InMemoryUserDetailsManager(usersList);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
