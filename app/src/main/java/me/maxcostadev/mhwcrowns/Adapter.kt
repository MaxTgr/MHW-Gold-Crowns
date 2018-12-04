package me.maxcostadev.mhwcrowns

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import me.maxcostadev.mhwcrowns.model.Monster

open class Adapter(context: Context, resource: Int, list: ArrayList<Monster>) :
        ArrayAdapter<Monster>(context, resource, list) {

    var resource: Int
    var list: ArrayList<Monster>
    var vi: LayoutInflater

    init {
        this.resource = resource
        this.list = list
        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var holder: ViewHolder
        var retView: View

        if (convertView == null) {
            retView = vi.inflate(resource, null)
            holder = ViewHolder()

            //holder.image = retView.findViewById(R.id.myImage) as ImageView?

            retView.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
            retView = convertView
        }

        return retView
    }

    internal class ViewHolder {

        //android:tint="#b888" (no crown)
        //android:tint="#0888" (with crown)

        //var image: ImageView? = null
    }

}