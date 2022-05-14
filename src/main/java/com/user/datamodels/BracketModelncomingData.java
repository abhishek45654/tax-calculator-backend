package com.user.datamodels;

import lombok.Data;

@Data
public class BracketModelncomingData {
    private int incomeLowerLimit;
    private int incomeUpperLimit;
    private int taxRate;
    private String status;
    private int standardDeduction;
}
