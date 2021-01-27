package com.maersk.testMockito;

public class MyService {
    ExternalService externalService;

    public MyService(ExternalService externalService)
    {
        this.externalService=externalService;
    }
    public boolean validate(String id)
    {
        if(id==null)
            throw new RuntimeException("...id is null...");

        if(externalService.getValidation(id)!=null)
            return true;

        return false;
    }
}
