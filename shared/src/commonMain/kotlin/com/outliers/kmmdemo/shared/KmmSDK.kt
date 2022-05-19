package com.outliers.kmmdemo.shared

import com.outliers.kmmdemo.shared.cache.Database
import com.outliers.kmmdemo.shared.cache.DatabaseDriverFactory
import com.outliers.kmmdemo.shared.cache.Note

class KmmSDK(dbDriverFactory: DatabaseDriverFactory) {
    private val database: Database = Database(dbDriverFactory)

    fun getAllNotes(): List<Note> {
        return database.getAllNotes()
    }

    fun getLastNote(): Note {
        return database.getLastNote()
    }

    fun insertNote(title: String, body: String?) {
        database.insertNote(title, body)
    }

    fun deleteAll() {
        database.deleteAll()
    }
}