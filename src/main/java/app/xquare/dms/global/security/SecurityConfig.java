package app.xquare.dms.global.security;

import app.xquare.dms.domain.user.role.UserRole;
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

    private static final String DORMITORY = "ROLE_" + UserRole.DOR.name();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().disable()
                .formLogin().disable()
                .cors();
        http
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/dms/notices").hasAnyRole(DORMITORY)
                .antMatchers(HttpMethod.POST, "/dms/notices/{notice-id}").hasAnyRole(DORMITORY)
                .antMatchers(HttpMethod.PUT, "/dms/notices/{notice-id}").hasAnyRole(DORMITORY)
                .antMatchers(HttpMethod.DELETE, "/dms/notices/{notice-id}").hasAnyRole(DORMITORY)

                .antMatchers(HttpMethod.GET, "/dms/stay").hasAnyRole(DORMITORY)
                .antMatchers(HttpMethod.GET, "/dms/excel/stay").hasAnyRole(DORMITORY)

                .anyRequest().authenticated();
        http
                .apply(new FilterConfig(objectMapper));
    }
}
