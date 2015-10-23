package ppl.da.core.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ppl.da.core.entity.Point;
import ppl.da.core.entity.Restaurant;
import ppl.da.core.entity.User;

import static org.junit.Assert.*;

/**
 * Created by greg on 18.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/applicationContext.xml")
@Transactional
public class RestaurantDaoTest {

    @Autowired
    private UserDao userDAO;

    @Autowired
    private RestaurantDao restaurantDao;

    private User user;
    private Restaurant restaurant;
    private Point point;

    @Before
    @Rollback(false)
    public void setup() {
        user = new User();
        user.setEmail("login");
        user.setInfo("city");
        user.setPassword("password");
        user.setName("name");
        userDAO.saveAndFlush(user);
        restaurant = new Restaurant();
        restaurant.setName("restaurant1");
        restaurant.setMark(5);
        point = new Point();
        point.setLatitude(4);
        point.setLongitude(6);
        restaurant.setPoint(point);
        restaurant.setCreatedBy(user.toString());
        restaurantDao.saveAndFlush(restaurant);
    }

    @Test
    public void testGetOne() {
        Restaurant fromDB = restaurantDao.getOne(restaurant.getId());
        assertEquals(restaurant, fromDB);
    }
}
