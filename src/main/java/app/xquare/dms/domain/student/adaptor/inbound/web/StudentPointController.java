package app.xquare.dms.domain.student.adaptor.inbound.web;

import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points/student")
public class StudentPointController {

    private final GetStudentListUseCase getStudentListUseCase;

    @GetMapping
    public StudentListResponse studentList() {
        return getStudentListUseCase.getStudentList();
    }
}
