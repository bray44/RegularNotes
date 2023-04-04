package com.example.regularnotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.regularnotes.room.ContactDatabase
import com.example.regularnotes.room.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application.applicationContext,
        ContactDatabase::class.java,
        "notes_database"
    )
        .build()
        .dao

    fun addNotes(title: String, content: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.addNotes(Notes(title = title, content = content))
        }
    }

    fun showAllNotes(): LiveData<List<Notes>> {
        return db.showAllNotes()
    }


}