package com.metsoft.erpapp.service.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> extends  Response{
    private boolean status;
    private String message;

}
