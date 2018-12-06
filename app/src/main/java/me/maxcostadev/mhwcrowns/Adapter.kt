package me.maxcostadev.mhwcrowns

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import me.maxcostadev.mhwcrowns.model.Monster


class Adapter(context: Context, users: ArrayList<Monster>) : ArrayAdapter<Monster>(context, 0, users) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // Get the data item for this position
        val monster = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        // Lookup view for data population
        val name = convertView!!.findViewById<TextView>(R.id.m_name)
        val image = convertView.findViewById<ImageView>(R.id.m_image)
        val isBigCollected = convertView.findViewById<ImageView>(R.id.m_bc_btn)
        val isMiniCollected = convertView.findViewById<ImageView>(R.id.m_mc_btn)
        val isBigEvent = convertView.findViewById<ImageView>(R.id.m_bc_event)
        val isMiniEvent = convertView.findViewById<ImageView>(R.id.m_mc_event)
        // Populate the data into the template view using the data object
        name.text = monster.name
        image.setImageResource(getDrawable(monster.name))

        // Return the completed view to render on screen
        return convertView
    }

    private fun getDrawable(name: String): Int {
        val re = Regex("[ -]")
        val search = re.replace(name, "_").toLowerCase()
        return context.resources.getIdentifier(search, "drawable", context.packageName)
    }
}