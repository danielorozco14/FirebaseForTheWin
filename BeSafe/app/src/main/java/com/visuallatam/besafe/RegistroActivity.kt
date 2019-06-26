package com.visuallatam.besafe

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registrar.*

class RegistroActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        registra()
    }

    private fun registra() {

        button_registro.setOnClickListener {
            button_registro.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fadein))
            var mCorreoRegistro = correo_registro.text.toString()
            var mContraRegistro = contra_registro.text.toString()
            var mVerificar = contra_registro2.text.toString()
            if (mContraRegistro.isNotEmpty() && mCorreoRegistro.isNotEmpty() && mVerificar.isNotEmpty()) {
                if(mContraRegistro == mVerificar){
                mAuth.createUserWithEmailAndPassword(mCorreoRegistro, mContraRegistro).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        startActivity(Intent(this, BeSafe::class.java))
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        Toast.makeText(this, "Registro Completado", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Error registrandose", Toast.LENGTH_LONG).show()
                    }
                }}else{
                    Toast.makeText(this,"Su contraseña no es igual", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"Error, Rellene todos los campos",Toast.LENGTH_LONG).show()
            }
        }
    }
}
