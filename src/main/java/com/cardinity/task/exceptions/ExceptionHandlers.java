package com.cardinity.task.exceptions;

import com.cardinity.task.dto.ErrorMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlers {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ExceptionHolders.GeneralServerException.class)
    public ErrorMessageDTO handleGeneralServerException(final ExceptionHolders.GeneralServerException ex) {
        return new ErrorMessageDTO(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(ExceptionHolders.InvalidRequestException.class)
    public ErrorMessageDTO handleInvalidRequestException(final ExceptionHolders.InvalidRequestException ex) {
        return new ErrorMessageDTO(ex.getCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ExceptionHolders.ResourceNotFoundException.class)
    public ErrorMessageDTO handleResourceNotFoundException(final ExceptionHolders.ResourceNotFoundException ex) {
        return new ErrorMessageDTO(ex.getCode(), ex.getMessage());
    }

}