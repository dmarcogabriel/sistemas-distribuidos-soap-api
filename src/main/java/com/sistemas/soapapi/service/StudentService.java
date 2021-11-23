package com.sistemas.soapapi.service;

import org.springframework.stereotype.Service;
import sistemas_distribuidos.soap_api.Student;
import sistemas_distribuidos.soap_api.UpdateStudentRequest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class StudentService {
    private static final ArrayList<Student> students = new ArrayList<Student>();
    private static int nextId;

    public StudentService(){
        nextId = 1;
    }

    private static void incrementId(){
        nextId++;
    }

    public static Student getStudent(int id) {
        Student student = new Student();
        students.forEach((s) -> {
            if (Objects.equals(s.getId(), id)) {
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

    public static Student createStudent(Student student) {
        student.setId(nextId);
        incrementId();
        students.add(student);
        return student;
    }

    public static Student updateStudent(int id, UpdateStudentRequest data) {
        Student updatedStudent = null;
        for (Student student : students) {
            if (student.getId() == id) {
                student.setNome(data.getNome());
                student.setCurso(data.getCurso());
                student.setSemestre(data.getSemestre());
                student.setRa(data.getRa());
                student.setCpf(data.getCpf());
                student.setCidade(data.getCidade());
                updatedStudent = student;
            }
        }
        return updatedStudent;
    }

    public static Student deleteStudent(int id) {
        Student removed = null;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(students.indexOf(student));
                System.out.println("Removido: " + student.getNome());
                removed = student;
            }
        }
        return removed;
    }
}
