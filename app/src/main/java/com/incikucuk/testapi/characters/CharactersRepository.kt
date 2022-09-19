package com.incikucuk.testapi.characters

import com.incikucuk.testapi.network.NetworkLayer
import com.incikucuk.testapi.network.response.GetCharactersPageResponse

class CharactersRepository {
    suspend fun getCharactersPage(pageIndex:Int):GetCharactersPageResponse?{
        val request = NetworkLayer.apiClient.getCharactersPage(pageIndex)

        if(request.failed || !request.isSuccessful){
            return null
        }
        return request.body
    }
}