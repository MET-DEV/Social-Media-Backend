package com.metsoft.erpapp.api.controller.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessDataResponse<T>{
    private boolean status;
    private String message;
    private T data;
}
