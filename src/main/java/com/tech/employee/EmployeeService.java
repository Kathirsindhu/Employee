package com.tech.employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService {
	@Autowired
	EmployeeDao empdao;

	public String addEmp(Employee e) throws EmployeeException1 {
		if (e.getSalary() < 25000) {
			throw new EmployeeException1("given salary is under our requirements");
		}
		return empdao.addEmp(e);
	}

	public String addEmployeeList(List<Employee> a) {
		return empdao.addEmployeeList(a);
	}

	public Employee getList(int id) {
		return empdao.getList(id);
	}

	public List<Employee> allemp() {
		return empdao.allemp();
	}

	public String delete(int id) {
		return empdao.delete(id);
	}

	public String update(Employee e) {
		return empdao.update(e);
	}

	public List<Employee> getEmployeeByName(String name) throws NameNotFoundException {

		List<Employee> allemp = empdao.allemp();
		List<Employee> temp = allemp.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
		if (temp.isEmpty()) {
			throw new NameNotFoundException("there is no value you given");
		} else {
			return temp;
		}
	}

	public List<Employee> agefilter(int age) throws AgeNotFoundException {
		List<Employee> k = empdao.allemp();
		List<Employee> temp = k.stream().filter(x -> x.getAge() == age).collect(Collectors.toList());
		if (temp.isEmpty()) {
			throw new AgeNotFoundException("given age is not in database");
		} else {
			return temp;
		}
	}

	public List<Employee> salaryfilter(int salary) throws SalaryNotFoundException {
		List<Employee> k = empdao.allemp();
		List<Employee> kk = k.stream().filter(x -> x.getSalary() == salary).collect(Collectors.toList());
		if (kk.isEmpty()) {
			throw new SalaryNotFoundException("given salary is not in employee database");
		} else {
			return kk;
		}
	}

	public List<Employee> genderfilter(String gender) {

		List<Employee> allemp = empdao.allemp();
		return allemp.stream().filter(x -> x.getGender().equals(gender)).collect(Collectors.toList());
	}

	public Employee maxi() {
		List<Employee> maax = empdao.allemp();
		return maax.stream().max(Comparator.comparing(Employee::getSalary)).get();
	}

	public Employee mini() {
		List<Employee> miin = empdao.allemp();
		return miin.stream().min(Comparator.comparing(Employee::getSalary)).get();
	}

	public Employee secmax() {
		List<Employee> sec = empdao.allemp();
		return sec.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst()
				.get();
	}

	public List<Employee> getbysalary(int salary) {
		return empdao.getbysalary(salary);
	}

	public String upd(int id, Employee e) {
		return empdao.upd(id, e);
	}
	public String updsalary(int id,Employee e) {
		return empdao.updsalary(id,e);
	}
}
