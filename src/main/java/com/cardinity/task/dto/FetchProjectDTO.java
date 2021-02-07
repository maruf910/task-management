package com.cardinity.task.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class FetchProjectDTO {
    @NotNull
    private String userName;
}
