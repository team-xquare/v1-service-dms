package app.xquare.dms.domain.point.adaptor.inbound.web;

import app.xquare.dms.domain.point.application.port.inbound.CreatePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.point.application.port.inbound.dto.request.PointRuleRequest;
import app.xquare.dms.domain.point.application.port.inbound.dto.response.PointListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points/rule")
public class PointRuleController {

    private final GetPointListUseCase getPointListUseCase;
    private final CreatePointRuleUseCase createPointRuleUseCase;

    @GetMapping
    public PointListResponse pointList() {
        return getPointListUseCase.getPointList();
    }

    @PostMapping
    public void pointRule(@Valid @RequestBody PointRuleRequest request) {
        createPointRuleUseCase.createPointRule(request);
    }
}
