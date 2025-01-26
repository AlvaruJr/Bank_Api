package ControllerServices.Infraststructure.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

public class UnprrcessabeEntity extends RuntimeException {
    public UnprrcessabeEntity(String message) {
        super(message);
    }

}
