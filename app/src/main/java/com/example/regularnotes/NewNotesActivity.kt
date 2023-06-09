package com.example.regularnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.regularnotes.databinding.ActivityNoteInputBinding

class NewNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteInputBinding
    private lateinit var mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[ViewModel::class.java]



        binding.btnSaveNote.setOnClickListener {
            val noteTitle = binding.etNoteTitle.text.toString()
            val noteContent = binding.etNoteContent.text.toString()
            mViewModel.addNotes(title = noteTitle, content = noteContent)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }



    }
}