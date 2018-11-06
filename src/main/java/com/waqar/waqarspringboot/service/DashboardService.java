package com.waqar.waqarspringboot.service;

import java.util.HashMap;
import java.util.List;

import com.waqar.waqarspringboot.entity.EmployeeInformation;
import com.waqar.waqarspringboot.entity.OrderCollectionStatus;
import com.waqar.waqarspringboot.entity.OrderReceived;
import com.waqar.waqarspringboot.entity.ProductCategory;

public interface DashboardService {

	HashMap<String, Object> getTodayRevenueDash();

	List<EmployeeInformation> getAllEmployee();

	HashMap<String, Object> getOrderCollection();

	HashMap<String, Object> getAllOrderReceived();

	HashMap<String, Object> getBestCategory();

	EmployeeInformation addEmployee(EmployeeInformation employeeInformation);

	void deleteEmployee(EmployeeInformation employeeInformation);

	EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);

	EmployeeInformation getEmployee(final String pk);
}
