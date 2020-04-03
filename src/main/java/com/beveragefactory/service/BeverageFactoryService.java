package com.beveragefactory.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BeverageFactoryService {

	public double computeOrderPrice(String menu) {
		List<String> itemList = getItemList(menu);
		double temp = 0;
		for (int i = 0; i < itemList.size(); i++) {
			String item = itemList.get(i);
			if(item.equals("chai")) {
				temp = temp + 4;
			} else if(item.equals("coffee")) {
				temp = temp + 5;
			} else if(item.equals("banana smoothie")) {
				temp = temp + 6;
			} else if(item.equals("strawberry shake")) {
				temp = temp + 7;
			} else if(item.equals("mojito")) {
				temp = temp + 7.5;
			} else if(item.equals("-milk")) {
				temp = temp - 1;
			} else if(item.equals("-sugar")) {
				temp = temp - 0.5;
			} else if(item.equals("-soda")) {
				temp = temp - 0.5;
			} else if(item.equals("-mint")) {
				temp = temp - 0.5;
			} else if(item.equals("-water")) {
				temp = temp - 0.5;
			} 
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