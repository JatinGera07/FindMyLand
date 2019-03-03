package com.example.odetocode.vacantlandfinal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main2.*
import android.preference.PreferenceManager;
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences


class Main2Activity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseUser: FirebaseUser
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        firebaseAuth= FirebaseAuth.getInstance()
   logIn_button.setOnClickListener{
       var pass=password_EditText.text.toString()   //min 6 characters
       var ema=mail_EditText.text.toString()     //must contain@ and .com  //these comments are needed to be tested by us, fire base throws an exception if any of the above is not satisfied.
       firebaseAuth.signInWithEmailAndPassword(ema,pass)
               .addOnCompleteListener (this){
                   task ->
                   if(task.isSuccessful){
                       val settings = PreferenceManager.getDefaultSharedPreferences(applicationContext)
                       val editor = settings.edit()
                       editor.putString("username",ema)
                       val ctx = applicationContext
                       val sharedPreferences = ctx.getSharedPreferences("n1", Context.MODE_PRIVATE)
                       val editor1 = sharedPreferences.edit()
                       editor1.putInt("n2", 1)
                       editor1.commit()
                       var inte= Intent(this,MainActivity::class.java)
                       startActivity(inte)

                   }
                   else{
                       Log.w("splash","exception",task.exception)
                       Toast.makeText(this,"authentication failed", Toast.LENGTH_LONG).show()
                   }
               }
   }
        signUp_link.setOnClickListener {
            var inte = Intent(this,Main3Activity::class.java)
            startActivity(inte)




        }
    }
}
