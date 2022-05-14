package com.user.datamodels;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="itemised_deductions")
public class ItemisedDeductions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemiseFormId;
    private int formId;
    private int userId;
    private int propertyTaxes;
    private int earnedInterests;
    private int charity;
    private int stateLocalTaxes  ;
    private int educationalExpenses;
    private int unreimbursedMedicalBills;
    private int previousTaxReturns;
    private int others;
}
