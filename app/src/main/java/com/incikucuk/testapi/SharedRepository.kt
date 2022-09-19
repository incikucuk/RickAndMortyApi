package com.incikucuk.testapi

import com.incikucuk.testapi.network.NetworkLayer
import com.incikucuk.testapi.network.response.GetCharacterByIdResponse


class SharedRepository {  //it is the class that interacts with the api

    suspend fun getCharacterById(characterId:Int): GetCharacterByIdResponse?{
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if(request.failed){
            return null
        }
        if(!request.isSuccessful){
            return null
        }
        return request.body
    }
}