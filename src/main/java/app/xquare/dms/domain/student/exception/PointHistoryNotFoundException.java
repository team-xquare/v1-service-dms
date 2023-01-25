package app.xquare.dms.domain.student.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class PointHistoryNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new PointHistoryNotFoundException();

    private PointHistoryNotFoundException() {
        super(GlobalErrorCode.POINT_HISTORY_NOT_FOUND);
    }
}
