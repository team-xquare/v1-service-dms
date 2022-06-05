package app.xquare.dms.domain.notice.application.port.inbound.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateNoticeRequest {

    @NotBlank(message = "제목 입력해주세요")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "내용을 입력해주세요")
    private String content;
}
