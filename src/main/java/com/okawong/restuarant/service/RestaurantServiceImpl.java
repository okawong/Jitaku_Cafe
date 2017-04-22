package com.okawong.restuarant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.okawong.restaurant.config.RestaurantConfig;
import com.okawong.restuarant.dish.Dish;

public class RestaurantServiceImpl implements RestaurantService {
	private Statement statement;
	private PreparedStatement insertPS;

	@Override
	public void createNewMenu(Connection con, String name) {
		// TODO Auto-generated method stub
		String createTable = "CREATE TABLE " + RestaurantConfig.MENU_TABLE_NAME
				+ "(ITEM_ID INT IDENTITY PRIMARY KEY, NAME VARCHAR(255) NOT NULL, PRICE DECIMAL(10,3), DESCRIPTION VARCHAR(255), CATEGORY VARCHAR(255), TAGS VARCHAR(255))";
		try {
			statement = con.createStatement();
			statement.execute(createTable);
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public Integer addDish(Connection con, Dish dish) {
		String insertStatement = "INSERT INTO " + RestaurantConfig.MENU_TABLE_NAME
				+ "(NAME, PRICE, DESCRIPTION, CATEGORY, TAGS) VALUES (?,?,?,?,?)";
		try {
			insertPS = con.prepareStatement(insertStatement, PreparedStatement.RETURN_GENERATED_KEYS);
			insertPS.setString(1, dish.getName());
			insertPS.setDouble(2, dish.getPrice());
			insertPS.setString(3, dish.getDescription());
			insertPS.setString(4, dish.getCategory());
			insertPS.setString(5, dish.getTags());
			insertPS.execute();
			ResultSet rs = insertPS.getGeneratedKeys();
			Integer id = -1;
			if (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}

	@Override
	public Dish getDish(Connection con, Integer dishId) {
		String getStatement = "SELECT * FROM " + RestaurantConfig.MENU_TABLE_NAME + " WHERE " + RestaurantConfig.ID
				+ "=" + dishId.toString();
		// statement = con.cre

		return null;
	}

	@Override
	public List<Dish> getDishes(Connection con, SearchEntity searchEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDish(Connection con, Integer dishId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDish(Connection con, Integer dishId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Dish> getAllDishes(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

}
