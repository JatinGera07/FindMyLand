package com.example.odetocode.vacantlandfinal

class listDatatype {

    var image1: Int = 0
    var title: String? = null
    var desc: String? = null
    var id1:String?=null
    constructor(image: Int, title: String, desc: String,id1:String) {
        this.image1   = image
        this.title = title
        this.desc = desc
        this.id1=id1
    }

    constructor(title: String, desc: String,id1:String) {
        this.title = title
        this.desc = desc
        this.id1=id1
    }

fun getimage():Int{
    return image1
}
    fun gettitle():String{
        return title.toString()
    }
    fun getdescription():String{
        return desc.toString()
    }
    fun getid1():String{
        return id1.toString()
    }
  }


