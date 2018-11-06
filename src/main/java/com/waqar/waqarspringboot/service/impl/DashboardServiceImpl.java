package com.waqar.waqarspringboot.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
	public HashMap<String, Object> getTodayRevenueDash() {

		HashMap<String, Object> map = new HashMap();
		List<CompanyRevenue> list = companyRevenueRepository.findAll();
		List<String> label = new ArrayList();
		List<String> _revenue = new ArrayList();
		double totalMargin = 0;
		double totalExpense = 0;
		double totalRevenue = 0;

		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

		for (CompanyRevenue companyRevenue : list) {
			label.add(companyRevenue.get_month());
			_revenue.add(String.valueOf(companyRevenue.getRevenue()));
			totalExpense += companyRevenue.getExpense();
			totalMargin += companyRevenue.getMargins();
			totalRevenue += companyRevenue.getRevenue();
		}
		map.put("crLabels", label.toString());
		map.put("crRevenue", _revenue.toString());
		map.put("totalExpense", totalExpense);
		map.put("totalMargin", totalMargin);
		map.put("totalRevenue", totalRevenue);

		return map;
	}

	@Override
	public List<EmployeeInformation> getAllEmployee() {
		return employeeInformationRepository.findAll();
	}

	@Override
	public HashMap<String, Object> getOrderCollection() {
		List<OrderCollectionStatus> list = orderCollectionStatusRepository.findAll();

		HashMap<String, Object> map = new HashMap();
		double totalNewOrders = 0;
		double totalOrdersReturned = 0;
		double totalRevenue = 0;
		double totalShipped = 0;
		for (OrderCollectionStatus orderCollectionStatus : list) {
			totalNewOrders += orderCollectionStatus.getNewOrders();
			totalOrdersReturned += orderCollectionStatus.getReturned();
			totalRevenue += orderCollectionStatus.getRevenue();
			totalShipped += orderCollectionStatus.getShipped();
		}
		map.put("oNew", totalNewOrders);
		map.put("oReturned", totalOrdersReturned);
		map.put("oRevenue", totalRevenue);
		map.put("oShipped", totalShipped);
		return map;
	}

	@Override
	public HashMap<String, Object> getAllOrderReceived() {
		HashMap<String, Object> map = new HashMap();
		List<OrderReceived> list = orderReceivedRepository.findAll();
		List<String> oDate = new ArrayList();
		List<String> oReceived = new ArrayList();
		for (OrderReceived orderReceived : list) {
			oDate.add(orderReceived.getDateReceived());
			oReceived.add(String.valueOf(orderReceived.getOrderReceived()));
		}
		map.put("oDate", oDate.toString());
		map.put("oReceived", oReceived.toString());
		return map;
	}

	@Override
	public HashMap<String, Object> getBestCategory() {

		HashMap<String, Object> map = new HashMap();
		List<ProductCategory> list = productCategoryRepository.findByBestCategory(true);
		List<String> cName = new ArrayList();
		List<String> cPercentage = new ArrayList();
		for (ProductCategory productCategory : list) {
			cName.add(productCategory.getCategoryName());
			cPercentage.add(String.valueOf(productCategory.getPercentage()));
		}
		map.put("cName", cName.toString());
		map.put("cPercentage", cPercentage.toString());
		return map;
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
