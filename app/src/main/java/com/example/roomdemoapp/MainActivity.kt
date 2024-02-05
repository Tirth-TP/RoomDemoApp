package com.example.roomdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdemoapp.database.ContactDataBase
import com.example.roomdemoapp.model.local.Contact
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var contactDataBase: ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactDataBase = ContactDataBase.getDatabase(this)

        GlobalScope.launch {
            contactDataBase.contactDao().insertContact(Contact(0, "hekko", "99999", Date(), 1))
        }
    }
}