package app.xquare.dms.global.security;

import app.xquare.dms.global.error.GlobalErrorFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity builder) {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        GlobalErrorFilter globalErrorFilter = new GlobalErrorFilter(objectMapper);
        builder.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(globalErrorFilter, AuthenticationFilter.class);
    }
}
