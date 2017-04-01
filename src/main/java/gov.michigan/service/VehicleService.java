package gov.michigan.service;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;

import java.util.Date;
import java.util.Set;

/**
 * Created by bknop on 3/14/2017.
 */
public interface VehicleService {

    Set<Vehicle> findByPlateExpirationBetween(int id, Date start, Date end);
}
