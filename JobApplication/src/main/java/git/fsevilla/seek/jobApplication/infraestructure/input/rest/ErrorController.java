package git.fsevilla.seek.jobApplication.infraestructure.input.rest;

import git.fsevilla.seek.jobApplication.domain.exception.InvalidDataException;
import git.fsevilla.seek.jobApplication.domain.exception.JobApplicationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<String> notFound(JobApplicationNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> notFound(InvalidDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> anyException(Exception exception) {
        return ResponseEntity.internalServerError().body("Service unavailable: " + exception.getMessage());
    }
}
