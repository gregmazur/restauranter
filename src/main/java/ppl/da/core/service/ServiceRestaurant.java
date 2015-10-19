package ppl.da.core.service;

import ppl.da.core.entity.Point;
import ppl.da.core.entity.Restaurant;

import java.util.List;


/**
 * Created by greg on 19.10.15.
 */
public interface ServiceRestaurant {
    /**
     *
     * @param point
     * @returns restaurants in distance of 20 km
     */
    List<Restaurant> getNearestRestaurants(Point point);

    /**
     *
     * @param point
     * @param distance in km
     * @return restaurants within chosen distance
     */
    List<Restaurant> getNearestRestaurants(Point point, Long distance);
    Restaurant addRestaurant(Restaurant newRestaurant);
}
