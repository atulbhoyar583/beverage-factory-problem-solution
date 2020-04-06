package com.beveragefactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beveragefactory.service.BeverageFactoryService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BeverageFactoryServiceTest {

	@InjectMocks
	BeverageFactoryService beverageFactoryService;
	
	private final String INVALID_ORDER = "Chai, -tea";
	private final String MENU_ONE = "Chai, -sugar";
	private final String MENU_TWO = "Chai, -sugar, -milk";
	private final String MENU_THREE = "Chai";
	private final String MENU_FOUR = "Chai, -sugar, Chai, Coffee, -milk";
	
	@Test
	public void validOrderCheckTest_fail() {
		boolean actual = beverageFactoryService.validOrderCheck(INVALID_ORDER);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void validOrderCheckTest_pass() {
		boolean actual = beverageFactoryService.validOrderCheck(MENU_ONE);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void computeOrderPriceTest_menuOne() {
		double actual = beverageFactoryService.computeOrderPrice(MENU_ONE);
		double expected = 3.5;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void computeOrderPriceTest_menuThree() {
		double actual = beverageFactoryService.computeOrderPrice(MENU_THREE);
		double expected = 4.0;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void computeOrderPriceTest_menuFour() {
		double actual = beverageFactoryService.computeOrderPrice(MENU_FOUR);
		double expected = 11.5;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void computeOrderPriceTest_menuTwo() {
		double actual = beverageFactoryService.computeOrderPrice(MENU_TWO);
		double expected = 2.5;
		
		Assert.assertEquals(expected, actual);
	}
	
}