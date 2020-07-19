package eu.mrndesign.matned.springProject.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index/**", "/index.html/**", "/usersinhell/**", "/usersinhell.html/**", "/penalties/**", "/penalties.html/**")
                    .hasAnyAuthority("ROLE_DEATH", "ROLE_UNDEAD")
                .antMatchers("/userform/**", "/userform.html/**", "/productform/**", "/productform.html/**")
                    .hasAnyAuthority("ROLE_DEATH")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("death@death.hell")
                        .password("death")
                        .roles("DEATH").build())
                .withUser(users.username("undead@undead.hell")
                        .password("undead")
                        .roles("UNDEAD").build());
    }
}
