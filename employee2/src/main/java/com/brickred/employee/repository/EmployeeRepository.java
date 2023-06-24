package com.brickred.employee.repository;
import com.brickred.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Integer> {

//    @Query("SELECT e FROM Employee e WHERE e.name = :name")
//    List<Employee> findEmployeesByName(@Param("name") String name);
    public List<Employee> findByNameContaining(String name);

    public List<Employee> findByCityContaining(String city);


}
