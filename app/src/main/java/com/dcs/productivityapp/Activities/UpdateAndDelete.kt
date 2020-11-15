package com.dcs.productivityapp.Activities

interface UpdateAndDelete{

    fun modifyItem(itemUID :String, isDone :Boolean )
    fun onItemDelete(itemUID: String)
}