package com.waqar.waqarspringboot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.waqar.waqarspringboot.entity.CompanyRevenue;
import com.waqar.waqarspringboot.entity.EmployeeInformation;
import com.waqar.waqarspringboot.entity.OrderCollectionStatus;
import com.waqar.waqarspringboot.entity.OrderReceived;
import com.waqar.waqarspringboot.entity.ProductCategory;

public interface DashboardService {

	List<CompanyRevenue> getTodayRevenueDash();

	List<EmployeeInformation> getAllEmployee();

	List<OrderCollectionStatus> getOrderCollection();

	List<OrderReceived> getAllOrderReceived();

	List<ProductCategory> getBestCategory();

	EmployeeInformation addEmployee(EmployeeInformation employeeInformation);

	void deleteEmployee(EmployeeInformation employeeInformation);

	EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);

	EmployeeInformation getEmployee(final String pk);
}
