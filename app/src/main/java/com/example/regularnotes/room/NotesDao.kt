package com.example.regularnotes.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert
    suspend fun addNotes(notes: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Query("SELECT * FROM notes")
    fun showAllNotes(): LiveData<List<Notes>>

}