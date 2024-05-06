package com.WebsiteDaiHocDienTu.config;

import com.WebsiteDaiHocDienTu.auth.userDetials.CustomUserDetails;
import com.WebsiteDaiHocDienTu.enums.RolesEnum;
import com.WebsiteDaiHocDienTu.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityWebConfiguration {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Bean
//    UserDetailsService userDetailsService(){
//        return (username ->
//            new CustomUserDetails(userRepository.findOneByUserName(username).orElseThrow(()-> new NullPointerException("User name not fount")))
//        );
//    }
//
//    @Bean
//    AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
//        return authenticationManagerBuilder.build();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("" +
                "select user_name, password, state from user where user_name=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("" +
                "select user.user_name, role.ten \n" +
                "from user \n" +
                "inner join role_user \n" +
                "on user.id=role_user.user_id \n" +
                "inner join role \n" +
                "on role_user.role_id = role.id \n" +
                "where user_name=?;");

        return  jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                    auth
                            .requestMatchers("/home/**").authenticated()
                            .requestMatchers("/sinhvien/**").hasRole(RolesEnum.SV.name())
                            .requestMatchers("/gianvien/**").hasRole(RolesEnum.GV.name())
                            .requestMatchers("/quanlykhoa/**").hasAnyRole(RolesEnum.QLK.name(), RolesEnum.ADMIN.name())
                            .requestMatchers("/admin/**").hasAnyRole(RolesEnum.ADMIN.name())
                            .anyRequest().authenticated()
                        )
                .formLogin(form-> form
                        .permitAll()
                        .defaultSuccessUrl("/home")
                        .loginPage("/login")
                        .usernameParameter("user_name")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login")

                )
                .logout(logout->
                        logout
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                                .clearAuthentication(true)
                                .logoutSuccessUrl("/login")
                );
        return http.build();
    };

}
