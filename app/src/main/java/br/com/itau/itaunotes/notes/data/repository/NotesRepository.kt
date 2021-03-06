package br.com.itau.itaunotes.notes.data.repository

import br.com.itau.itaunotes.notes.data.datasoruce.DataBaseDataSourceContract
import br.com.itau.itaunotes.notes.data.model.Note

interface NotesRepositoryContract{
    suspend fun getAll(): List<Note>
    suspend fun loadById(id: Int): Note
    suspend fun insert(note: Note)
    suspend fun update(note: Note)
    suspend fun deleteAll()
    suspend fun deleteNote(note: Note)

}

class NotesRepository(
    private val dataSource: DataBaseDataSourceContract
): NotesRepositoryContract {

    override suspend fun getAll(): List<Note> {
        return dataSource.getAll()
    }

    override suspend fun loadById(id: Int): Note {
        return dataSource.loadById(id)
    }

    override suspend fun insert(note: Note) {
        dataSource.insertNote(note)    }

    override suspend fun update(note: Note) {
        dataSource.updateNote(note)
    }

    override suspend fun deleteAll() {
        dataSource.deleteAll()
    }

    override suspend fun deleteNote(note: Note) {
        dataSource.deleteNote(note)
    }
}