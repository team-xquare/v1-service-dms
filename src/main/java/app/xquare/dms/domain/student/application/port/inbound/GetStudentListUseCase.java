package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;

public interface GetStudentListUseCase {

    StudentListResponse getStudentList();
}
