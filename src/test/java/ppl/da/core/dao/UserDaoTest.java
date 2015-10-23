package ppl.da.core.dao;

/**
 * Created by greg on 18.10.15.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ppl.da.core.entity.User;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/applicationContext.xml")
@Transactional
public class UserDaoTest {
    @Autowired
    private UserDao userDAO;

    private User user;

    @Before
    @Rollback(false)
    public void setup() {
        user = new User();
        user.setEmail("login");
        user.setInfo("city");
        user.setPassword("password");
        user.setName("name");
        userDAO.saveAndFlush(user);
    }

    @Test
    public void addUser() throws Exception {
        User fromDB = userDAO.findOne(user.getId());
        assertEquals(fromDB, user);
    }



    @Test
    public void testGetUserNotExisted() throws Exception {
        User fromDB = userDAO.findByEmailAndPassword("login3", "password");
        assertNull(fromDB);
    }

    @Test
    public void testRemoveUser() {
        userDAO.delete(user.getId());
        User fromDB = userDAO.findOne(user.getId());
        assertNull(fromDB);
    }

    @Test
    public void updateUser() throws Exception {
        user.setName("UPDATED");
        userDAO.saveAndFlush(user);
        User fromDB = userDAO.findOne(user.getId());
        assertEquals(fromDB, user);
    }

    @Test
    public void getAllUsers() {
        assertEquals(user, userDAO.findAll().iterator().next());
    }


    @Test
    public void findUserByLogin() {
        assertEquals(user, userDAO.findByEmail("login"));
    }
}
