package com.dcs.productivityapp.Controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.dcs.productivityapp.Activities.UpdateAndDelete
import com.dcs.productivityapp.Model.ToDoModel
import com.dcs.productivityapp.R

class ToDoAdapter(context: Context,toDoList:MutableList<ToDoModel>) : BaseAdapter() {


















}
private class ListViewHolder(row:View?) {
    val textLabel: TextView=row!!.findViewById(R.id.item_textView) as TextView
    val isDone: CheckBox =row!!.findViewById(R.id.checkbox) as CheckBox
    val isDeleted:ImageButton=row!!.findViewById(R.id.close) as ImageButton
}




