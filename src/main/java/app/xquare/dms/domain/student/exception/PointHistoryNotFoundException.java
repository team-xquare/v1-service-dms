package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.exception.ExceptionCode;
import app.xquare.dms.global.exception.GlobalException;

public class PointHistoryNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new PointHistoryNotFoundException();

    private PointHistoryNotFoundException() {
        super(ExceptionCode.POINT_HISTORY_NOT_FOUND);
    }
}
