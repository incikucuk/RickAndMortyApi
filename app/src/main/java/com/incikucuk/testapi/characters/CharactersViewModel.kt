@file:Suppress("DEPRECATION")

package com.incikucuk.testapi.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.incikucuk.testapi.Constants
import com.incikucuk.testapi.network.response.GetCharacterByIdResponse

class CharactersViewModel :ViewModel() {

    private val repository = CharactersRepository()
    private val pageListConfig:PagedList.Config = PagedList.Config.Builder()
        .setPageSize(Constants.PAGE_SIZE)
        .setPrefetchDistance(Constants.PREFETCH_DISTANCE)
        .build()

    private val dataSourceFactory = CharactersDataSourceFactory(viewModelScope,repository)
    val charactersPageListLiveData: LiveData<PagedList<GetCharacterByIdResponse>> =
        LivePagedListBuilder(dataSourceFactory,pageListConfig).build()
}