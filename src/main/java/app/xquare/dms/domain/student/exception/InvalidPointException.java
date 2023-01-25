package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class InvalidPointException extends GlobalException {

    public static final GlobalException EXCEPTION = new InvalidPointException();

    private InvalidPointException() {
        super(GlobalErrorCode.INVALID_POINT);
    }
}
