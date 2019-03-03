package com.example.odetocode.vacantlandfinal

import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET




interface JsonPlaceHolderApi {
    /*@get:GET("users/test/")
    val posts: Call<List<Post>>
*/


    @FormUrlEncoded
    @POST("location/api/location")
    fun createPost(
            @Field("lat") lat: Double,
            @Field("long") long: Double
    ): Call<Post>

    @FormUrlEncoded
    @POST("location/api/state")
    fun createPost1(
            @Field("state") state: String

    ): Call<Post>

    
    @GET
    fun getiddata(@Url url:String): Call<Post1>

    @FormUrlEncoded
    @POST("filter/filter")         //to be changed
    fun createPost3(
            @Field("State") State: String,
            @Field("Area") Area: String,
            @Field("Cost") Cost: String
    ): Call<Post1>

}
