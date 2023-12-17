package com.example.uf1_proyecto.trip


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.FragmentTripBinding
import com.example.uf1_proyecto.databinding.ItemCityBinding
import com.example.uf1_proyecto.databinding.ItemCountryBinding
import com.example.uf1_proyecto.databinding.ItemTripBinding
import com.example.uf1_proyecto.where.countries.Country

class TripViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemTripBinding.bind(view)
    val view2 = view

    lateinit var mainActivity:MainActivity
    lateinit var fragment: TripFragment

    fun setActivity(mainActivity: MainActivity){
        this.mainActivity=mainActivity

    }

    fun setFragmento(fragment: TripFragment){
        this.fragment=fragment
    }
    fun render(tripModel: Trip){


        binding.tripName.text=mainActivity.tripName()+tripModel.name

        if(tripModel.dayStart!=-1) {
            val editableDayStart: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.dayStart.toString())
            binding.tripDayStart.text = editableDayStart
        }

        if(tripModel.monthStart!=-1) {
            val editableMonthStart: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.monthStart.toString())
            binding.tripMonthStart.text = editableMonthStart
        }

        if(tripModel.yearStart!=-1) {
            val editableYearStart: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.yearStart.toString())
            binding.tripYearStart.text = editableYearStart
        }

        if(tripModel.dayEnd!=-1) {
            val editableDayEnd: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.dayEnd.toString())
            binding.tripDayEnd.text = editableDayEnd
        }
        if(tripModel.monthEnd!=-1) {
            val editableMonthEnd: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.monthEnd.toString())
            binding.tripMonthEnd.text = editableMonthEnd
        }
        if(tripModel.yearEnd!=-1) {
            val editableYearEnd: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.yearEnd.toString())
            binding.tripYearEnd.text = editableYearEnd
        }

        if(tripModel.transport==1){
            binding.groupTransport.check(binding.radioPlane.id)
        }
        if(tripModel.transport==2){
            binding.groupTransport.check(binding.radioTrain.id)
        }
        if(tripModel.transport==3){
            binding.groupTransport.check(binding.radioBus.id)
        }
        if(tripModel.transport==4){
            binding.groupTransport.check(binding.radioBoat.id)
        }

        if(tripModel.stay!=""){
            val editableStay: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.stay.toString())
            binding.stayEditText.text= editableStay
        }

        if(tripModel.selected1Activity==1){
            binding.groupActivities1.isChecked=true
        }
        if(tripModel.selected2Activity==1){
            binding.groupActivities2.isChecked=true
        }
        if(tripModel.selected3Activity==1){
            binding.groupActivities3.isChecked=true
        }
        if(tripModel.selected4Activity==1){
            binding.groupActivities4.isChecked=true
        }
        if(tripModel.selected5Activity==1){
            binding.groupActivities5.isChecked=true
        }
        if(tripModel.selected6Activity==1){
            binding.groupActivities6.isChecked=true
        }

        if(tripModel.notes!=""){
            val editableNotes: Editable =
                Editable.Factory.getInstance().newEditable(tripModel.notes.toString())
            binding.notesEditText.text= editableNotes
        }

        var actividades = tripModel.activities
        if (actividades != null) {
            binding.groupActivities1.text= actividades[0]
            binding.groupActivities2.text= actividades[1]
            binding.groupActivities3.text= actividades[2]
            binding.groupActivities4.text= actividades[3]
            binding.groupActivities5.text= actividades[4]
            binding.groupActivities6.text= actividades[5]
        }
        Glide.with(binding.cityImage.context).load(tripModel.photo).into(binding.cityImage)

        //BORRAR
        binding.eraseButton.setOnClickListener {
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()

            var numTrips = sharedPreferences.getInt("numTrips", 0)
            numTrips = numTrips - 1
            editor.putInt("numTrips", numTrips)//xa que se eliminou un trip

            val id = tripModel.id

            editor.remove("name$id")
            editor.remove("photo$id")
            for (activityIndex in 1..6) {
                val actividade = "$activityIndex" + "activities"
                editor.remove("$actividade$id")
            }
            editor.remove("selectedActivity$id")
            editor.remove("dayStart$id")
            editor.remove("monthStart$id")
            editor.remove("yearStart$id")
            editor.remove("dayEnd$id")
            editor.remove("monthEnd$id")
            editor.remove("yearEnd$id")
            editor.remove("transport$id")
            editor.remove("stay$id")
            editor.remove("notes$id")

            editor.apply()

            //Ocultamos os elementos sen que ocupen espazo mentras non recargamos o fragmento

            for (i in 0 until binding.root.childCount) {
                binding.root.getChildAt(i).visibility = View.GONE
            }

            //se se borraron todos aparece mensaxe
            fragment.showMessageNoTrips(mainActivity)


        }
        //DIA DE INICIO CAMBIO
        binding.tripDayStart.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripDayStart= binding.tripDayStart.text.toString().toIntOrNull()
                if(tripDayStart!=null) {
                    editor.putInt("dayStart$id", tripDayStart)
                    editor.apply()
                }else{
                    editor.putInt("dayStart$id", -1)
                    editor.apply()
                }
            }
        })


        //MES DE INICIO CAMBIO
        binding.tripMonthStart.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripMonthStart= binding.tripMonthStart.text.toString().toIntOrNull()
                if(tripMonthStart!=null) {
                    editor.putInt("monthStart$id", tripMonthStart)
                    editor.apply()
                }else{
                    editor.putInt("monthStart$id", -1)
                    editor.apply()
                }
            }
        })

        //ANO DE INICIO CAMBIO
        binding.tripYearStart.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripYearStart= binding.tripYearStart.text.toString().toIntOrNull()
                if(tripYearStart!=null) {
                    editor.putInt("yearStart$id", tripYearStart)
                    editor.apply()
                }else{
                    editor.putInt("yearStart$id", -1)
                    editor.apply()
                }
            }
        })

        //DIA FINAL CAMBIO
        binding.tripDayEnd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripDayEnd= binding.tripDayEnd.text.toString().toIntOrNull()
                if(tripDayEnd!=null) {
                    editor.putInt("dayEnd$id", tripDayEnd)
                    editor.apply()
                }else{
                    editor.putInt("dayEnd$id", -1)
                    editor.apply()
                }
            }
        })

        //MES FINAL CAMBIO
        binding.tripMonthEnd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripMonthEnd= binding.tripMonthEnd.text.toString().toIntOrNull()
                if(tripMonthEnd!=null) {
                    editor.putInt("monthEnd$id", tripMonthEnd)
                    editor.apply()
                }else{
                    editor.putInt("monthEnd$id", -1)
                    editor.apply()
                }
            }
        })

        //MES FINAL CAMBIO
        binding.tripYearEnd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripYearEnd= binding.tripYearEnd.text.toString().toIntOrNull()
                if(tripYearEnd!=null) {
                    editor.putInt("yearEnd$id", tripYearEnd)
                    editor.apply()
                }else{
                    editor.putInt("yearEnd$id", -1)
                    editor.apply()
                }
            }
        })

        //MODIFICAR TRANSPORTE SELECCIONADO
        binding.groupTransport.setOnCheckedChangeListener { group, checkedId ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            when (checkedId) {
                R.id.radio_plane -> {
                    editor.putInt("transport$id", 1)
                    editor.apply()
                }
                R.id.radio_train -> {
                    editor.putInt("transport$id", 2)
                    editor.apply()
                }
                R.id.radio_bus -> {
                    editor.putInt("transport$id", 3)
                    editor.apply()
                }
                R.id.radio_boat -> {
                    editor.putInt("transport$id", 4)
                    editor.apply()
                }
            }
        }

        //MODIFICAR ESTANCIA
        binding.stayEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripStay= binding.stayEditText.text.toString()
                if(tripStay!="") {
                    editor.putString("stay$id", tripStay)
                    editor.apply()
                }else{
                    editor.putString("stay$id", "")
                    editor.apply()
                }
            }
        })

        //PRIMEIRA ACTIVIDADE LISTENER
        binding.groupActivities1.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            if (isChecked) {
                editor.putInt("selected1Activity$id", 1)
                editor.apply()

            } else {
                editor.putInt("selected1Activity$id", -1)
                editor.apply()
            }
        }

        //SEGUNDA ACTIVIDADE LISTENER
        binding.groupActivities2.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            if (isChecked) {
                editor.putInt("selected2Activity$id", 1)
                editor.apply()

            } else {
                editor.putInt("selected2Activity$id", -1)
                editor.apply()
            }
        }

        //TERCEIRA ACTIVIDADE LISTENER
        binding.groupActivities3.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            if (isChecked) {
                editor.putInt("selected3Activity$id", 1)
                editor.apply()

            } else {
                editor.putInt("selected3Activity$id", -1)
                editor.apply()
            }
        }
        //CUARTA ACTIVIDADE LISTENER
        binding.groupActivities4.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            if (isChecked) {
                editor.putInt("selected4Activity$id", 1)
                editor.apply()

            } else {
                editor.putInt("selected4Activity$id", -1)
                editor.apply()
            }
        }
        //QUINTA ACTIVIDADE LISTENER
        binding.groupActivities5.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            if (isChecked) {
                editor.putInt("selected5Activity$id", 1)
                editor.apply()

            } else {
                editor.putInt("selected5Activity$id", -1)
                editor.apply()
            }
        }
        //SEXTA ACTIVIDADE LISTENER
        binding.groupActivities6.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()
            val id = tripModel.id

            if (isChecked) {
                editor.putInt("selected6Activity$id", 1)
                editor.apply()

            } else {
                editor.putInt("selected6Activity$id", -1)
                editor.apply()
            }
        }

        //MODIFICAR NOTAS
        binding.notesEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                //antes de que o texto cambie
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                //cando o texto cambia
            }

            override fun afterTextChanged(editable: Editable?) {
                //despois de que o texto cambie
                val sharedPreferences = MainActivity.sharedPreferences!!
                val editor = sharedPreferences.edit()

                val id = tripModel.id

                val tripNotes= binding.notesEditText.text.toString()
                if(tripNotes!="") {
                    editor.putString("notes$id", tripNotes)
                    editor.apply()
                }else{
                    editor.putString("notes$id", "")
                    editor.apply()
                }
            }
        })

    }
}