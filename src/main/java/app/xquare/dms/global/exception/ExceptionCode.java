package app.xquare.dms.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    STUDENT_NOT_FOUND(400, "Student Not Found");

    private final int status;
    private final String message;
}
