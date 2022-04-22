package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.exception.ExceptionCode;
import app.xquare.dms.global.exception.GlobalException;

public class StudentNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new StudentNotFoundException();

    private StudentNotFoundException() {
        super(ExceptionCode.STUDENT_NOT_FOUND);
    }
}
