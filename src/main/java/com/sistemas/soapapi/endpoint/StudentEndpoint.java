package com.sistemas.soapapi.endpoint;

import com.sistemas.soapapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sistemas_distribuidos.soap_api.*;

@Endpoint
public class StudentEndpoint {
    @Autowired private StudentService studentService;

    @PayloadRoot(
            namespace = "sistemas-distribuidos/soap-api",
            localPart = "getStudentRequest"
    )
    @ResponsePayload
    public StudentResponse getStudentRequest(@RequestPayload GetStudentRequest request){
        StudentResponse response = new StudentResponse();
        response.setStudent(studentService.getStudent(request.getId()));
        return response;
    }

    @PayloadRoot(
            namespace = "sistemas-distribuidos/soap-api",
            localPart = "createStudentRequest"
    )
    @ResponsePayload
    public StudentResponse createStudentRequest(@RequestPayload CreateStudentRequest request) {
        Student student = new Student();
        student.setId(request.getId());
        student.setNome(request.getNome());
        student.setCurso(request.getCurso());
        student.setSemestre(request.getSemestre());
        student.setRa(request.getRa());
        student.setCpf(request.getCpf());
        student.setCidade(request.getCidade());
        StudentResponse response = new StudentResponse();
        response.setStudent(studentService.createStudent(student));
        return response;
    }

    @PayloadRoot(
            namespace = "sistemas-distribuidos/soap-api",
            localPart = "updateStudentRequest"
    )
    @ResponsePayload
    public StudentResponse updateStudentRequest(@RequestPayload UpdateStudentRequest request) {
        StudentResponse response = new StudentResponse();
        response.setStudent(studentService.updateStudent(request.getId(), request));
        return response;
    }

    @PayloadRoot(
            namespace = "sistemas-distribuidos/soap-api",
            localPart = "deleteStudentRequest"
    )
    @ResponsePayload
    public StudentResponse deleteStudentRequest(@RequestPayload DeleteStudentRequest request) {
        StudentResponse response = new StudentResponse();
        response.setStudent(studentService.deleteStudent(request.getId()));
        return response;
    }
}
