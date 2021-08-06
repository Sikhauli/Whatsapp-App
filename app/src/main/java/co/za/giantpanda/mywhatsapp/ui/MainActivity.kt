package co.za.giantpanda.mywhatsapp.ui


import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.za.giantpanda.mywhatsapp.R
import co.za.giantpanda.mywhatsapp.R.id
import co.za.giantpanda.mywhatsapp.R.layout
import co.za.giantpanda.mywhatsapp.R.string

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    val toolbar: Toolbar = findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)
    val supportActionBar = supportActionBar
    supportActionBar?.setTitle(string.app_name)


    if(findViewById<FrameLayout>(id.fragmentContainer) != null){
      addFragment(MainFragment())
    }

  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.toolbar_menu, menu)
    return super.onCreateOptionsMenu(menu)
  }

  private fun addFragment(fragment: Fragment) {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    val mainFragment = MainFragment()
    fragmentTransaction.add(id.fragmentContainer, mainFragment)
      .addToBackStack(fragment.javaClass.name)
    fragmentTransaction.commit()
  }

  fun replaceFragment(fragment: Fragment?) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    if (fragment != null) {
      fragmentTransaction.add(id.fragmentContainer, fragment).addToBackStack(fragmentTransaction.javaClass.name)
    }
      fragmentTransaction.commit()
  }


}