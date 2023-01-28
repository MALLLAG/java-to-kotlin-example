package com.example.demo.actionToCalculation;

import java.time.Instant;
import java.util.Set;

public interface Trips {
    Set<Trip> currentTripsFor(String customerId, Instant at);
}
