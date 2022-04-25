package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.application.port.inbound.dto.response.StudentListResponse;

public interface GetStudentListUseCase {

    StudentListResponse getStudentList();
}
