package com.incikucuk.testapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    val viewModel:SharedViewModel by lazy{
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    private val epoxyController = CharacterDetailsEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //the outward facing live data object and observe it for any of the changes
        viewModel.characterByIdLiveData.observe(this) { response ->

            epoxyController.characterResponse=response
            if (response == null) {   //check the response
                Toast.makeText(
                    this@MainActivity,
                    "Unsuccessful network call!!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }

        }
        //to bring up the detail page of the character selected by id
        val id = intent.getIntExtra(Constants.INTENT_EXTRA_CHARACTER_ID,1)
        viewModel.refreshCharacter(characterId = id)

        val epoxyRecyclerView = findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView)
        epoxyRecyclerView.setControllerAndBuildModels(epoxyController)


    }
    //the status of selecting the card in the list
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

