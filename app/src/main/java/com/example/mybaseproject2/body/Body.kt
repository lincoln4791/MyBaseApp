package com.example.mybaseproject2.body
import java.io.Serializable

class LoginBodyModel{
    var phone:String?=null
    var password:String?=null
    constructor(phone:String?,password:String?){
        this.phone=phone
        this.password=password
    }
}

class RegistrationBodyModel : Serializable {
    var name:String?=null
    //var gender:Int?=null
    var phone:String?=null
    var email:String?=null
    var password:String?=null
    var password_confirmation:String?=null
    var occupation:Int?=null
}