package app.xquare.dms.global.error.exception;

import app.xquare.dms.global.error.ExceptionProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GlobalException extends RuntimeException {

    private final ExceptionProperty exceptionProperty;
}
