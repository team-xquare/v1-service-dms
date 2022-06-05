package app.xquare.dms.domain.notice.exception;

import app.xquare.dms.global.exception.ExceptionCode;
import app.xquare.dms.global.exception.GlobalException;

public class NoticeNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new NoticeNotFoundException();

    private NoticeNotFoundException() {
        super(ExceptionCode.NOTICE_NOT_FOUND);
    }
}
