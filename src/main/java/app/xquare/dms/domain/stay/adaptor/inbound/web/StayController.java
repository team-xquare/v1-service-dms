package app.xquare.dms.domain.stay.adaptor.inbound.web;

import app.xquare.dms.domain.stay.application.port.inbound.GetStayApplyListUseCase;
import app.xquare.dms.domain.stay.application.port.inbound.dto.StayApplyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stay")
public class StayController {

    private final GetStayApplyListUseCase getStayApplyListUseCase;

    @GetMapping
    public StayApplyListResponse stay() {
        return getStayApplyListUseCase.getStayApplyList();
    }
}
