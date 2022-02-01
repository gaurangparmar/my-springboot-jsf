package com.gaurang.my;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gaurang.my.soap.GetMyDetailsRequest;
import com.gaurang.my.soap.GetMyDetailsResponse;
import com.gaurang.my.soap.MyDetails;

@Endpoint
public class MyEndpoint {


    private static final String NAMESPACE_URI = "http://www.gaurang.com/my/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMyDetailsRequest")
    @ResponsePayload
    public GetMyDetailsResponse getMyDetails(@RequestPayload GetMyDetailsRequest request) {
        GetMyDetailsResponse response = new GetMyDetailsResponse();
        MyDetails myDetails = new MyDetails();
        myDetails.setFirstname("Gaurang");
        myDetails.setLastname("Parmar");
        myDetails.setAge(16);
        response.setMydetails(myDetails);
        return response;
    }
}

