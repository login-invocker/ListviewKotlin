package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class WordAdapter(var context:Context,var arr:ArrayList<Word>) :BaseAdapter() {

    class ViewHolder(a:View){
         var txt:TextView
        init {
            txt=a.findViewById(R.id.txtInLv)
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v:View?
        var vHolder :ViewHolder?
        if(convertView==null){
            v= LayoutInflater.from(context).inflate(R.layout.itemlv,parent,false)
            vHolder=ViewHolder(v)
            v.tag=vHolder
        }else{
        v=convertView
        vHolder=convertView.tag as ViewHolder
        }
        var words:Word= getItem(position) as Word
        vHolder.txt.text=words.word
        return v as View
    }

    override fun getItem(position: Int): Any {
        return arr.get(position)
    }

    override fun getItemId(position: Int): Long {
return position.toLong()    }

    override fun getCount(): Int {
    return arr.size
    }
}