package app.xquare.dms.domain.point.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class PointNotFoundException extends GlobalException  {

    public static final GlobalException EXCEPTION = new PointNotFoundException();

    private PointNotFoundException() {
        super(GlobalErrorCode.POINT_NOR_FOUND);
    }
}
