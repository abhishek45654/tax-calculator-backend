package com.user.datamodels;

import lombok.Data;

@Data
public class ResponseObject {
    boolean success;
    Object data;
    String errorMessage;
}
