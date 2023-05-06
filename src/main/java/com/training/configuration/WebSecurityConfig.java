package com.training.configuration;

import com.training.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find Account in database
        // And setting PasswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers("/login", "/logout").permitAll();

        // page requires login as ROLE_LEADER or ROLE_ADMIN or ROLE_SUPPLIER
        http.authorizeRequests().antMatchers("/index", "/products", "/order-list-manage").access("hasAnyRole('ROLE_LEADER', 'ROLE_ADMIN', 'ROLE_SUPPLIER')");

        // page requires login as ROLE_LEADER or ROLE_ADMIN
        http.authorizeRequests().antMatchers("/post-manage", "/post-manage/approved/{id}", "/post-manage/rejected/{id}", "/news", "/news/push/{id}").access("hasAnyRole('ROLE_LEADER','ROLE_ADMIN')");

        // For only ROLE_SUPPLIER
        http.authorizeRequests().antMatchers("/add-product", "/save-product", "/edit-product/{id}", "/save-edit-product", "/delete-product/{id}", "/delete-category/{id}", "/feedback", "/answer-feedback").access("hasRole('ROLE_SUPPLIER')");

        // For ROLE_ADMIN only
        http.authorizeRequests().antMatchers("/accounts","/create-account","/create-account-form", "/update-account", "/update-account-form/{id}", "/delete-account/{id}").access("hasRole('ROLE_ADMIN')");

        // When the user has logged in as XX
        // But access a page that requires role YY
        // AccessDeniedException will be thrown
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Config for Login form
        http.authorizeRequests().and().formLogin()
                // Submit URL of login page
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout");

        // Config Remember Me
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(1*24*60*60);

    }

    //Token stored in Table (Persistent_Logins)
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    //Token stored in Memory (Of Web Server)
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
//        return memory;
//    }

}
