package pl.koleszko.software.uma.application.domain.api.exception;

public class UserException extends Exception {

    private static final long serialVersionUID = -8764045497869415652L;
    private static final String MSG = "There is no user with provided Id: ";

    private Long userId;
    private String message;

    public UserException(Long userId){
        this.message = MSG + userId.toString();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
