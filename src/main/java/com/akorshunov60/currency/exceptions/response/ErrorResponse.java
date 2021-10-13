package com.akorshunov60.currency.exceptions.response;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class ErrorResponse {

    private String message;
}
