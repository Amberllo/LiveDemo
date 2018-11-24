package com.amberllo.livedemo.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.amberllo.livedemo.R
import com.amberllo.livedemo.base.IView
import com.amberllo.livedemo.fragment.BusinessFragment
import com.amberllo.livedemo.fragment.MessageFragment
import com.amberllo.livedemo.fragment.MyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , IView {
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_message-> {
                viewPager.setCurrentItem(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_business-> {
                viewPager.setCurrentItem(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my-> {
                viewPager.setCurrentItem(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        var fragments = ArrayList<Fragment>()
        fragments.add(MessageFragment.newInstance())
        fragments.add(BusinessFragment.newInstance())
        fragments.add(MyFragment.newInstance())
        viewPager.offscreenPageLimit = fragments.size
        viewPager.adapter = HomeAdapter(this.supportFragmentManager,fragments)
    }

    class HomeAdapter(fm: FragmentManager, _fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

        var fragments:List<Fragment> = _fragments

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(p0: Int): Fragment {
            return fragments[p0]
        }

    }

}
