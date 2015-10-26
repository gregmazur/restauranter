package ppl.da.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ppl.da.core.entity.Point;
import ppl.da.core.entity.Restaurant;
import ppl.da.core.service.ServiceRestaurant;

import java.util.List;

/**
 * Created by greg on 19.10.15.
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private static final Logger logger = Logger.getLogger(RestaurantController.class);
    private ServiceRestaurant service;

    @Autowired
    public RestaurantController(ServiceRestaurant service) {
        this.service = service;
    }

    @RequestMapping (method = RequestMethod.GET)
    public @ResponseBody List<Restaurant> getRestaurants(@RequestParam("lon")Double lon,@RequestParam("lat")Double lat,
                          @RequestParam("dis")Long dis){
        logger.debug("getRestaurants started");
        List<Restaurant> restaurants;
        if(lon == null || lat == null){
            return null;
        }else {
            Point point = new Point();
            point.setLatitude(lat);
            point.setLongitude(lon);
            if (dis == null){
                restaurants = service.getNearestRestaurants(point);
            }else {
                restaurants = service.getNearestRestaurants(point,dis);
            }
        }
        return restaurants;
    }
    @RequestMapping (method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        logger.debug("createRestaurant started");
        return service.addRestaurant(restaurant);
    }
    @RequestMapping (value = "/add",method = RequestMethod.GET)
    public String getRegistration(){
        logger.debug("getRegistration started");
        return "addrest";
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        logger.debug("test");
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";
    }
}
