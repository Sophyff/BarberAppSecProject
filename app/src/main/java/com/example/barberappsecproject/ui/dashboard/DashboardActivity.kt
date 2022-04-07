package com.example.barberappsecproject.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import com.example.barberappsecproject.R
import com.example.barberappsecproject.databinding.ActivityDashboardBinding
import com.example.barberappsecproject.databinding.ActivityMainBinding
import com.example.barberappsecproject.ui.book.BookAppointmentActivity
import com.example.barberappsecproject.ui.login.LoginActivity
import com.example.barberappsecproject.ui.services.OurServicesActivity

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    lateinit var headerView: View
    lateinit var ivPhoto: ImageView
    lateinit var tvUsername: TextView
    lateinit var tvMobile: TextView
    var isLogged=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        setDrawView()
        binding.navView.setNavigationItemSelectedListener {
            handleNavigationOperation(it)
            true
        }

    }

    private fun setDrawView(){
        val pref = getSharedPreferences("User", MODE_PRIVATE)
        val userName=pref.getString("name","").toString()
        val mobile=pref.getString("mobile_no","").toString()
        val userId=pref.getString("user_id","")
        if(userId !="") isLogged=true

        headerView = binding.navView.getHeaderView(0)
        ivPhoto = headerView.findViewById(R.id.iv_photo)
        tvUsername = headerView.findViewById(R.id.tv_username)
        tvMobile = headerView.findViewById(R.id.tv_mobile)

        // tvUsername.setText(userName)
        ivPhoto.setImageDrawable(ContextCompat.getDrawable(baseContext, R.drawable.ic_profile))
        if(isLogged){
            tvUsername.text=userName
            tvMobile.text=mobile
            binding.navView.menu.clear()
            binding.navView.inflateMenu(R.menu.main_signed_menu)
        }else{
            binding.navView.menu.clear()
            binding.navView.inflateMenu(R.menu.main_signed_menu)
        }
    }

    private fun handleNavigationOperation(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.action_home -> {
                //todo
            }
            R.id.action_book ->{
                startActivity(Intent(this, BookAppointmentActivity::class.java))
            }

            R.id.action_service ->{
                startActivity(Intent(this, OurServicesActivity::class.java))
            }

            R.id.action_logout ->{
                val pref = getSharedPreferences("appsettings", MODE_PRIVATE)
                val editor = pref.edit()
                editor.clear()
                editor.commit()
                startActivity(Intent(baseContext, LoginActivity::class.java))
                finish()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        val searchViewItem: MenuItem = menu.findItem(R.id.app_bar_search)
        val searchView: SearchView = MenuItemCompat.getActionView(searchViewItem) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                //todo
                /*   if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }*/return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // adapter.getFilter().filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


}