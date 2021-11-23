package com.sistemas.soapapi.service;

import org.springframework.stereotype.Service;
import sistemas_distribuidos.soap_api.Student;
import sistemas_distribuidos.soap_api.UpdateStudentRequest;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class StudentService {
    private final ArrayList<Student> students = new ArrayList<Student>();
    private int nextId;

    public StudentService(){
        nextId = 1;
    }

    private void incrementId(){
        nextId++;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudent(int id) {
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

    public Student createStudent(Student student) {
        student.setId(nextId);
        incrementId();
        students.add(student);
        return student;
    }

    public String updateStudent(int id, UpdateStudentRequest data) {
        boolean success = false;
        for (Student student : students) {
            if (student.getId() == id) {
                student.setNome(data.getNome());
                student.setCurso(data.getCurso());
                student.setSemestre(data.getSemestre());
                student.setRa(data.getRa());
                student.setCpf(data.getCpf());
                student.setCidade(data.getCidade());
                success = true;
            }
        }
        if (success) {
            return "Estudante atualizado com sucesso!";
        }
        return "Erro ao atualizar estudante";
    }

    public String deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        return "Estudante removido com sucesso!";
    }
}
