package app.xquare.dms.domain.auth.adaptor.inbound.web;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotNull()
    private String id;

    @NotNull()
    private String password;

}
