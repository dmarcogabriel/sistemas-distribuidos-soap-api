package com.sistemas.soapapi.endpoint;

import com.sistemas.soapapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sistemas_distribuidos.soap_api.GetStudentRequest;
import sistemas_distribuidos.soap_api.GetStudentResponse;

@Endpoint
public class StudentEndpoint {
    @Autowired private StudentService studentService;

    @PayloadRoot(
            namespace = "sistemas-distribuidos/soap-api",
            localPart = "getStudentRequest"
    )
    @ResponsePayload
    public GetStudentResponse getStudentRequest(@RequestPayload GetStudentRequest request){
        GetStudentResponse response = new GetStudentResponse();
        response.setStudent(studentService.getStudent(request.getNome()));
        return response;
    }
}
