package com.example.regularnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.regularnotes.databinding.ActivityMainBinding
import com.example.regularnotes.room.NoteInputActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[ViewModel::class.java]

        val notesAdapter = NotesRowAdapter()

        binding.rvShowNotes.adapter = notesAdapter
        binding.rvShowNotes.layoutManager = LinearLayoutManager(this)

        mViewModel.showAllNotes().observe(this) {
            value -> notesAdapter.setData(value)
        }

        binding.btnAddNotes.setOnClickListener {
            startActivity(Intent(this, NoteInputActivity::class.java))
        }


    }
}