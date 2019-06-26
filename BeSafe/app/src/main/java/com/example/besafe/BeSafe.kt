package com.example.besafe

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home.*

class BeSafe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        database()
    }


    fun database(){
        var db = FirebaseFirestore.getInstance()
        //TODO:AGREGANDO DATOS A FIRESTORE

        var palabra = db.collection("test")//REFERENCIA A LA COLECCION EN FIRESTORES


        boton_enviar.setOnClickListener {
            boton_enviar.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fadein))
            var test:Map<String,Any> = mapOf(("word" to "Hola"))
            //val myMap = mapOf<String,Object>("word" to test)
            palabra.add(test)
        }





    }

}
