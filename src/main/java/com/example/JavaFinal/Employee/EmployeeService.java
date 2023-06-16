package com.example.JavaFinal.Employee;


import ch.qos.logback.core.model.conditional.ElseModel;
import com.example.JavaFinal.Department.Department;
import com.example.JavaFinal.Project.Project;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }


    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee (Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("Employee with id" + employeeId + "does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }

//    @Transactional
//    public void updateEmployee(Long employeeId,
//                               String name,
//                               Department department,
//                               List<Project> projects,
//                               String role,
//                               Integer salary) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow( () -> new IllegalStateException(
//                        "Employee with id" + employeeId + "does not exists"));
//        if (name != null && name.length() > 0 && Objects.equals(employee.getName(), name)) {
//            employee.setName(name);
//        }
//
//        if (department != null && department.length() > 0 && Objects.equals(employee.getName(), name)) {
//            employee.setName(name);
//    }
}
