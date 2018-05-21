package tech.mangosoft.ro3d.client.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
// @EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${jdbc.auth.queries.users-query}")
    private String queryUserByEmail;

    @Value("${jdbc.auth.queries.roles-query}")
    private String queryAuthoritiesByEmail;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws
    // Exception {
    // auth.jdbcAuthentication()
    // .dataSource(dataSource)
    // .usersByUsernameQuery(queryUserByEmail)
    // .authoritiesByUsernameQuery(queryAuthoritiesByEmail)
    // .passwordEncoder(bCryptPasswordEncoder);
    // }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // http.authorizeRequests()
    // .antMatchers("/").permitAll()
    // .antMatchers("/login").permitAll()
    // .antMatchers("/registration").permitAll()
    // .antMatchers("/home/**").hasAuthority("USER").anyRequest()
    // .authenticated().and().csrf().disable().formLogin()
    // .loginPage("/login").failureUrl("/login?error=true")
    // .defaultSuccessUrl("/home/users")
    // .usernameParameter("email")
    // .passwordParameter("password")
    // .and().logout()
    // .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    // .logoutSuccessUrl("/").and().exceptionHandling()
    // .accessDeniedPage("/access-denied");
    // }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }
}
