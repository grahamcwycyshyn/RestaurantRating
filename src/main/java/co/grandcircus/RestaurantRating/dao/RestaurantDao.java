package co.grandcircus.RestaurantRating.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.RestaurantRating.entity.Restaurant;

@Repository
@Transactional
public class RestaurantDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Restaurant> findAll(){
		return em.createQuery("FROM Restaurant", Restaurant.class).getResultList();
	}
	
	public Restaurant findById(Long id) {
		return em.find(Restaurant.class, id);
	}
	
	public void update(Restaurant Restaurant) {
		em.merge(Restaurant);
	}
	
	public void create(Restaurant Restaurant) {
		em.persist(Restaurant);
	}
	
	public void delete(Long id) {
		Restaurant Restaurant = em.getReference(Restaurant.class, id);
		em.remove(Restaurant);
	}
}
