package app.xquare.dms.domain.stay.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class InvalidStayStatusException extends GlobalException {

    public static final GlobalException EXCEPTION = new InvalidStayStatusException();

    public InvalidStayStatusException() {
        super(GlobalErrorCode.INVALID_STAY_STATUS);
    }
}
