package gov.michigan.repository;

import java.util.List;

import gov.michigan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bknop on 3/13/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByLastName(@Param("name") String name);

}
