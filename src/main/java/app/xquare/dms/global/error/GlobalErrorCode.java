package app.xquare.dms.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements ExceptionProperty {

    UNAUTHORIZED(401, "UnAuthorized"),

    INVALID_STAY_STATUS(400, "Invalid Stay Status"),

    POINT_NOR_FOUND(404, "Point Not Found"),
    POINT_HISTORY_NOT_FOUND(404, "Point History Not Found"),
    INVALID_POINT(400, "Invalid Point"),
    STUDENT_NOT_FOUND(404, "Student Not Found"),

    NOTICE_NOT_FOUND(404, "Notice Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
