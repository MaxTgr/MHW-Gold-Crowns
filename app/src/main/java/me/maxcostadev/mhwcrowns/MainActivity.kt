package me.maxcostadev.mhwcrowns

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val NUMBER_OF_MONSTERS = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    fun loadData() {
        val data = JsonLoader.getMonsters(applicationContext)
        list.adapter = Adapter(applicationContext, data)
        setUpProgressBar()
    }

    fun setUpProgressBar() {
        mc_progress.max = NUMBER_OF_MONSTERS
        bc_progress.max = NUMBER_OF_MONSTERS
        mc_progress.progress = 86
        bc_progress.progress = 35
    }

}
