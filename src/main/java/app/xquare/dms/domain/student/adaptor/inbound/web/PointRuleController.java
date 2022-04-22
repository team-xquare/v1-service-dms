package app.xquare.dms.domain.student.adaptor.inbound.web;

import app.xquare.dms.domain.student.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points/rule")
public class PointRuleController {

    private final GetPointListUseCase getPointListUseCase;

    @GetMapping
    public PointListResponse pointList() {
        return getPointListUseCase.getPointList();
    }
}
