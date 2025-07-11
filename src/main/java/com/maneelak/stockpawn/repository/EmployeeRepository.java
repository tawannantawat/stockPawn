package com.maneelak.stockpawn.repository;

import com.maneelak.stockpawn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFullNameContainingIgnoreCase(String name);

    
    boolean existsByPhone(String phone);
}
