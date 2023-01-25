package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class StudentNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new StudentNotFoundException();

    private StudentNotFoundException() {
        super(GlobalErrorCode.STUDENT_NOT_FOUND);
    }
}
