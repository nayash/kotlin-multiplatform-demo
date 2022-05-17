package com.outliers.kmmdemo.android.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.outliers.kmmdemo.android.R
import com.outliers.kmmdemo.shared.KmmSDK
import com.outliers.kmmdemo.shared.cache.DatabaseDriverFactory

class AddNote : AppCompatActivity() {

    lateinit var kmmSDK: KmmSDK
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_add_note)

        kmmSDK = KmmSDK(DatabaseDriverFactory(this))

        findViewById<Button>(R.id.btn_add).setOnClickListener {
            addNote()
            finish()
        }
    }

    fun addNote() {
        val title = findViewById<TextInputEditText>(R.id.edit_title).text.toString()
        val body = findViewById<TextInputEditText>(R.id.edit_body).text.toString()
        if (title.isNotEmpty()) {
            kmmSDK.insertNote(title, body)
            setResult(RESULT_OK)
        } else {
            setResult(RESULT_CANCELED)
        }
    }
}