package co.grandcircus.RestaurantRating.entity;

import java.io.Serializable;

public class UserPreference implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String sortBy = "name";

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
