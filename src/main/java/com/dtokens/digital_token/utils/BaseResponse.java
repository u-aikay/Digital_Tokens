package com.dtokens.digital_token.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T>{
    private HttpStatus status;
    private String message;
    private T result;
}
