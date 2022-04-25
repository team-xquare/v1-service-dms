package app.xquare.dms.domain.student.application.port.inbound.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointRequest {

    @NotBlank(message = "'point_id'를 입력해주세요")
    private String pointId;
}
