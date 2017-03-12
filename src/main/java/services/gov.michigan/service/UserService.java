package gov.michigan.service;

import java.util.List;

import gov.michigan.model.User;

/**
 * Created by bknop on 3/12/2017.
 */
public interface UserService {

    public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);

}
