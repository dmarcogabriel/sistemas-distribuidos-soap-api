package com.sistemas.soapapi.service;

import org.springframework.stereotype.Service;
import sistemas_distribuidos.soap_api.StudentType;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class StudentService {
    private static final ArrayList<StudentType> students = new ArrayList<StudentType>();

    @PostConstruct
    public void initialize(){
        StudentType student = new StudentType();
        student.setId(1);
        student.setNome("Peter");
        student.setCurso("Sistemas de Informação");
        student.setSemestre(3);
        student.setRa("123456");
        student.setCpf("11122233344");
        student.setCidade("Marília");

        students.add(student);
    }

    public static StudentType getStudent(String name) {
        StudentType student = new StudentType();
        students.forEach((s) -> {
            if (Objects.equals(s.getNome(), name)) {
                student.setId(s.getId());
                student.setNome(s.getNome());
                student.setCurso(s.getCurso());
                student.setSemestre(s.getSemestre());
                student.setRa(s.getRa());
                student.setCpf(s.getCpf());
                student.setCidade(s.getCidade());
            }
        });
        return student;
    }

    public ArrayList<StudentType> getStudents(){
        return students;
    }
}
