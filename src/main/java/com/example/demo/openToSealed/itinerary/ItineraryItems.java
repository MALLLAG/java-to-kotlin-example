package com.example.demo.openToSealed.itinerary;

public class ItineraryItems {
    public static void example(ItineraryItem item) {
        if (item instanceof Journey) {
            // TODO
        } else if (item instanceof Accommodation) {
            // TODO
        } else if (item instanceof RestaurantBooking) {
            // TODO
        } else {
            throw new IllegalStateException("should never happen");
        }
    }
}
