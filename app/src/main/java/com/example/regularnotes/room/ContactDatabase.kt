package com.example.regularnotes.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Notes::class],  version = 1 )
abstract class ContactDatabase: RoomDatabase() {

    abstract val dao: NotesDao

}