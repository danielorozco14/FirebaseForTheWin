package com.visuallatam.besafe.adapters.firestoreAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.visuallatam.besafe.R
import com.visuallatam.besafe.data.entities.Users
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.visuallatam.besafe.data.entities.Reportes


class FirestoreReportesAdapter internal constructor(options: FirestoreRecyclerOptions<Reportes>):
    FirestoreRecyclerAdapter<Reportes, FirestoreReportesAdapter.ReportesViewHolder>(options) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportesViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.cv_form_list_item,parent,false)
        return ReportesViewHolder(view)
    }

    override fun onBindViewHolder(p0: ReportesViewHolder, p1: Int, p2: Reportes) {
        p0.setUsersData(p2.nombre)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }


    inner class ReportesViewHolder internal constructor(private val view: View):RecyclerView.ViewHolder(view){
        internal fun setUsersData(nombre:String){
            val textView1= view.findViewById<TextView>(R.id.dummyyy1)
            textView1.text=nombre
        }

    }
}

