package app.xquare.dms.global.exception;

public class UnAuthorizedException extends GlobalException {

    public static final GlobalException EXCEPTION = new UnAuthorizedException();

    private UnAuthorizedException() {
        super(ExceptionCode.UNAUTHORIZED);
    }
}
