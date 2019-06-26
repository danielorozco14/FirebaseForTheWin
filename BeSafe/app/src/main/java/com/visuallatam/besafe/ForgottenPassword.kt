package com.visuallatam.besafe

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotten_password.*


class ForgottenPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotten_password)

        send_forgotten.setOnClickListener {
            if (correo_forgotten.text.toString().isNotEmpty()) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(correo_forgotten.text.toString()).addOnSuccessListener {
                    Toast.makeText(this ,"holi",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
                }
            }
        }
    }


}
