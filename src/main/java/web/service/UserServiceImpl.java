package web.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() { return userDao.findAll(); }
    public User findById(Long id) { return userDao.findById(id); }
    public void save(User user) { userDao.save(user); }
    public void update(User user) { userDao.update(user); }
    public void delete(Long id) { userDao.delete(id); }
}
