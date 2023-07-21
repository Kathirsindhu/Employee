package com.tech.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class EmployeeDao {
	@Autowired
	EmployeeRepository emprepo;

	public String addEmp(Employee e) {
		emprepo.save(e);
		return "success";
	}

	public String addEmployeeList(List<Employee> a) {
		emprepo.saveAll(a);
		return "list saved succefully";
	}

	public Employee getList(int id) {
		return emprepo.findById(id).get();
	}

	public List<Employee> allemp() {
		return emprepo.findAll();
	}

	public String delete(int id) {
		emprepo.deleteById(id);
		return "deleted";
	}

	public String update(Employee e) {
		emprepo.save(e);
		return "updated successfully";
	}

	public List<Employee> getbysalary(int salary) {
		return emprepo.getbysalary(salary);
	}

	public String upd(int id, Employee e) {
		emprepo.save(e);
		return "updated succesfull";
	}

	public String updsalary(int id, Employee e) {
		Employee ee = emprepo.findById(id).get();
		ee.setSalary(e.getSalary());
		emprepo.save(e);
		return "salary updated succesfull";

	}
}
