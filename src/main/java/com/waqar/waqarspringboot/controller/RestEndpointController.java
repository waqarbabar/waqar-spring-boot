package com.waqar.waqarspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waqar.waqarspringboot.entity.EmployeeInformation;
import com.waqar.waqarspringboot.service.DashboardService;

@RestController
public class RestEndpointController {

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping("/employees")
	public List<EmployeeInformation> getAllEmp() {
		return dashboardService.getAllEmployee();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee/add")
	public String saveEmployee(@RequestBody EmployeeInformation employeeInformation) {
		if (null != dashboardService.addEmployee(employeeInformation)) {
			return "employee saved successfully";
		}
		return "employee not saved";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employee/delete")
	public String deleteEmployee(@RequestParam(name = "empId", required = true) String pk) {
		try {
			dashboardService.deleteEmployee(dashboardService.getEmployee(pk));
			return "employee deleted successfully";
		} catch (Exception e) {
			return "error";
		}
	}
}
