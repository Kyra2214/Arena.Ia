package br.com.kyra2214.arenaia

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val arenaUrl = "https://arena.ai/text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(16, 18, 27)
        window.navigationBarColor = Color.rgb(16, 18, 27)
        window.decorView.systemUiVisibility = 0
        setContentView(createHome())
    }

    private fun createHome(): View {
        val background = Color.rgb(16, 18, 27)
        val accent = Color.rgb(129, 112, 255)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(dp(28), dp(32), dp(28), dp(32))
            setBackgroundColor(background)
        }

        val mark = TextView(this).apply {
            text = "A"
            textSize = 34f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            typeface = Typeface.DEFAULT_BOLD
            background = rounded(accent, 22)
            layoutParams = LinearLayout.LayoutParams(dp(76), dp(76)).apply {
                bottomMargin = dp(24)
            }
        }
        root.addView(mark)

        root.addView(TextView(this).apply {
            text = "Arena IA"
            textSize = 30f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        })

        root.addView(TextView(this).apply {
            text = "Seus modelos de IA, em um só atalho."
            textSize = 15f
            setTextColor(Color.rgb(185, 189, 205))
            gravity = Gravity.CENTER
            setPadding(0, dp(10), 0, dp(30))
        })

        root.addView(Button(this).apply {
            text = "Abrir Arena Text"
            textSize = 16f
            isAllCaps = false
            setTextColor(Color.WHITE)
            background = rounded(accent, 16)
            setOnClickListener { openArena() }
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(54)
            )
        })

        root.addView(TextView(this).apply {
            text = "O Arena será aberto no navegador padrão para manter a compatibilidade com login, cookies e recursos do site."
            textSize = 13f
            setTextColor(Color.rgb(150, 155, 174))
            gravity = Gravity.CENTER
            setPadding(dp(4), dp(22), dp(4), 0)
        })

        root.addView(TextView(this).apply {
            text = "Uso pessoal • Acesso ao serviço oficial"
            textSize = 12f
            setTextColor(Color.rgb(120, 125, 145))
            gravity = Gravity.CENTER
            setPadding(0, dp(30), 0, 0)
        })

        return root
    }

    private fun openArena() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(arenaUrl))
        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            AlertDialog.Builder(this)
                .setTitle("Nenhum navegador encontrado")
                .setMessage("Instale ou habilite um navegador para abrir arena.ai/text.")
                .setPositiveButton("OK", null)
                .show()
        }
    }

    private fun rounded(color: Int, radiusDp: Int) = GradientDrawable().apply {
        setColor(color)
        cornerRadius = dp(radiusDp).toFloat()
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()
}
