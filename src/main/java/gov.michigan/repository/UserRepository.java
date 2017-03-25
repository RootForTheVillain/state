package gov.michigan.repository;

import java.util.List;
import java.util.Set;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bknop on 3/13/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByLastName(@Param("lastName") String lastName);

    Set<Vehicle> getVehiclesForUser(@Param("id") int id);

}
