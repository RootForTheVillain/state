package gov.michigan.dao;

import gov.michigan.model.User;

import java.util.List;

/**
 * Created by bknop on 3/12/2017.
 */
public interface UserDAO {

    public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);

}
