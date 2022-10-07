package app.xquare.dms.domain.auth.adaptor.inbound.web;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponse {

    private final String accessToken;
}
