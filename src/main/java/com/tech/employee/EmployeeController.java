package com.tech.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empser;

	@PostMapping(value = "/insert")
	public String addEmp(@RequestBody Employee e) throws EmployeeException1 {
		return empser.addEmp(e);
	}

	public String hello() {
		return "hai hello";
	}

	@PostMapping(value = "/insertAll")
	public String addEmployeeList(@RequestBody List<Employee> a) {
		return empser.addEmployeeList(a);
	}

	@GetMapping(value = "/getdetail/{id}")
	public Employee getList(@PathVariable int id) {
		return empser.getList(id);
	}

	@GetMapping(value = "/findall")
	public List<Employee> allemp() {
		return empser.allemp();
	}

	@PatchMapping("/modify/{id}")
	public String updsalary(@RequestBody Employee e, @PathVariable int id) {
		return empser.updsalary(id, e);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id) {
		return empser.delete(id);

	}

	@PutMapping(value = "/update/{e}")
	public String update(@RequestBody Employee e) {
		return empser.update(e);
	}

	@GetMapping(value = "/getbyname/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) throws NameNotFoundException, Exception {
		return empser.getEmployeeByName(name);
	}

	@GetMapping(value = "/agefilter/{age}")
	public List<Employee> agefilter(@PathVariable int age) throws AgeNotFoundException {
		return empser.agefilter(age);
	}

	@GetMapping(value = "/salaryfilter/{salary}")
	public List<Employee> salaryfilter(@PathVariable int salary) throws SalaryNotFoundException {
		return empser.salaryfilter(salary);
	}

	@GetMapping(value = "/genderfilter/{gender}")
	public List<Employee> genderfilter(@PathVariable String gender) {
		return empser.genderfilter(gender);
	}

	@GetMapping(value = "/maxsalary")
	public Employee maxi() {
		return empser.maxi();
	}

	@GetMapping(value = "/minsalary")
	public Employee mini() {

		return empser.mini();
	}

	@GetMapping(value = "/secondmax")
	public Employee secmax() {
		return empser.secmax();
	}

	@GetMapping(value = "/getbysalary/{salary}")
	public List<Employee> getbysalary(@PathVariable int salary) {
		return empser.getbysalary(salary);
	}

	@PutMapping("/updatee/{id}")
	public String upd(@PathVariable int id, @RequestBody Employee e) {
		return empser.upd(id, e);
	}

}
