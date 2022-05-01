package app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.mapper.StayStatusMapper;
import app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.repository.StayStatusRepository;
import app.xquare.dms.domain.stay.application.port.outbound.GetStayStatusListPort;
import app.xquare.dms.domain.stay.domain.StayStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StayPersistenceAdaptor implements GetStayStatusListPort {

    private final StayStatusRepository stayStatusRepository;

    private final StayStatusMapper stayStatusMapper;

    @Override
    public List<StayStatus> getStayStatusList() {
        return stayStatusRepository.findAll().stream()
                .map(stayStatusMapper::mapToStayStatus)
                .collect(Collectors.toList());
    }
}
