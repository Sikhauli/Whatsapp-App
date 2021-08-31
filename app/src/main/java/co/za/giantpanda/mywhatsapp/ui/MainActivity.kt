package co.za.giantpanda.mywhatsapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import co.za.giantpanda.mywhatsapp.R
import co.za.giantpanda.mywhatsapp.R.id
import co.za.giantpanda.mywhatsapp.R.layout
import co.za.giantpanda.mywhatsapp.R.string
import co.za.giantpanda.mywhatsapp.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity : AppCompatActivity() {

  private lateinit var tabLayout: TabLayout
  private lateinit var viewPager: ViewPager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    val toolbar: Toolbar = findViewById(id.toolbar)
    setSupportActionBar(toolbar)
    val supportActionBar = supportActionBar
    supportActionBar?.setTitle(string.app_name)

    if (findViewById<FrameLayout>(id.fragmentContainer) != null) {
      addFragment(MainFragment())
    }

    tabLayout = findViewById<View>(id.tabLayOut) as TabLayout
    viewPager = findViewById<View>(id.fragmentContainer) as ViewPager

    tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_camera_alt_24))
    tabLayout.addTab(tabLayout.newTab().setText("CHATS"))
    tabLayout.addTab(tabLayout.newTab().setText("STATUS"))
    tabLayout.addTab(tabLayout.newTab().setText("CALLS"))
    tabLayout.tabGravity = TabLayout.GRAVITY_FILL

    val adapter = ViewPagerAdapter(supportFragmentManager, tabLayout.tabCount)
    viewPager.adapter = adapter

    viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

    tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
      override fun onTabSelected(tab: Tab) {
        viewPager.currentItem = tab.position
      }

      override fun onTabUnselected(tab: Tab) {}
      override fun onTabReselected(tab: Tab) {}
    })
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.toolbar_menu, menu)
    val fragmentList = supportFragmentManager.fragments
    for (fragment in fragmentList) {
      if (fragment is MainFragment) {
        menu?.setGroupVisible(id.MenuOne, true)
        menu?.setGroupVisible(id.MenuTwo, false)
      }
    }
    return super.onCreateOptionsMenu(menu)
  }

  fun addFragment(fragment: Fragment) {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    val mainFragment = MainFragment()
    fragmentTransaction.add(id.fragmentContainer, mainFragment)
      .addToBackStack(fragment.javaClass.name)
    fragmentTransaction.commit()
  }

 internal fun replaceFragment(fragment: MainFragment) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    if (fragment != null) {
      fragmentTransaction.replace(R.id.fragmentContainer, Fragment()).addToBackStack(fragmentTransaction.javaClass.name)
    }
    fragmentTransaction.commit()
  }
}