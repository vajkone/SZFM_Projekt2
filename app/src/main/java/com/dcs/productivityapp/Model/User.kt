package com.dcs.productivityapp.Model

class User {
    var name:String?=null
    var email:String?=null
    var age:String?=null
    var password:String?=null

    constructor(name: String,email:String,age:String,password:String){
        this.name=name
        this.email=email
        this.age=age
        this.password=password
    }
}