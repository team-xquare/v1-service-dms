package app.xquare.dms.domain.notice.exception;

import app.xquare.dms.global.error.GlobalErrorCode;
import app.xquare.dms.global.error.exception.GlobalException;

public class NoticeNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new NoticeNotFoundException();

    private NoticeNotFoundException() {
        super(GlobalErrorCode.NOTICE_NOT_FOUND);
    }
}
