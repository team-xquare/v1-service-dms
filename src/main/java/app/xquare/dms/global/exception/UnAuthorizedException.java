package app.xquare.dms.global.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class UnAuthorizedException extends GlobalException {

    public static final GlobalException EXCEPTION = new UnAuthorizedException();

    private UnAuthorizedException() {
        super(GlobalErrorCode.UNAUTHORIZED);
    }
}
