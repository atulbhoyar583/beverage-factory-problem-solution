package com.beveragefactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import com.beveragefactory.service.BeverageFactoryService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BeverageFactoryResourceTest {

	@InjectMocks
	private BeverageFactoryResource beverageFactoryResource;
	
	@Mock
	public BeverageFactoryService beverageFactoryService;
	
	private final String MENU_ONE = "Chai, -sugar";
	private final String MENU_TWO = "Chai, -sugar, -milk";
	private final String MENU_THREE = "Chai";
	private final String MENU_FOUR = "Chai, -sugar, Chai, Coffee, -milk";
	
	@Test
	public void testGetMenu_invalidOrder() {
		Mockito.when(beverageFactoryService.validOrderCheck(MENU_ONE)).thenReturn(true);
		
		String actual = this.beverageFactoryResource.getMenu(MENU_ONE);
		String expected = "Ordered Item not valid";
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetMenu_one() {
		Mockito.when(beverageFactoryService.validOrderCheck(MENU_ONE)).thenReturn(false);
		Mockito.when(beverageFactoryService.computeOrderPrice(MENU_ONE)).thenReturn(3.5);
		
		String actual = this.beverageFactoryResource.getMenu(MENU_ONE);
		String expected = "Total Bill = 3.5";
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetMenu_two() {
		Mockito.when(beverageFactoryService.validOrderCheck(MENU_TWO)).thenReturn(false);
		Mockito.when(beverageFactoryService.computeOrderPrice(MENU_TWO)).thenReturn(2.5);
		
		String actual = this.beverageFactoryResource.getMenu(MENU_TWO);
		String expected = "Total Bill = 2.5";
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetMenu_three() {
		Mockito.when(beverageFactoryService.validOrderCheck(MENU_THREE)).thenReturn(false);
		Mockito.when(beverageFactoryService.computeOrderPrice(MENU_THREE)).thenReturn(4.0);
		
		String actual = this.beverageFactoryResource.getMenu(MENU_THREE);
		String expected = "Total Bill = 4.0";
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetMenu_four() {
		Mockito.when(beverageFactoryService.validOrderCheck(MENU_FOUR)).thenReturn(false);
		Mockito.when(beverageFactoryService.computeOrderPrice(MENU_FOUR)).thenReturn(11.5);
		
		String actual = this.beverageFactoryResource.getMenu(MENU_FOUR);
		String expected = "Total Bill = 11.5";
		
		Assert.assertEquals(expected, actual);
	}
}