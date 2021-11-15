package com.example.learnandroidx.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_fragmentmanager.*

/**
 * @author    yiliyang
 * @date      21-1-20 上午8:53
 * @version   1.0
 * @since     1.0
 */
class FragmentManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentmanager)
        val myFragment = MyFragment()
        val myFragment2 = MyFragment2()


//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainer, myFragment)
//            .commit()

        supportFragmentManager.beginTransaction()
            .add(myFragment, "f1")
            .commit()

        add.setOnClickListener {
            supportFragmentManager.beginTransaction().setMaxLifecycle(
                myFragment,
                Lifecycle.State.CREATED
            ).commit()

//            supportFragmentManager.beginTransaction()
////                .addToBackStack("haha")
//                .hide(myFragment)
//                .commit()
//
//            supportFragmentManager.beginTransaction()
////                .addToBackStack("haha")
//                .show(myFragment)
//                .commit()
//
//            supportFragmentManager.beginTransaction()
////                .addToBackStack("haha")
//                .add(R.id.fragmentContainer, myFragment2)
//                .commit()

        }
    }
}

class MyFragment : Fragment(R.layout.fragment_demo) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("MyFragment onCreate")
    }

    override fun onStart() {
        println("onStart")
        super.onStart()
    }

    override fun onResume() {
        println("onResume")
        super.onResume()
    }

    override fun onPause() {
        println("onPause")
        super.onPause()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("MyFragment onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        println("MyFragment onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MyFragment onDestroy")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        println("MyFragment  onHiddenChanged  $hidden")
        super.onHiddenChanged(hidden)
    }
}

class MyFragment2 : Fragment(R.layout.fragment_demo_2) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("MyFragment2 onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("MyFragment2 onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        println("MyFragment2 onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        println("MyFragment2 onDestroy")
        super.onDestroy()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        println("MyFragment2  onHiddenChanged  $hidden")
        super.onHiddenChanged(hidden)
    }
}
