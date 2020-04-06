package com.beveragefactory.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.beveragefactory.builder.BeverageBuilder;
import com.beveragefactory.model.BeverageItem;

@Service
public class BeverageFactoryService {

	public double computeOrderPrice(String menu) {
		BeverageBuilder beverageBuilder = new BeverageBuilder(new BeverageItem());
		
		List<String> itemList = getItemList(menu);
		double temp = 0;
		for (int i = 0; i < itemList.size(); i++) {
			String item = itemList.get(i);
			temp = temp + beverageBuilder.createBeverageBuilder(item);
		}
		return temp;
	}
	
	public boolean validOrderCheck(String menu) {
		List<String> itemList = getItemList(menu);
		if(itemList.contains("-coffee") || itemList.contains("-tea") || itemList.contains("-banana") || itemList.contains("-strawberries")) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<String> getItemList(String menu) {
		return Arrays.asList(menu.split(",")).stream().map(s->s.replace("\"", "").replace("[", "").replace("]", "").trim().toLowerCase()).collect(Collectors.toList());
	}
}