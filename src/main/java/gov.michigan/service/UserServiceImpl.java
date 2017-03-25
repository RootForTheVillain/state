package gov.michigan.service;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;
import gov.michigan.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by bknop on 3/14/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return userRepository.findOne(id);
    }

    /*@Override
    @Transactional
    public Set<Vehicle> findVehiclesById(int id) {
        return userRepository.getVehiclesForUser(id);
    }*/
}
