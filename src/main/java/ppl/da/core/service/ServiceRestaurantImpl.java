package ppl.da.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ppl.da.core.dao.RestaurantDao;
import ppl.da.core.entity.Point;
import ppl.da.core.entity.Restaurant;


import java.util.List;

/**
 * Created by greg on 19.10.15.
 */
@Service
@Transactional
public class ServiceRestaurantImpl implements ServiceRestaurant {

    @Autowired
    private RestaurantDao dao;

    public ServiceRestaurantImpl(){}

    @Override
    public List<Restaurant> getNearestRestaurants(Point point) {
        return getNearestRestaurants(point,Long.valueOf(20));
    }

    @Override
    public List<Restaurant> getNearestRestaurants(Point point, Long distance) {
        List<Restaurant> restaurants = dao.findAll();
        if (restaurants != null && !(restaurants.isEmpty())){
            for (Restaurant restaurant : restaurants){
                if(distance(point,restaurant.getPoint()) < distance){
                    restaurants.add(restaurant);
                }
            }
        }
        return restaurants;
    }

    @Override
    public Restaurant addRestaurant(Restaurant newRestaurant) {
        return dao.saveAndFlush(newRestaurant);
    }

    private static double distance(Point point1,Point point2) {
        double theta = point1.getLongitude() - point2.getLongitude();
        double lat1 = point1.getLatitude();
        double lat2 = point2.getLatitude();
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return dist;
    }

    private synchronized static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private synchronized static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
