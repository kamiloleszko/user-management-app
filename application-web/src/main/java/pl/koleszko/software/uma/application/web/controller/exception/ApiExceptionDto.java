package pl.koleszko.software.uma.application.web.controller.exception;

import java.io.Serializable;

public class ApiExceptionDto implements Serializable {

    private String errorCode;
    private String errorMessage;

    public ApiExceptionDto() {
    }

    static ApiExceptionDto of(String errorCode, String errorMessage){
        return new ApiExceptionDto(errorCode, errorMessage);
    }

    private ApiExceptionDto(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
