package com.example.omararenaslandgrave.twowayscrollkotlin

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val masterRecyclerView: RecyclerView = findViewById(R.id.recView)
        masterRecyclerView.layoutManager = LinearLayoutManager(this)
        masterRecyclerView.adapter = MyAdapter(this)

    }
}

class MyAdapter(val context: Context ) : RecyclerView.Adapter<MyViewHolder>(){
    val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val aux = this.inflater.inflate(R.layout.category, parent , false)
        val titlesRecViews = aux.findViewById<RecyclerView>(R.id.recViewTitle)
        titlesRecViews.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
        titlesRecViews.adapter = MyAdapterTwo(context)
        return MyViewHolder(aux)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10;
    }

}

class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val vistaTitle : View?
    get()  {
        return itemView.findViewById<View>(R.id.vista)
    }


}

class MyAdapterTwo(val context: Context) : RecyclerView.Adapter<MyViewHolder>() {
    val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val aux = this.inflater.inflate(R.layout.title_layout,parent,false)
        return MyViewHolder(aux)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val randomColor = Random()
        val color = Color.argb(223, randomColor.nextInt(212), randomColor.nextInt(236), randomColor.nextInt(256))
        holder?.vistaTitle?.setBackgroundColor(color)
    }
}