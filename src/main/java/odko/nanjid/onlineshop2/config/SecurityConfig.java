package odko.nanjid.onlineshop2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, 'true' as enabled FROM user WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, 'ROLE_' || UPPER(user_type) FROM user WHERE email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/buyer/**").hasAuthority("ROLE_BUYER")
                .antMatchers("/seller/**").hasAuthority("ROLE_SELLER")
                .antMatchers("/**", "/h2-console/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/account/login")
                .failureUrl("/account/login-error")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
                .and()
                .rememberMe()
                .rememberMeParameter("keepMe")
                .rememberMeCookieName("keepMe")
                .tokenValiditySeconds(86400).tokenRepository(tokenRepository())
                .and()
                .logout()
                .logoutUrl("/account/logout")
                .logoutSuccessUrl("/account/login?logout=true")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/error-403");

        //Those two settings below is to enable access h2 database via browser
        //http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        return jdbcTokenRepositoryImpl;
    }

}
