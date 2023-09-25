package com.perguntados.natansin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View

class animSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_splash)
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

        // Crie um objeto Handler
        val handler = Handler()

        // Defina um atraso de 3 segundos (3000 milissegundos)
        val delayMillis: Long = 3000

        // Poste uma tarefa no Handler para iniciar a nova Activity após o atraso
        handler.postDelayed({
            // Crie um Intent para abrir a nova Activity
            val intent = Intent(this, MainActivity::class.java)

            // Inicie a nova Activity
            startActivity(intent)

            // Certifique-se de fechar a Activity atual se desejar
            finish()
        }, delayMillis)
    }
}