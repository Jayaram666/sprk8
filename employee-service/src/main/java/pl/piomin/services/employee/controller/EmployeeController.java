package pl.piomin.services.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.employee.model.Employee;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping("/")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add...: {}", employee);
		return null;
	}

	@GetMapping("/greet/{name}")
	public String greet(@PathVariable("name") String name) {
		return "HI FROM EMPLOYEESERVICE MR " + name;
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") String id) {
		Employee e = new Employee();
		e.setId("2");
		e.setAge(34);
		e.setName("jayaram");
		return e;
	}

	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		Employee e = new Employee();
		e.setId("2");
		e.setAge(34);
		e.setName("jayaram");
		List<Employee> le = new ArrayList<>();
		le.add(e);
		return le;
	}

	@GetMapping("/organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		Employee e = new Employee();
		e.setId("2");
		e.setAge(34);
		e.setName("jayaram");
		List<Employee> le = new ArrayList<>();
		le.add(e);
		return le;
	}

}
