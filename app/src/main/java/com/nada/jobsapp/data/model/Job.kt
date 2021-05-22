package com.nada.jobsapp.data.model

import com.squareup.moshi.Json

data class Job(

    @Json(name = "id")
    val id : Int = 0,

    @Json(name = "type")
    val type : String? = null,

    @Json(name = "url")
    val url : String? = null,

    @Json(name = "created_at")
    val created_at : String? = null,

    @Json(name = "company")
    val company : String? = null,

    @Json(name = "company_url")
    val company_url : String? = null,

    @Json(name = "location")
    val location : String? = null,

    @Json(name = "title")
    val title : String? = null,

    @Json(name = "description")
    val description : String? = null,

    @Json(name = "how_to_apply")
    val how_to_apply : String? = null,

    @Json(name = "company_logo")
    val company_logo : String? = null

)
