package com.cardinity.task.dto;

import lombok.Data;

@Data
public class ErrorMessageDTO {
    private int code;
    private String message;

    public ErrorMessageDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
