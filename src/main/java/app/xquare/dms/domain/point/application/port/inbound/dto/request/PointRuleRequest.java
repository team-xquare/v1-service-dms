package app.xquare.dms.domain.point.application.port.inbound.dto.request;

import lombok.*;

import javax.validation.constraints.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointRuleRequest {

    @NotNull
    @Min(-100)
    @Max(100)
    private Integer point;

    @NotBlank
    @Size(min = 1, max = 255)
    private String reason;

    @NotNull
    private Boolean type;
}
