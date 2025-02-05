package com.example.quanlynhansu.quanLynhansu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Lấy tất cả nhân viên
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Lấy nhân viên theo ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Thêm nhân viên mới
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Cập nhật nhân viên
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee empToUpdate = existingEmployee.get();
            empToUpdate.setName(employee.getName());
            empToUpdate.setDepartment(employee.getDepartment());
            empToUpdate.setSalary(employee.getSalary());
            return employeeRepository.save(empToUpdate);
        }
        return null;
    }

    // Xóa nhân viên
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
