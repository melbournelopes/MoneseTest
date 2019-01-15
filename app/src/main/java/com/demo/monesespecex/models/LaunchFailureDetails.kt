package com.demo.monesespecex.models

data class LaunchFailureDetails(
        val altitude: Int,
        val reason: String,
        val time: Int
) : BaseModel()