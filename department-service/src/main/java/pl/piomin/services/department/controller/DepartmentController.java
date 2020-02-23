package pl.piomin.services.department.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.piomin.services.department.client.EmployeeClient;
import pl.piomin.services.department.model.Department;
import pl.piomin.services.department.model.Employee;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	EmployeeClient employeeClient;

	@GetMapping("/feign")
	public List<Employee> listRest() {
		return employeeClient.findByDepartment("1");
	}

	@GetMapping("/{id}")
	public Department findById(@PathVariable("id") String id) {
		Department d = new Department();
		d.setId("2");
		d.setName("nme");
		d.setOrganizationId(2L);
		Employee e = new Employee();
		e.setId(2L);
		e.setAge(34);
		e.setName("jayaram");
		List<Employee> le = new ArrayList<>();
		le.add(e);

		List<Employee> lres=employeeClient.findByDepartment("1");
		System.out.println("The response is "+lres);
		System.out.println("Feigh got called ");
		d.setEmployees(le);
		return d;
	}

	// @GetMapping("/organization/{organizationId}/with-employees")
	// public List<Department>
	// findByOrganizationWithEmployees(@PathVariable("organizationId") Long
	// organizationId) {
	// LOGGER.info("Department find: organizationId={}", organizationId);
	// List<Department> departments =
	// repository.findByOrganizationId(organizationId);
	// departments.forEach(d ->
	// d.setEmployees(employeeClient.findByDepartment(d.getId())));
	// return departments;
	// }

}
