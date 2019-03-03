package com.example.odetocode.vacantlandfinal
class data {
   var id:String
    var Area:String
    var Name:String
    var Location:String
    var Cost:String
    var Image:String
    var createdAt:String
    var updatedAt:String
    var image_list:List<String>
    constructor(id:String,Area:String,Name:String,Location:String,Cost:String,Image:String,createdAt:String,updatedAt:String,image_list:List<String>){
        this.id=id
        this.Area=Area
        this.Name=Name
        this.Location=Location
        this.Cost=Cost
        this.Image=Image
        this.createdAt=createdAt
        this.updatedAt=updatedAt
        this.image_list=image_list
    }
   fun getid():String{

        return id
    }
   fun getarea():String
    {
        return Area
    }
    fun getname():String
    {
        return Name
    }
    fun getloc():String
    {
        return Location
    }
    fun getcost():String
    {
        return Cost
    }
    fun getim():String
    {
        return Image
    }
    fun getcreate():String
    {
        return createdAt
    }
    fun getupd():String
    {
        return updatedAt
    }
fun getimagelist():List<String>{
    return image_list
}
}