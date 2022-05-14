package com.user.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.datamodels.BracketModelncomingData;
import com.user.datamodels.LoginDataModel;
import com.user.datamodels.LoginResponseObject;
import com.user.datamodels.ResponseObject;
import com.user.datamodels.SignUpModel;
import com.user.datamodels.TaxBracket;
import com.user.datarepository.TaxBracketRepository;
import com.user.datarepository.UserRepository;
import com.user.service.UnAuthorisedUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnAuthorisedUserServiceImpl implements UnAuthorisedUserServices {

    @Autowired
    TaxBracketRepository taxBracketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public ResponseObject loginService(LoginDataModel data) {
        List<SignUpModel> res = userRepository.findByEmail(data.getEmail());
        ResponseObject responseObject = new ResponseObject();
        if(res.size()!=0) {
            if(encoder.matches(data.getPassword(),res.get(0).getPassword())) {
                LoginResponseObject object = new LoginResponseObject();
                object.setUserId(res.get(0).getUserId());
                object.setEmail(res.get(0).getEmail());
                object.setUserName(res.get(0).getUserName());
                object.setPassword(data.getPassword());
                responseObject.setSuccess(true);
                responseObject.setData(object);
                responseObject.setErrorMessage(null);
                return responseObject;
            }
        }
        responseObject.setSuccess(false);
        responseObject.setData(null);
        responseObject.setErrorMessage("Wrong email or password");
        return responseObject;
    }

    @Override
    public ResponseObject signUpService(SignUpModel data) {
        List<SignUpModel> check = userRepository.findByEmail(data.getEmail());
        ResponseObject responseObject = new ResponseObject();
        if(check.size()!=0) {
            responseObject.setSuccess(false);
            responseObject.setData(null);
            responseObject.setErrorMessage("User Already exists");
            return responseObject;
        }
        String encodedpwd = encoder.encode(data.getPassword());

        SignUpModel dataToSave = new SignUpModel();
        dataToSave.setUserName(data.getUserName());
        dataToSave.setEmail(data.getEmail());
        dataToSave.setPassword(encodedpwd);
        data.setPassword(encodedpwd);

        SignUpModel res = userRepository.save(dataToSave);
        LoginResponseObject object = new LoginResponseObject();
        object.setUserId(res.getUserId());
        object.setEmail(res.getEmail());
        object.setUserName(res.getUserName());
        object.setPassword(data.getPassword());
        responseObject.setSuccess(true);
        responseObject.setData(object);
        responseObject.setErrorMessage(null);
        return responseObject;
    }

    @Override
    public List<TaxBracket> update(List<BracketModelncomingData> bracketModelncomingDataList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //List<BracketModelncomingData> bracketModelncomingDataList = objectMapper.readValue
          //      (new File("src/main/java/com/user/datamodels/taxRate.json"),new TypeReference<List<BracketModelncomingData>>(){});
        List<TaxBracket> taxBrackets = new ArrayList<>();
        for(BracketModelncomingData data : bracketModelncomingDataList) {
            //construction and initialisation of taxBracket object
            TaxBracket taxBracket = new TaxBracket();

            taxBracket.setIncomeLowerLimit(data.getIncomeLowerLimit());
            taxBracket.setIncomeUpperLimit(data.getIncomeUpperLimit());

            if(data.getIncomeUpperLimit()!=0) {
                taxBracket.setIncomeRange(data.getIncomeUpperLimit()-data.getIncomeLowerLimit());
            }
            else taxBracket.setIncomeRange(0);

            taxBracket.setTaxRate(data.getTaxRate());

            if(data.getIncomeUpperLimit()!=0){
                int maxTax = data.getIncomeUpperLimit()-data.getIncomeLowerLimit();
                maxTax = (maxTax * data.getTaxRate())/100;
                taxBracket.setMaxTax(maxTax);
            }
            else taxBracket.setMaxTax(0);

            taxBracket.setFillerStatus(data.getStatus());
            taxBracket.setStandardDeduction(data.getStandardDeduction());

            //addition of taxBracket to list
            taxBrackets.add(taxBracket);
        }
        List<TaxBracket> response=taxBracketRepository.saveAll(taxBrackets);
        return response;
    }
}
