package ppl.da.web.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import ppl.da.core.dao.UserDao;
//import ppl.da.core.entity.Point;
//import ppl.da.core.entity.Restaurant;
//import ppl.da.core.service.ServiceRestaurant;
//
//import java.util.List;
//
///**
// * Created by greg on 19.10.15.
// */
//@Controller
//public class RestaurantController {
//
//    private ServiceRestaurant sevice;
//    @Autowired
//    public RestaurantController(ServiceRestaurant serviceRestaurantImpl) {
//        this.sevice = serviceRestaurantImpl;
//    }
//
//    @RequestMapping (value = "/getrest", method = RequestMethod.GET)
//    public @ResponseBody List<Restaurant> getRestaurants(@RequestParam("lon")Double lon,@RequestParam("lat")Double lat,
//                          @RequestParam("dis")Long dis){
//        List<Restaurant> restaurants = null;
//        if(lon == null || lat == null){
//            return null;
//        }else {
//            Point point = new Point();
//            point.setLatitude(lat);
//            point.setLongitude(lon);
//            if (dis == null){
//                restaurants = sevice.getNearestRestaurants(point);
//            }else {
//                restaurants = sevice.getNearestRestaurants(point,dis);
//            }
//        }
//        return restaurants;
//    }
//    @RequestMapping (value = "/addrest",
//        method = RequestMethod.POST, headers = "Accept=application/json")
//    public @ResponseBody Restaurant createRestaurant(@RequestBody Restaurant restaurant){
//        return sevice.addRestaurant(restaurant);
//    }
//    @RequestMapping (value = "/addrest", method = RequestMethod.GET)
//    public String getRegistration(){
//        return "addrest";
//    }
//}
