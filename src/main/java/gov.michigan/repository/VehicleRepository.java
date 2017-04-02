package gov.michigan.repository;

import java.util.Date;
import java.util.Set;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;
//import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by bknop on 3/13/2017.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Set<Vehicle> findVehicleByUserIdAndPlateExpirationGreaterThanEqualAndPlateExpirationLessThanEqual(
            int id, Date start, Date end);

}
