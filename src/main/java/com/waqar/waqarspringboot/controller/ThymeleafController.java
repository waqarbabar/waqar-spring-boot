package com.waqar.waqarspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.waqar.waqarspringboot.service.DashboardService;

@Controller
public class ThymeleafController {
	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/dashboard")
	public String getDashDetails(Model model) {
		model.addAttribute("cr", dashboardService.getTodayRevenueDash());
		model.addAttribute("ei", dashboardService.getAllEmployee());
		model.addAttribute("dash", dashboardService.getOrderCollection());
		model.addAttribute("bs", dashboardService.getBestCategory());
		model.addAttribute("or", dashboardService.getAllOrderReceived());
		return "/dashboard";

	}
}
