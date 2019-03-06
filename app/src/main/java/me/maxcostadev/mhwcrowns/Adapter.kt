package me.maxcostadev.mhwcrowns

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import me.maxcostadev.mhwcrowns.interfaces.Caller
import me.maxcostadev.mhwcrowns.model.Monster

class Adapter(private val context: Context,
                    private val dataSource: ArrayList<Monster>, val listener: Caller) : BaseAdapter() {

    private val CLEAR = ContextCompat.getColor(context, R.color.tint_clear)
    private val DARK = ContextCompat.getColor(context, R.color.tint_dark)

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        // 1
        if (convertView == null) {

            // 2
            view = inflater.inflate(R.layout.list_item, parent, false)

            // 3
            holder = ViewHolder()
            holder.image = view.findViewById(R.id.m_image) as ImageView
            holder.name = view.findViewById(R.id.m_name) as TextView
            holder.bigBtn = view.findViewById(R.id.m_bc_btn) as ImageView
            holder.miniBtn = view.findViewById(R.id.m_mc_btn) as ImageView

            // 4
            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val monster = getItem(position) as Monster

        holder.name.text = monster.name
        holder.image.setImageResource(getDrawable(monster.name))

        //make the onClick logic (change tint of the button from locked to unlocked)
        holder.bigBtn.setOnClickListener {
            it as ImageView
            if (CrownLoader.toggleCrown(parent.context, monster.name, "b")) {
                it.setColorFilter(CLEAR)
                listener.updateProgressBar("b", true)
            }else{
                it.setColorFilter(DARK)
                listener.updateProgressBar("b", false)
            }
        }
        holder.miniBtn.setOnClickListener {
            it as ImageView
            if (CrownLoader.toggleCrown(parent.context, monster.name, "m")) {
                it.setColorFilter(CLEAR)
                listener.updateProgressBar("m", true)
            }else{
                it.setColorFilter(DARK)
                listener.updateProgressBar("m", false)
            }
        }

        // make the initial load, get the saved data and apply to the buttons
        holder.bigBtn.setColorFilter(DARK)
        if (CrownLoader.getCrown(parent.context, monster.name, "b")) {
            holder.bigBtn.setColorFilter(CLEAR)
        }

        holder.miniBtn.setColorFilter(DARK)
        if (CrownLoader.getCrown(parent.context, monster.name, "m")) {
            holder.miniBtn.setColorFilter(CLEAR)
        }

        return view
    }

    private class ViewHolder {
        lateinit var image: ImageView
        lateinit var name: TextView
        lateinit var bigBtn: ImageView
        lateinit var miniBtn: ImageView
    }

    private fun getDrawable(name: String): Int {
        // replace any spaces and hyphens to underlines
        val re = Regex("[ -]")
        val search = re.replace(name, "_").toLowerCase()
        return context.resources.getIdentifier(search, "mipmap", context.packageName)
    }
}