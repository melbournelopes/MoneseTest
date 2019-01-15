package com.demo.monesespecex.models

data class MainRocketModel(
        val details: Any,
        val flight_number: Int,
        val is_tentative: Boolean,
        val launch_date_local: String,
        val launch_date_unix: Long,
        val launch_date_utc: String,
        val launch_failure_details: LaunchFailureDetails,
        val launch_site: LaunchSite,
        val launch_success: Any,
        val launch_window: Any,
        val launch_year: String,
        val links: Links,
        val mission_id: List<Any>,
        val mission_name: String,
        val rocket: Rocket,
        val ships: List<Any>,
        val static_fire_date_unix: Any,
        val static_fire_date_utc: Any,
        val tbd: Boolean,
        val telemetry: Telemetry,
        val tentative_max_precision: String,
        val upcoming: Boolean
) : BaseModel()