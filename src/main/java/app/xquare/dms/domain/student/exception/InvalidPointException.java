package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.exception.ExceptionCode;
import app.xquare.dms.global.exception.GlobalException;

public class InvalidPointException extends GlobalException {

    public static final GlobalException EXCEPTION = new InvalidPointException();

    private InvalidPointException() {
        super(ExceptionCode.INVALID_POINT);
    }
}
