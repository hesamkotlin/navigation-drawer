package com.example.navigationdrawer

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.example.navigationdrawer.features.InterActionViewModel
import com.example.navigationdrawer.features.list.ListFragment
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var drawerToggle: ActionBarDrawerToggle

    private lateinit var btnSwitchTheme: SwitchMaterial

    private val inteActionViewModel by viewModels<InterActionViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initUiComponents()
        setupToolbar()
        setupDrawerLayout()
        setupNavigationView()
        showListFragment()
    }

    private fun showListFragment() {
        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.fragment_container, ListFragment()).commit()
    }

    private fun initUiComponents() {
        btnSwitchTheme =
            mBinding.navigationView.menu.findItem(R.id.mi_night_mode).actionView as SwitchMaterial
        btnSwitchTheme.setOnCheckedChangeListener { _, isChecked ->
            var mode = when (isChecked) {
                true -> AppCompatDelegate.MODE_NIGHT_YES
                false -> AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(mode)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(mBinding.toolbar)
        //toDo : connect drawer layout to navigation component later
    }

    private fun setupDrawerLayout() {
        drawerToggle = ActionBarDrawerToggle(
            this,
            mBinding.drawerLayout,
            mBinding.toolbar,
            R.string.action_open_drawer,
            R.string.action_close_drawer
        )
        mBinding.drawerLayout.addDrawerListener(drawerToggle)
        //sync stat for shwoing humberger :D
        // when i delete this code humburger was shown : this is for back key on the action bar
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupNavigationView() {
        mBinding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {


            }


            mBinding.drawerLayout.closeDrawer(GravityCompat.START)


            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listfragment, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mi_list_view_type -> {
                inteActionViewModel.emitOnViewTypeChanged(
                    isLinear = (inteActionViewModel.onViewTypeChanged.value ?: true).not()

                )
            }
            R.id.mi_search -> {

            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START))
            mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        else {
            super.onBackPressed()
        }
    }
}