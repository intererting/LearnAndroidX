package com.example.learnandroidx

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_compose_recyclerview.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*

/**
 * @author    yiliyang
 * @date      21-4-30 上午9:03
 * @version   1.0
 * @since     1.0
 */
class ComposeRecyclerViewActivity : AppCompatActivity(R.layout.activity_compose_recyclerview) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager.adapter = ViewPagerAdapter(this).apply {
        }
//        viewPager.offscreenPageLimit = 1
    }
}

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return RecyclerViewFragment()
    }

}

class RecyclerViewFragment : Fragment(R.layout.fragment_recyclerview), LifecycleObserver {

    override fun onCreate(savedInstanceState: Bundle?) {
        println("fragment onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().lifecycle.addObserver(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireContext()).apply {
            initialPrefetchItemCount = 6
        }
        recyclerView.adapter = RecyclerViewAdapter()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onActivityCreated() {
        requireActivity().lifecycle.removeObserver(this)
    }

    class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            println("onCreateViewHolder")
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false)
            return RecyclerViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            println("onBindViewHolder $position")
        }

        override fun getItemCount(): Int {
            return 100
        }

    }

    class RecyclerViewHolder(override val containerView: View) :
        LayoutContainer,
        RecyclerView.ViewHolder(containerView) {

    }

}













