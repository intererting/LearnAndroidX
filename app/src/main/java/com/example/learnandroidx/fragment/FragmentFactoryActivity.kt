package com.example.learnandroidx.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.learnandroidx.R

/**
 * @author    yiliyang
 * @date      20-11-30 下午1:16
 * @version   1.0
 * @since     1.0
 */
class FragmentFactoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_factory)
        supportFragmentManager.fragmentFactory = object : FragmentFactory() {
            override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
                if (className.equals(TestFragment::class.qualifiedName)) {
                    return TestFragment()
                }
                return TestFragment()
            }
        }
        supportFragmentManager.beginTransaction().add(R.id.containerView, TestFragment::class.java, null).commit()
    }
}