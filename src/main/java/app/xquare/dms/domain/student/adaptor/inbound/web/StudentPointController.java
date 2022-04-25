package app.xquare.dms.domain.student.adaptor.inbound.web;

import app.xquare.dms.domain.student.application.port.inbound.GetPointHistoryListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.GivePointUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointHistoryListResponse;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointRequest;
import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points/student")
public class StudentPointController {

    private final GetStudentListUseCase getStudentListUseCase;
    private final GetPointHistoryListUseCase getPointHistoryListUseCase;
    private final GivePointUseCase givePointUseCase;

    @GetMapping
    public StudentListResponse studentList() {
        return getStudentListUseCase.getStudentList();
    }

    @GetMapping("/{student-id}/history")
    public PointHistoryListResponse pointHistoryList(@PathVariable("student-id") String studentId) {
        return getPointHistoryListUseCase.getPointHistoryList(studentId);
    }

    @PostMapping("/{student-id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void givePoint(@PathVariable("student-id") String studentId, @Valid @RequestBody PointRequest request) {
        givePointUseCase.givePoint(studentId, request);
    }
}
