package com.okawong.restuarant.service;

import java.sql.Connection;
import java.util.List;

import com.okawong.restuarant.dish.Dish;

public interface RestaurantService {
	public void createNewMenu(Connection con, String name);

	public Integer addDish(Connection con, Dish dish);

	public Dish getDish(Connection con, Integer dishId);

	public List<Dish> getDishes(Connection con, Dish searchDish);

	public List<Dish> getAllDishes(Connection con);

	public void updateDish(Connection con, Integer dishId);

	public void deleteDish(Connection con, Integer dishId);

}
