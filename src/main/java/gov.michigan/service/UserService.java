package gov.michigan.service;

import gov.michigan.model.User;

import java.util.List;

/**
 * Created by bknop on 3/14/2017.
 */
public interface UserService {

    public void create(User user);
    public void delete(int id);
    public List<User> findAll();
    public void update(User user);
    public User findById(int id);

}
