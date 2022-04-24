package app.xquare.dms.domain.student.adaptor.inbound.web;

import app.xquare.dms.domain.student.application.port.inbound.GetPointHistoryListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointHistoryListResponse;
import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points/student")
public class StudentPointController {

    private final GetStudentListUseCase getStudentListUseCase;
    private final GetPointHistoryListUseCase getPointHistoryListUseCase;

    @GetMapping
    public StudentListResponse studentList() {
        return getStudentListUseCase.getStudentList();
    }

    @GetMapping("/{student-id}/history")
    public PointHistoryListResponse pointHistoryList(@PathVariable("student-id") String studentId) {
        return getPointHistoryListUseCase.getPointHistoryList(studentId);
    }
}
