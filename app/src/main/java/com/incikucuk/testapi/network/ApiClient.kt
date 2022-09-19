package com.incikucuk.testapi.network

import com.incikucuk.testapi.network.response.GetCharacterByIdResponse
import com.incikucuk.testapi.network.response.GetCharactersPageResponse
import retrofit2.Response

class ApiClient (
    private val rickAndMortyService: RickAndMortyService  //create api service
    ){
    //get informations from api by characterid
    suspend fun getCharacterById(characterId:Int): SimpleResponse<GetCharacterByIdResponse> {
        return safeApiCall { rickAndMortyService.getCharacterById(characterId) }
    }
    //get details pages from api
    suspend fun getCharactersPage(pageIndex:Int): SimpleResponse<GetCharactersPageResponse>{
        return safeApiCall { rickAndMortyService.getCharactersPage(pageIndex) }
    }
    private  inline fun <T> safeApiCall(apiCall:() -> Response<T>): SimpleResponse<T> {
        return try{
            SimpleResponse.success(apiCall.invoke())
        }catch (e:Exception){
            SimpleResponse.failure(e)
        }
    }
}



