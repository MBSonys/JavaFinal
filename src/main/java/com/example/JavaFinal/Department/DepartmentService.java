package com.example.JavaFinal.Department;


import com.example.JavaFinal.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public void addNewDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment (Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) {
            throw new IllegalStateException("Employee with id" + departmentId + "does not exists");
        }
        departmentRepository.deleteById(departmentId);
    }
}


