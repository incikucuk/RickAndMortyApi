package com.incikucuk.testapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {
    //Moshi performs serialization of json amplification and network searches.
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    //Retrofit REST apis are easily accessible
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val rickAndMortyService: RickAndMortyService by lazy{
        retrofit.create(RickAndMortyService::class.java)   //using retrofit to use api
    }
    //api client object
    val apiClient = ApiClient(rickAndMortyService)

}