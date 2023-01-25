package app.xquare.dms.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().disable()
                .formLogin().disable()
                .cors();
        http
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()

                .antMatchers(HttpMethod.GET, "/notices").authenticated()
                .antMatchers(HttpMethod.POST, "/notices/{notice-id}").authenticated()
                .antMatchers(HttpMethod.PUT, "/notices/{notice-id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/notices/{notice-id}").authenticated()

                .antMatchers(HttpMethod.GET, "/stay").authenticated()
                .antMatchers(HttpMethod.GET, "/excel/stay").authenticated()

                .anyRequest().authenticated();
        http
                .apply(new FilterConfig(objectMapper));
    }
}
