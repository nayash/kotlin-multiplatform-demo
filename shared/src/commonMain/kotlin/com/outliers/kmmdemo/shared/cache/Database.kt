package com.outliers.kmmdemo.shared.cache

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = KmmDemoDB(databaseDriverFactory.createDriver())
    private val dbQuery = database.kmmDemoDBQueries

    internal fun getAllNotes(): List<Note> {
        return dbQuery.selectAllNotes().executeAsList()
    }

    internal fun getLastNote(): Note {
        return dbQuery.selectLastNote().executeAsOne()
    }

    internal fun insertNote(title: String, body: String?) {
        return dbQuery.insertNote(title, body)
    }
}