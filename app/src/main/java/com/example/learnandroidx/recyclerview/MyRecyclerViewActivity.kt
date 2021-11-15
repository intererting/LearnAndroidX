package com.example.learnandroidx.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnandroidx.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_recyclerview.*

/**
 * @author    yiliyang
 * @date      20-12-25 下午4:31
 * @version   1.0
 * @since     1.0
 */
class MyRecyclerViewActivity : AppCompatActivity() {

    private val myAdapter by lazy {
        MyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        myAdapter.setHasStableIds(true)
        recyclerView.adapter = myAdapter
        test.setOnClickListener {
//            myAdapter.notifyDataSetChanged()
            val child = recyclerView.getChildAt(4)
            val holder = recyclerView.getChildViewHolder(child) as MyViewHolder
            println(holder.itemId)
        }
    }
}

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        println("onBindViewHolder")
        println("onBindViewHolder  $position")
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun getItemId(position: Int): Long {
//        return super.getItemId(position)
        return position.toLong()
    }

    override fun onViewRecycled(holder: MyViewHolder) {
        println(holder.itemId)
        super.onViewRecycled(holder)
    }
}

class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    val data = "haha"

}