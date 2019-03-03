package com.example.odetocode.vacantlandfinal

import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

class RecentlyAdded {
    var message:String=""
    var success:Boolean
    var code:Int
    var data:List<data>

    constructor(message:String,success:Boolean,code:Int,data:List<data>){
        this.message=message
        this.success=success
        this.code=code
        this.data=data
    }

    fun getmess():String{
        return message
    }
    fun gesucc():Boolean{
        return success
    }
    fun getcode():Int{
        return code
    }
    fun getdata():List<data>{
        return data
    }
}