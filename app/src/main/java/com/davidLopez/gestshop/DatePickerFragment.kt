package com.davidLopez.gestshop

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

//https://www.youtube.com/watch?v=GOYIat0QC6A


//Le pasamos por parametro una funcion a la clase y le indicamos que extiende de DialogFragment

class DatePickerFragment (val listener: (dia:Int,mes:Int,year:Int)->Unit):DialogFragment()
                        , DatePickerDialog.OnDateSetListener{

    //sobreescribimos los metodos :

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // return super.onCreateDialog(savedInstanceState)   quitamos el super!!!!!!!

        val c:Calendar=Calendar.getInstance()//instanciamos la clase calendar que nos dara la fecha del dia.
        val dia:Int=c.get(Calendar.DAY_OF_MONTH)
        val mes:Int=c.get(Calendar.MONTH)
        val year:Int=c.get(Calendar.YEAR)

        val picker=DatePickerDialog(activity as Context,this,year,mes,dia)
        return picker

    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        listener(dayOfMonth,month,year)
    }

}