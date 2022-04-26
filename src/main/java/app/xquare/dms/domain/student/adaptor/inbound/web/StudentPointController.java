package app.xquare.dms.domain.student.adaptor.inbound.web;

import app.xquare.dms.domain.student.application.port.inbound.*;
import app.xquare.dms.domain.student.application.port.inbound.dto.response.PointHistoryListResponse;
import app.xquare.dms.domain.student.application.port.inbound.dto.request.PointRequest;
import app.xquare.dms.domain.student.application.port.inbound.dto.response.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/points/student")
public class StudentPointController {

    private final GetStudentListUseCase getStudentListUseCase;
    private final GetPointHistoryListUseCase getPointHistoryListUseCase;
    private final GivePointUseCase givePointUseCase;
    private final DeletePointHistoryUseCase deletePointHistoryUseCase;
    private final CompleteTrainingUseCase completeTrainingUseCase;

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

    @DeleteMapping("/{student-id}/history/{history-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePointHistory(@PathVariable("history-id") String historyId, @PathVariable("student-id") String studentId) {
        deletePointHistoryUseCase.deletePointHistory(studentId, historyId);
    }

    @PostMapping("/{student-id}/training")
    public void completeTraining(
            @PathVariable("student-id") String studentId,
            @Range(min = 1, max = 3) @RequestParam("penalty_level") int penaltyLevel) {
        completeTrainingUseCase.completeTraining(studentId, penaltyLevel);
    }
}
