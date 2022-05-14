package com.user.service;

import com.user.datamodels.BracketModelncomingData;
import com.user.datamodels.LoginDataModel;
import com.user.datamodels.ResponseObject;
import com.user.datamodels.SignUpModel;
import com.user.datamodels.TaxBracket;

import java.io.IOException;
import java.util.List;

public interface UnAuthorisedUserServices {
    ResponseObject loginService(LoginDataModel data);
    ResponseObject signUpService(SignUpModel data);
    List<TaxBracket> update(List<BracketModelncomingData> taxBrackets) throws IOException;
}
