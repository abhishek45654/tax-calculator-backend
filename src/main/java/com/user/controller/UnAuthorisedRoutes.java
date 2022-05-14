package com.user.controller;


import com.user.datamodels.BracketModelncomingData;
import com.user.datamodels.LoginDataModel;
import com.user.datamodels.ResponseObject;
import com.user.datamodels.SignUpModel;
import com.user.datamodels.TaxBracket;
import com.user.service.UnAuthorisedUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UnAuthorisedRoutes {

    @Autowired
    private UnAuthorisedUserServices unAuthorisedUserServices;

    @GetMapping("/")
    public ResponseEntity<String> checkBackendStatus() {
        return ResponseEntity.ok("Backend is working fine");
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody LoginDataModel data) {
        ResponseObject res = unAuthorisedUserServices.loginService(data);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseObject> signUp(@RequestBody SignUpModel data) {
        ResponseObject res = unAuthorisedUserServices.signUpService(data);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/update/taxdetails")
    public ResponseEntity<List<TaxBracket>> updataTaxBracket(@RequestBody List<BracketModelncomingData> taxBrackets) throws IOException {
        List<TaxBracket> res = unAuthorisedUserServices.update(taxBrackets);
        return ResponseEntity.ok(res);
    }
}
