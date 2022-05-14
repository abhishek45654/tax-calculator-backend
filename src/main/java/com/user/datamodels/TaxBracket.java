package com.user.datamodels;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tax_bracket")
public class TaxBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bracketId;
    private int incomeLowerLimit;
    private int incomeUpperLimit;
    private int incomeRange;
    private int maxTax;
    private int taxRate;
    private String fillerStatus;
    private int standardDeduction;
}
