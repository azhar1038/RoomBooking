package com.learn.az.roombooking.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [MeetingRoom::class], version = 2, exportSchema = false)
abstract class MeetingRoomDatabase: RoomDatabase() {
    abstract val meetingRoomDatabaseDao: MeetingRoomDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: MeetingRoomDatabase? = null

        fun getInstance(context: Context): MeetingRoomDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MeetingRoomDatabase::class.java,
                        "Rooms"
                    )
                        .fallbackToDestructiveMigration()
//                        .addCallback(object: RoomDatabase.Callback() {
//                            override fun onCreate(db: SupportSQLiteDatabase) = db.run{
//                                beginTransaction()
//                                try{
//                                    execSQL("INSERT INTO Rooms VALUES(1001,'Tech Master', 'Techno Park', 'Floor 2', 20, 1, 1, 0, 1, 0, 1);")
//                                    execSQL("INSERT INTO Rooms VALUES(1002,'Agile Room', 'Techno Park', 'Floor 1', 50, 1, 1, 1, 1, 1, 1);")
//                                    execSQL("INSERT INTO Rooms VALUES(1003,'Scrum Room', 'Info Park', 'Floor 6', 30, 1, 1, 1, 1, 1, 1);")
//                                }catch(e: Exception){
//
//                                }
//                            }
//                        })
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}