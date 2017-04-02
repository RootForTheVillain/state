package gov.michigan.service;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;
import gov.michigan.repository.UserRepository;

/*import org.joda.time.DateTime;
import org.joda.time.Days;*/
import gov.michigan.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bknop on 3/14/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Set<Vehicle> findByPlateExpirationBetween(int id, Date start, Date end) {
        return vehicleRepository
                .findVehicleByUserIdAndPlateExpirationGreaterThanEqualAndPlateExpirationLessThanEqual(id, start, end);
    }
}
