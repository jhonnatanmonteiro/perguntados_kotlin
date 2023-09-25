package com.perguntados.natansin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.View
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.widget.ViewSwitcher
import com.perguntados.natansin.databinding.ActivityMainBinding





class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countDownTimer: CountDownTimer




    private lateinit var questionTextSwitcher: TextSwitcher
    private lateinit var option1TextSwitcher: TextSwitcher
    private lateinit var option2TextSwitcher: TextSwitcher
    private lateinit var option3TextSwitcher: TextSwitcher
    private lateinit var option4TextSwitcher: TextSwitcher

    private var currentQuestionIndex = 0
    private var numRespostasCorretas = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        // Inicialize TextSwitchers após o setContentView
        initializeTextSwitchers()
    }

    private fun initializeTextSwitchers() {
        questionTextSwitcher = binding.question
        option1TextSwitcher = binding.option1
        option2TextSwitcher = binding.option2
        option3TextSwitcher = binding.option3
        option4TextSwitcher = binding.option4

        option1TextSwitcher.setOnClickListener {
            checkUserAnswer(0) // Verifica a resposta quando a opção 1 é clicada
        }
        option2TextSwitcher.setOnClickListener {
            checkUserAnswer(1) // Verifica a resposta quando a opção 2 é clicada
        }
        option3TextSwitcher.setOnClickListener {
            checkUserAnswer(2) // Verifica a resposta quando a opção 3 é clicada
        }
        option4TextSwitcher.setOnClickListener {
            checkUserAnswer(3) // Verifica a resposta quando a opção 4 é clicada
        }

        questionTextSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.setTextColor(Color.BLACK)
            textView.gravity = Gravity.CENTER
            textView
        }

        option1TextSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.setTextColor(Color.BLACK)
            textView.gravity = Gravity.CENTER
            textView
        }

        option2TextSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.setTextColor(Color.BLACK)
            textView.gravity = Gravity.CENTER
            textView
        }
        option3TextSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.setTextColor(Color.BLACK)
            textView.gravity = Gravity.CENTER
            textView
        }
        option4TextSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 18f
            textView.setTextColor(Color.BLACK)
            textView.gravity = Gravity.CENTER
            textView
        }



        // Configurar o temporizador para 30 segundos
        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Atualizar o temporizador a cada segundo (você pode mostrar o tempo restante na interface do usuário)
                val secondsRemaining = millisUntilFinished / 1000
                // Atualize a interface do usuário com o tempo restante (por exemplo, usando um TextView)
                binding.timer.text = secondsRemaining.toString()
            }

            override fun onFinish() {
                // O temporizador chegou a zero, ação apropriada aqui (por exemplo, considerar a resposta como incorreta)

                // Verifique se a pergunta atual não é a última pergunta
                if (currentQuestionIndex < ListaPergunta.size - 1) {
                    currentQuestionIndex++
                    val nextQuestion = ListaPergunta[currentQuestionIndex]
                    updateQuestionAndOptions(nextQuestion)
                } else {
                    // Todas as perguntas foram respondidas, mostre o diálogo de resultado
                    showResultadoDialog()
                }
            }

        }

        // Inicialize o TextSwitcher com o texto da primeira pergunta
        questionTextSwitcher.setText(ListaPergunta[currentQuestionIndex].questionText)
        val currentQuestion = ListaPergunta[currentQuestionIndex]
        updateQuestionAndOptions(currentQuestion)




        startTimer()


    }

    // Quando o usuário seleciona uma resposta (por exemplo, em um botão de resposta)
    fun checkUserAnswer(userAnswerIndex: Int) {
        val currentQuestion = ListaPergunta[currentQuestionIndex]

        if (userAnswerIndex == currentQuestion.correctAnswerIndex) {
            // A resposta do usuário está correta
            numRespostasCorretas++

            currentQuestionIndex++

            if (currentQuestionIndex < ListaPergunta.size) {
                // Exiba a próxima pergunta
                val nextQuestion = ListaPergunta[currentQuestionIndex]
                // Atualize a interface do usuário com a próxima pergunta
                updateQuestionAndOptions(nextQuestion)
            } else {
                // O quiz acabou, todas as perguntas foram respondidas
                showResultadoDialog()
            }
        } else {
            // A resposta do usuário está incorreta, vá para a próxima pergunta
            currentQuestionIndex++

            if (currentQuestionIndex < ListaPergunta.size) {
                // Exiba a próxima pergunta
                val nextQuestion = ListaPergunta[currentQuestionIndex]
                // Atualize a interface do usuário com a próxima pergunta
                updateQuestionAndOptions(nextQuestion)
            } else {
                // O quiz acabou, todas as perguntas foram respondidas
                showResultadoDialog()
            }
        }
    }






    private fun updateQuestionAndOptions(question: Perguntas) {
        // Atualize os TextSwitchers com as próximas perguntas e opções de resposta
        questionTextSwitcher.setText(question.questionText)
        option1TextSwitcher.setText(question.options[0])
        option2TextSwitcher.setText(question.options[1])
        option3TextSwitcher.setText(question.options[2])
        option4TextSwitcher.setText(question.options[3])




        startTimer()
    }




    private fun startTimer() {
        countDownTimer.start()
    }

    private fun showResultadoDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Resultado")
        builder.setMessage("Você acertou $numRespostasCorretas de ${ListaPergunta.size} perguntas.")

        builder.setPositiveButton("Recomeçar") { _, _ ->
            // Reinicie o quiz
            currentQuestionIndex = 0
            numRespostasCorretas = 0
            val firstQuestion = ListaPergunta[currentQuestionIndex]
            updateQuestionAndOptions(firstQuestion)
        }

        builder.setNegativeButton("Sair") { _, _ ->
            finish()
        }

        builder.show()
    }



}
