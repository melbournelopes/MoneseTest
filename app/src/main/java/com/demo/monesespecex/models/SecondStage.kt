package com.demo.monesespecex.models

data class SecondStage(
        val block: Any,
        val payloads: List<Payload>
) : BaseModel()