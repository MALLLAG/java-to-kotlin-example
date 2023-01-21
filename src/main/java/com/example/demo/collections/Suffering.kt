package com.example.demo.collections

object Suffering {

    @JvmStatic
    fun sufferScoreFor(
        route: List<Journey>
    ): Int {
        return sufferScore(
            route.longestJourneys(limit = 3),
            getDepartsFrom(route)
        )
    }

    @JvmStatic
    fun List<Journey>.longestJourneys(limit: Int): List<Journey> =
        sortedByDescending { it.duration }.take(limit)

    private fun getDepartsFrom(route: List<Journey>): Location {
        return route[0].departsFrom
    }

    fun routesToShowFor(itineraryId: String): List<List<Journey>> {
        return bearable(routesFor(itineraryId))
    }

    private fun bearable(routes: List<List<Journey>>): List<List<Journey>> =
        routes.filter { sufferScoreFor(it) <= 10 }

    private fun routesFor(itineraryId: String): List<List<Journey>> {
        return java.util.List.of()
    }

    private fun sufferScore(
        longestJourneys: List<Journey>,
        start: Location
    ): Int {
        return SOME_COMPLICATED_RESULT()
    }

    private fun SOME_COMPLICATED_RESULT(): Int {
        return 0
    }
}