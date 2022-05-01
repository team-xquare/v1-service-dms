package app.xquare.dms.domain.stay.exception;

import app.xquare.dms.global.exception.ExceptionCode;
import app.xquare.dms.global.exception.GlobalException;

public class InvalidStayStatusException extends GlobalException {

    public static final GlobalException EXCEPTION = new InvalidStayStatusException();

    public InvalidStayStatusException() {
        super(ExceptionCode.INVALID_STAY_STATUS);
    }
}
