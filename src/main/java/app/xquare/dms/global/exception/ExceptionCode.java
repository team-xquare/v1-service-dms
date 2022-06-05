package app.xquare.dms.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    INVALID_STAY_STATUS(400, "Invalid Stay Status"),

    POINT_NOR_FOUND(404, "Point Not Found"),
    POINT_HISTORY_NOT_FOUND(404, "Point History Not Found"),
    INVALID_POINT(400, "Invalid Point"),
    STUDENT_NOT_FOUND(404, "Student Not Found"),

    NOTICE_NOT_FOUND(404, "Notice Not Found");

    private final int status;
    private final String message;
}
