package com.user.service.impl;

import com.user.datamodels.ItemisedDeductions;
import com.user.datamodels.ResponseObject;
import com.user.datamodels.TaxBracket;
import com.user.datamodels.TaxFormDetails;
import com.user.datarepository.ItemisedDeductionRepository;
import com.user.datarepository.TaxBracketRepository;
import com.user.datarepository.TaxDetailsRepository;
import com.user.service.AuthorisedUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorisedServicesImpl implements AuthorisedUserServices {

    @Autowired
    TaxDetailsRepository taxDetailsRepository;

    @Autowired
    ItemisedDeductionRepository itemisedDeductionRepository;

    @Autowired
    TaxBracketRepository taxBracketRepository;

    @Override
    public ResponseObject saveTaxDetails(TaxFormDetails data) {
        TaxFormDetails res = taxDetailsRepository.save(data);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(true);
        responseObject.setData(res.getFormId());
        responseObject.setErrorMessage(null);
        return responseObject;
    }

    @Override
    public ResponseObject saveItemisedDeductionDetails(ItemisedDeductions data) {
        ItemisedDeductions res = itemisedDeductionRepository.save(data);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(true);
        responseObject.setData("saved itemised deduction details successfully");
        responseObject.setErrorMessage(null);
        return responseObject;
    }

    @Override
    public ResponseObject getAllTaxDetails(int id) {
        List<TaxFormDetails> res = taxDetailsRepository.findByUserId(id);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(true);
        responseObject.setData(res);
        responseObject.setErrorMessage(null);
        return responseObject;
    }

    @Override
    public ResponseObject getAllItemisedDeductionDetails(int id) {
        List<ItemisedDeductions> itemisedDeductionsList = itemisedDeductionRepository.findByUserId(id);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(true);
        responseObject.setData(itemisedDeductionsList);
        responseObject.setErrorMessage(null);
        return responseObject;
    }

    @Override
    public ResponseObject getTaxBracketsByStatus(String status) {
        List<TaxBracket> taxBracketList = taxBracketRepository.findByFillerStatus( status);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(true);
        responseObject.setData(taxBracketList);
        responseObject.setErrorMessage(null);
        return responseObject;
    }

    @Override
    public ResponseObject getItemisedDeductionByformId(int id) {
        ItemisedDeductions itemisedDeductions = itemisedDeductionRepository.findByFormId(id);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(true);
        responseObject.setData(itemisedDeductions);
        responseObject.setErrorMessage(null);
        return responseObject;
    }
}
