package com.mmdev.progressbutton

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mmdev.progressbuttonlib.ProgressButton


/* Created by Andrii on 03.11.2019.*/

/**
 * This is the documentation block about the class
 */

class LoginActivity: AppCompatActivity(R.layout.activity_login){

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val progressButton = findViewById<ProgressButton>(R.id.login)

		progressButton.setOnClickListener {
			progressButton.startAnim()
			Handler().postDelayed({
				                      progressButton.stopAnim { startMainActivity() }
			                      }, 500)
		}
	}

	private fun startMainActivity(){
		val mainActivityIntent = Intent(this, MainActivity::class.java)
		startActivity(mainActivityIntent)
	}
}