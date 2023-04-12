package com.example.regularnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.regularnotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickInterface {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[ViewModel::class.java]

        val notesAdapter = NotesRowAdapter(this)

        binding.rvShowNotes.adapter = notesAdapter
        binding.rvShowNotes.layoutManager = LinearLayoutManager(this)

        mViewModel.showAllNotes().observe(this) {
            value -> notesAdapter.setData(value)
        }

        binding.btnAddNotes.setOnClickListener {
            startActivity(Intent(this, NewNotesActivity::class.java))
        }


    }

    override fun createIntent(): Intent {
        return Intent(this, EditNotesActivity::class.java)
    }

    override fun goToActivity(intent: Intent) {
        startActivity(intent)
    }
}