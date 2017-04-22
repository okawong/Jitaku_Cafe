package com.okawong.test.restaurant.service;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.okawong.restaurant.config.RestaurantConfig;
import com.okawong.restuarant.dish.Dish;
import com.okawong.restuarant.service.RestaurantService;
import com.okawong.restuarant.service.RestaurantServiceImpl;

public class RestaurantServiceTest {
	private RestaurantService restaurantService = null;
	private Connection con = null;

	@Before
	public void init() {
		restaurantService = new RestaurantServiceImpl();
		con = generateConnection();
	}

	@After
	public void teardown() {
		try {
			con = generateConnection();
			dropTable(con);
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Test
	public void createNewMenuTest() {
		restaurantService.createNewMenu(con, "test");
	}

	@Test
	public void insertDish() {
		restaurantService.createNewMenu(con, "test");
		Dish dish = new Dish("Tonkatsu", 9.90);
		restaurantService.addDish(generateConnection(), dish);
	}

	@Test
	public void insertTwoDishes() {
		restaurantService.createNewMenu(con, "test");
		Dish dish = new Dish("Tonkatsu", 9.90);
		Dish dish2 = new Dish("Okonomiyaki", 7.50);
		Integer id1 = restaurantService.addDish(generateConnection(), dish);
		Integer id2 = restaurantService.addDish(generateConnection(), dish2);
		Integer expectedId1 = 1;
		Integer expectedId2 = 2;

		assertEquals(expectedId1, id1);
		assertEquals(expectedId2, id2);
	}

	@Test
	public void getDish() {
		restaurantService.createNewMenu(con, "test");
		Dish dish = new Dish("Tonkatsu", 9.90);
		Integer id1 = restaurantService.addDish(generateConnection(), dish);
		Dish resultDish = restaurantService.getDish(generateConnection(), id1);
		Integer resultId = resultDish.getId();
		assertEquals(id1, resultId);
		System.out.println(resultDish.getName());

	}

	private void dropTable(Connection con) {
		String dropTable = "DROP TABLE " + RestaurantConfig.MENU_TABLE_NAME;
		try {
			Statement dropStatement = con.createStatement();
			dropStatement.executeUpdate(dropTable);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	private Connection generateConnection() {
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			return con;

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

}
