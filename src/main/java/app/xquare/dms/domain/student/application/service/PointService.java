package app.xquare.dms.domain.student.application.service;

import app.xquare.dms.domain.student.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointService implements GetPointListUseCase {

    @Override
    public PointListResponse getPointList() {
        return null;
    }
}
