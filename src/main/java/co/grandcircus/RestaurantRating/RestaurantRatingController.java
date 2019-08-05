package co.grandcircus.RestaurantRating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.RestaurantRating.dao.RestaurantDao;
import co.grandcircus.RestaurantRating.entity.Restaurant;
import co.grandcircus.RestaurantRating.entity.UserPreference;

@Controller
public class RestaurantRatingController {

	@Autowired
	private RestaurantDao dao;
	
	@RequestMapping("/")
	public ModelAndView restaurants() {
		ArrayList<Restaurant> list = (ArrayList<Restaurant>) dao.findAll();
		Collections.sort(list);
		return new ModelAndView("restaurants", "restaurants", list);
	}
	
	@RequestMapping("/upvote")
	public ModelAndView upvote(
			@RequestParam("id") Long id) {
		Restaurant restaurant = dao.findById(id);
		int rating = restaurant.getRating() + 1;
		restaurant.setRating(rating);
		dao.update(restaurant);
		return new ModelAndView("redirect:/", "restaurant", restaurant);
	}
	
	@RequestMapping("/downvote")
	public ModelAndView downvote(
			@RequestParam("id") Long id) {
		Restaurant restaurant = dao.findById(id);
		int rating = restaurant.getRating() - 1;
		restaurant.setRating(rating);
		dao.update(restaurant);
		return new ModelAndView("redirect:/", "restaurant", restaurant); 
	}
	
//	@RequestMapping("/sort")
//	public ModelAndView sort(
//			UserPreference pref,
//			HttpSession session) {
//		session.setAttribute("preference", pref);
//		return new ModelAndView("redirect:/");
//		
//	}
}
