package me.maxcostadev.mhwcrowns

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val NUMBER_OF_MONSTERS = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

    }

    fun loadData(){
        JsonLoader.getMonsters(applicationContext) // TODO: send the data to a adapter
        setUpProgressBar()
    }

    fun setUpProgressBar(){
        mc_progress.max = NUMBER_OF_MONSTERS
        bc_progress.max = NUMBER_OF_MONSTERS
        mc_progress.progress = 86
        bc_progress.progress = 35
    }

}
