package com.example.demo.methodToProperty

fun Set<CampSite>.sitesInRegion(
    countryISO: String,
    region: String
): Set<CampSite> =
    filter { site ->
        site.isIn(countryISO, region)
        }.toSet()

fun CampSite.isIn(
    countryISO: String,
    region: String? = null
) = countryCode == countryISO
        && region?.equals(region, ignoreCase = true) ?: true