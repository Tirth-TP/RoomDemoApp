package com.example.roomdemoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomdemoapp.dao.ContactDAO
import com.example.roomdemoapp.model.local.Contact
import com.example.roomdemoapp.utils.Convertors

/**
 * Created by Tirth Patel.
 */

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO


    companion object {

        val migration1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile
        private var INSTANCE: ContactDataBase? = null


        fun getDatabase(context: Context): ContactDataBase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDataBase::class.java,
                        "contactDB"
                    )
                        .addMigrations(migration1_2)
                        .build()
                }
            }

            return INSTANCE!!
        }
    }
}