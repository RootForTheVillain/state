package gov.michigan.repository;

import java.util.Date;
import java.util.Set;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;
//import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by bknop on 3/13/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //List<User> findByLastName(@Param("lastName") String lastName);

    User findByEmailAndPassword(String email, String password);

}
