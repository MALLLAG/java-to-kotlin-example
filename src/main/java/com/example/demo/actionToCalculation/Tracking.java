package com.example.demo.actionToCalculation;

import java.time.Instant;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.actionToCalculation.Trip.BookingStatus.BOOKED;

public class Tracking implements ITrackTrips {
    private final Trips trips;

    public Tracking(Trips trips) {
        this.trips = trips;
    }

    @Override
    public Optional<Trip> currentTripFor(String customerId, Instant at) {
        var candidates = trips.currentTripsFor(customerId, at)
                .stream()
                .filter(trip -> trip.getBookingStatus() == BOOKED)
                .collect(Collectors.toList());

        if (candidates.size() == 1) {
            return Optional.of(candidates.get(0));
        } else if (candidates.isEmpty()) {
            return Optional.empty();
        } else {
            throw new IllegalStateException("Unexpected more than one current trip for " + customerId);
        }
    }
}