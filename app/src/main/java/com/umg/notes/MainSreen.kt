package com.umg.notes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.umg.notes.model.Note
import com.umg.notes.vm.NoteViewModel

@Composable
fun MainScreen(vm: NoteViewModel) {
    val notes by vm.notes.collectAsStateWithLifecycle()
    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Notas (Compose + MVVM)", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Escribe una nota") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {
                    vm.addNote(input)
                    input = ""
                }
            ) {
                Text("Agregar")
            }
        }

        Divider()

        if (notes.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Sin notas. Agrega la primera ")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(notes, key = { it.id }) { note ->
                    NoteItem(note = note, onDelete = { vm.removeNote(note.id) })
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, onDelete: () -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 1.dp,
        shadowElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = note.text,
                modifier = Modifier.weight(1f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.width(12.dp))
            OutlinedButton(onClick = { onDelete() }) {
                Text("Eliminar")
            }
        }
    }
}