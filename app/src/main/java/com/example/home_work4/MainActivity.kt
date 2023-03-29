package com.example.home_work4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.home_work4.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        analytics = Firebase.analytics
binding.button.setOnClickListener {
    selectContentEvent("image1","ImageView","image")
}
        binding.button2.setOnClickListener {
            trackScreenEvent()
        }
    }
    fun  selectContentEvent(id:String,name:String,type:String){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){

            param(FirebaseAnalytics.Param.ITEM_ID,id)
            param(FirebaseAnalytics.Param.ITEM_NAME,name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE,type)
        }
    }
    fun  trackScreenEvent(){
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){

            param(FirebaseAnalytics.Param.SCREEN_NAME,"main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS,"MainActivity")
        }
    }

}