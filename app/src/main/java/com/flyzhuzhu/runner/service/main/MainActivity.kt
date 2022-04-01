package com.flyzhuzhu.runner.service.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.flyzhuzhu.runner.R
import com.flyzhuzhu.runner.base.BaseActivity
import com.flyzhuzhu.runner.service.main.tab.HomeFragment
import com.flyzhuzhu.runner.service.main.tab.MineFragment
import com.flyzhuzhu.runner.service.main.tab.OrderFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var fragmentList: ArrayList<Fragment> = ArrayList()

    init {
        fragmentList.add(HomeFragment())
        fragmentList.add(OrderFragment())
        fragmentList.add(MineFragment())
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> view_pager.currentItem = 0
                R.id.nav_order -> view_pager.currentItem = 1
                R.id.nav_mine -> view_pager.currentItem = 2
            }
            return@setOnNavigationItemSelectedListener true
        }
        view_pager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager, 1) {

            override fun getCount() = 3

            override fun getItem(position: Int) = fragmentList[position]

        }
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottom_navigation.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    override fun initData() {

    }

    override fun observeLiveData() {
    }
}