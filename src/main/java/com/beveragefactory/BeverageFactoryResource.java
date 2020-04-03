package com.beveragefactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beveragefactory.service.BeverageFactoryService;

@RestController
@RequestMapping("/order")
public class BeverageFactoryResource {

	@Autowired
	public BeverageFactoryService beverageFactoryService;
	
	@RequestMapping("/{menu}")
	public String getMenu(@PathVariable("menu") String menu) {
		
		if(beverageFactoryService.validOrderCheck(menu)) {
			return "Ordered Item not valid";
		} else {
			return "Total Bill = " + beverageFactoryService.computeOrderPrice(menu);
		}
	}
}
