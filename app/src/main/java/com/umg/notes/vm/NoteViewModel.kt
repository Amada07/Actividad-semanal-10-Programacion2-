package com.umg.notes.vm

import androidx.lifecycle.ViewModel
import com.umg.notes.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.util.concurrent.atomic.AtomicLong



class NoteViewModel: ViewModel(){
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    private val seq = AtomicLong(0)

    fun addNote(text: String) {
        val t = text.trim()
        if (t.isEmpty()) return
        val newNote = Note(id = seq.incrementAndGet(), text = t)
        _notes.update { it + newNote }
    }

    fun removeNote(id: Long) {
        _notes.update { list -> list.filterNot { it.id == id } }
    }
}
