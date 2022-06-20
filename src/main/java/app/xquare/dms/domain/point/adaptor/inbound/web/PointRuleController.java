package app.xquare.dms.domain.point.adaptor.inbound.web;

import app.xquare.dms.domain.point.application.port.inbound.CreatePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.DeletePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.point.application.port.inbound.UpdatePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.dto.request.PointRuleRequest;
import app.xquare.dms.domain.point.application.port.inbound.dto.response.PointListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points/rule")
public class PointRuleController {

    private final GetPointListUseCase getPointListUseCase;
    private final CreatePointRuleUseCase createPointRuleUseCase;
    private final DeletePointRuleUseCase deletePointRuleUseCase;
    private final UpdatePointRuleUseCase updatePointRuleUseCase;

    @GetMapping
    public PointListResponse pointList() {
        return getPointListUseCase.getPointList();
    }

    @PostMapping
    public void pointRule(@Valid @RequestBody PointRuleRequest request) {
        createPointRuleUseCase.createPointRule(request);
    }

    @DeleteMapping("/{point-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void pointRule(@PathVariable("point-id") String pointId) {
        deletePointRuleUseCase.deletePointRule(pointId);
    }

    @PutMapping("/{point-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void pointRule(@RequestBody PointRuleRequest request, @PathVariable("point-id") String pointId) {
        updatePointRuleUseCase.updatePointRule(request, pointId);
    }
}
