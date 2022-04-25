package app.xquare.dms.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    POINT_NOR_FOUND(404, "Point Not Found"),
    STUDENT_NOT_FOUND(404, "Student Not Found");

    private final int status;
    private final String message;
}
