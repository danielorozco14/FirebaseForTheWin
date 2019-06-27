package com.visuallatam.besafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.besafe.fragments.opcionesFragment
import com.google.android.material.snackbar.Snackbar
import com.visuallatam.besafe.fragments.AfterLoginFragment

class AllReportsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)

        showFragment()
        val fab: View = findViewById(R.id.FAB1)
        fab.setOnClickListener { view ->
            var newOpcionesFragment=opcionesFragment()
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.after_login_main_place_holder,newOpcionesFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }


    fun showFragment(){

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment = AfterLoginFragment()
        transaction.add(R.id.after_login_main_place_holder, fragment)
        transaction.commit()

    }
}
