package com.incikucuk.testapi.characters

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.incikucuk.testapi.R
import androidx.paging.PagedList
import com.incikucuk.testapi.MainActivity

class CharacterListActivity: AppCompatActivity(){

    private val epoxyController = CharacterListPagingEpoxyController(::onCharacterSelected)

   private val viewModel:CharactersViewModel by lazy{
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }
    override fun onCreate(savedInstanceState:Bundle?) {  //create characters as view
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        viewModel.charactersPageListLiveData.observe(this) {pagedList -> epoxyController.submitList(pagedList)}

        findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView).setController(epoxyController)
    }

    private fun onCharacterSelected(characterId:Int){  //to show when it selected by id
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra(com.incikucuk.testapi.Constants.INTENT_EXTRA_CHARACTER_ID,characterId)
        startActivity(intent)
    }
}
