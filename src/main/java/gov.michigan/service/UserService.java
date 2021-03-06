package gov.michigan.service;

        import gov.michigan.model.User;
        import gov.michigan.model.Vehicle;

        import java.util.Date;
        import java.util.List;
        import java.util.Set;

/**
 * Created by bknop on 3/14/2017.
 */
public interface UserService {

    public void create(User user);
    public void delete(int id);
    public List<User> findAll();
    public void update(User user);
    public User findById(int id);
    public User findByEmailAndPassword(String email, String password);
}
