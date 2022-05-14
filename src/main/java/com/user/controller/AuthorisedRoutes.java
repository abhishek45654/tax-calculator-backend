package com.user.controller;


import com.user.datamodels.ItemisedDeductions;
import com.user.datamodels.ResponseObject;
import com.user.datamodels.TaxFormDetails;
import com.user.service.AuthorisedUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthorisedRoutes {

    @Autowired
    AuthorisedUserServices authorisedUserServices;

    @PostMapping("/save/taxdetails")
    public ResponseEntity<ResponseObject> saveTaxDetails(@RequestBody TaxFormDetails taxFormDetails) {
        ResponseObject responseObject = authorisedUserServices.saveTaxDetails(taxFormDetails);
        return ResponseEntity.ok(responseObject);
    }

    @PostMapping("/save/itemdeduction")
    public ResponseEntity<ResponseObject> saveItemisedDeductionDetails(@RequestBody ItemisedDeductions itemisedDeductions) {
        ResponseObject responseObject = authorisedUserServices.saveItemisedDeductionDetails(itemisedDeductions);
        return ResponseEntity.ok(responseObject);
    }
    @GetMapping("/get/taxdetails/{id}")
    public ResponseEntity<ResponseObject> getAllTaxDetails(@PathVariable(value="id") int id) {
        ResponseObject responseObject = authorisedUserServices.getAllTaxDetails(id);
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/get/allitemisedtaxdetails/{id}")
    public ResponseEntity<ResponseObject> getAllItemisedDeductionDetails(@PathVariable(value="id") int id) {
        ResponseObject responseObject = authorisedUserServices.getAllItemisedDeductionDetails(id);
        return ResponseEntity.ok(responseObject);
    }

    @PostMapping("/get/taxbracket")
    public ResponseEntity<ResponseObject> getTaxBracketsByStatus(@RequestBody String status) {
        ResponseObject responseObject = authorisedUserServices.getTaxBracketsByStatus(status);
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/get/itemiseddeductionbyiformid/{id}")
    public ResponseEntity<ResponseObject> getItemisedDeductionByformId(@PathVariable(value="id") int id) {
        ResponseObject responseObject = authorisedUserServices.getItemisedDeductionByformId(id);
        return ResponseEntity.ok(responseObject);
    }

}
