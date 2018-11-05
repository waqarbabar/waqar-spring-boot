package com.waqar.waqarspringboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waqar.waqarspringboot.entity.CompanyRevenue;
import com.waqar.waqarspringboot.entity.EmployeeInformation;
import com.waqar.waqarspringboot.entity.OrderCollectionStatus;
import com.waqar.waqarspringboot.entity.OrderReceived;
import com.waqar.waqarspringboot.entity.ProductCategory;
import com.waqar.waqarspringboot.repositories.CompanyRevenueRepository;
import com.waqar.waqarspringboot.repositories.EmployeeInformationRepository;
import com.waqar.waqarspringboot.repositories.OrderCollectionStatusRepository;
import com.waqar.waqarspringboot.repositories.OrderReceivedRepository;
import com.waqar.waqarspringboot.repositories.ProductCategoryRepository;
import com.waqar.waqarspringboot.service.DashboardService;
@Component
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private CompanyRevenueRepository companyRevenueRepository;
	@Autowired
	private EmployeeInformationRepository employeeInformationRepository;
	@Autowired
	private OrderCollectionStatusRepository orderCollectionStatusRepository;
	@Autowired
	private OrderReceivedRepository orderReceivedRepository;
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<CompanyRevenue> getTodayRevenueDash() {
		return companyRevenueRepository.findAll();
	}

	@Override
	public List<EmployeeInformation> getAllEmployee() {
		return employeeInformationRepository.findAll();
	}

	@Override
	public List<OrderCollectionStatus> getOrderCollection() {
		return orderCollectionStatusRepository.findAll();
	}

	@Override
	public List<OrderReceived> getAllOrderReceived() {
		return orderReceivedRepository.findAll();
	}

	@Override
	public List<ProductCategory> getBestCategory() {
		return productCategoryRepository.findByBestCategory(true);
	}

	@Override
	public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
		return employeeInformationRepository.save(employeeInformation);
	}

	@Override
	public void deleteEmployee(EmployeeInformation employeeInformation) {
		employeeInformationRepository.delete(employeeInformation);

	}

	@Override
	public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
		return employeeInformationRepository.save(employeeInformation);
	}

	@Override
	public EmployeeInformation getEmployee(String pk) {
		return employeeInformationRepository.findByPk(pk);
	}

}
