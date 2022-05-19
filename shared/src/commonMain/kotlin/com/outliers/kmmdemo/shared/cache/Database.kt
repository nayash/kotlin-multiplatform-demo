package com.outliers.kmmdemo.shared.cache

class Database(databaseDriverFactory: DatabaseDriverFactory) {
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

    internal fun deleteAll() {
        return dbQuery.deleteAll()
    }
}