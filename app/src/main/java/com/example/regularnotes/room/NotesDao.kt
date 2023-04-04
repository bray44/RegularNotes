package com.example.regularnotes.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert
    suspend fun addNotes(notes: Notes)

    @Query ("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNotes(id: Int)

    @Query ("UPDATE notes SET title = :title, content = :content WHERE id = :id")
    suspend fun updateNotes(id: Int, title: String, content: String)

    @Query("SELECT * FROM notes")
    fun showAllNotes(): LiveData<List<Notes>>

}