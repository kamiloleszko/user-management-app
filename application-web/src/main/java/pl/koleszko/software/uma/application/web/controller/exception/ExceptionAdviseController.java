package pl.koleszko.software.uma.application.web.controller.exception;

import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.UUID;

@RestControllerAdvice
public class ExceptionAdviseController {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdviseController.class);

    @ApiResponse(code = 500, message = "Internal error due to unexpected runtime exception")
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionDto> handleInternalServerError(HttpServletRequest request, Exception ex){
        String errorUuid = UUID.randomUUID().toString();
        logException(request, ex, "Internal error due to unexpected runtime exception", errorUuid);
        return new ResponseEntity<>(ApiExceptionDto.of(ex.toString(), ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ApiResponse(code = 406, message = "no user Id")
    @ResponseBody
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiExceptionDto> handleWrongUserIdException(HttpServletRequest request, Exception ex)  {
        String errorUuid = UUID.randomUUID().toString();
        logException(request, ex, "Wrong user id exception", errorUuid);
        return new ResponseEntity<>(ApiExceptionDto.of(ex.toString(), ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ApiResponse(code = 406, message = "hibernate validation exception")
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiExceptionDto> handleValidationException(HttpServletRequest request, Exception ex)  {
        String errorUuid = UUID.randomUUID().toString();
        logException(request, ex, "Hibernate validation exception", errorUuid);
        return new ResponseEntity<>(ApiExceptionDto.of(ex.toString(), ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ApiResponse(code = 406, message = "Json parser exception")
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiExceptionDto> handleJsonParserException(HttpServletRequest request, Exception ex)  {
        String errorUuid = UUID.randomUUID().toString();
        logException(request, ex, "Json parser validation exception", errorUuid);
        return new ResponseEntity<>(ApiExceptionDto.of(ex.toString(), ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    private void logException(HttpServletRequest request, Exception ex, String logInfo, String errorCode){
        LOG.info(logInfo, request.getPathInfo());
        LOG.error("Unexpected Exception with code: " + errorCode, ex);
    }
}