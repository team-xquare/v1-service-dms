package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.exception.ExceptionCode;
import app.xquare.dms.global.exception.GlobalException;

public class PointNotFoundException extends GlobalException  {

    public static final GlobalException EXCEPTION = new PointNotFoundException();

    public PointNotFoundException() {
        super(ExceptionCode.POINT_NOR_FOUND);
    }
}
