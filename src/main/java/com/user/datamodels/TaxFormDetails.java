package com.user.datamodels;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="tax_details")
public class TaxFormDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formId;
    private int userId;
    private String fillerStatus;
    private int age ;
    private int grossAnnualIncome;
    private String deductionType;
    private int iraContribution;
    private int contribution_401 ;
    private int  withheld ;
    private int taxCredit ;
    @CreationTimestamp
    private Date timeStamp;
}
