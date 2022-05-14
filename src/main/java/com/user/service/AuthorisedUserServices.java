package com.user.service;

import com.user.datamodels.ItemisedDeductions;
import com.user.datamodels.ResponseObject;
import com.user.datamodels.TaxFormDetails;

public interface AuthorisedUserServices {
    ResponseObject saveTaxDetails(TaxFormDetails data);
    ResponseObject saveItemisedDeductionDetails(ItemisedDeductions data);
    ResponseObject getAllTaxDetails(int id);
    ResponseObject getAllItemisedDeductionDetails(int id);
    ResponseObject getTaxBracketsByStatus(String status);
    ResponseObject getItemisedDeductionByformId(int id);
}
