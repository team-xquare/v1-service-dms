package app.xquare.dms.domain.stay.application.port.outbound;

import app.xquare.dms.domain.stay.domain.StayStatus;

import java.util.List;

public interface GetStayStatusListPort {

    List<StayStatus> getStayStatusList();
}
