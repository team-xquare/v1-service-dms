package app.xquare.dms.domain.auth.adaptor.inbound.web;

import app.xquare.dms.global.exception.UnAuthorizedException;
import app.xquare.dms.global.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Value("${auth.id}")
    private String id;

    @Value("${auth.pw}")
    private String password;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        if(!request.getId().equals(id) || !passwordEncoder.matches(request.getPassword(), password)) {
            throw UnAuthorizedException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(tokenProvider.getToken())
                .build();
    }
}
