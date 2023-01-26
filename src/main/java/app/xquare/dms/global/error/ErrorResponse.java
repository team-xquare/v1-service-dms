package app.xquare.dms.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;

    public ErrorResponse(ExceptionProperty exceptionProperty) {
        this.status = exceptionProperty.getStatus();
        this.message = exceptionProperty.getMessage();
    }
}
