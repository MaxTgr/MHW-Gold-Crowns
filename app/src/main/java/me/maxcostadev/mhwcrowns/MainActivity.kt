package me.maxcostadev.mhwcrowns

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.maxcostadev.mhwcrowns.interfaces.Caller
import me.maxcostadev.mhwcrowns.model.Monster

class MainActivity : AppCompatActivity(), Caller {

    private val numberOfMonsters = 27
    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() { //load monster data from json
        val data = JsonLoader.getMonsters(applicationContext)
        list.adapter = Adapter(applicationContext, data, this)
        setUpProgressBar(data)
    }

    private fun setUpProgressBar(data: ArrayList<Monster>) {
        mc_progress.max = numberOfMonsters
        bc_progress.max = numberOfMonsters
        mc_progress.progress = 0
        bc_progress.progress = 0
        data.forEach {
            if(it.mini_crown){
                mc_progress.progress += 1
            }
            if(it.big_crown){
                bc_progress.progress += 1
            }
        }
    }

    override fun updateProgressBar(type:String, add:Boolean){
        val operand = if (add) 1 else -1

        if(type == "m"){ // m will increase mini crown counter while b will increase big crown's
            mc_progress.progress += operand
        }else if(type == "b"){
            bc_progress.progress += operand
        }
    }

}
