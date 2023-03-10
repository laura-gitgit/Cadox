package com.example.cadox.ui.articleView

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.cadox.ArticleViewFragment
import com.example.cadox.R
import com.example.cadox.databinding.ActivityArticleViewBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class ArticleViewActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aavb: ActivityArticleViewBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_article_view)
        Toast.makeText(
            this,
            ArticleRepository.getArticle(1).toString(),
            Toast.LENGTH_LONG
        ).show()

        aavb.article = ArticleRepository.getArticle(1)

        if (aavb.article == null) Snackbar.make(
            aavb.textViewIntitule,
            "Article Indisponible",
            12
        ).show()
        else {
            aavb.imageButtonInternet.setOnClickListener {
                Snackbar.make(
                    aavb.root,
                    aavb.article?.url ?: "Pas d'URL",
                    1200
                ).show()
            }
        }

        aavb.imageButtonEdit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmer la modification : ")
            builder.setMessage("Etes vous sûr de vouloir modifier cet article?")
            builder.setPositiveButton("Oui") { _, _ ->
                val intent = Intent(this, ArticleViewFragment::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("Non") { dialog, _ ->
                dialog.cancel()
            }
            builder.show()
        }

        aavb.imageButtonSMS.setOnClickListener {
            val snackbar =
                Snackbar.make(aavb.imageButtonSMS, "Voulez-vous vraiment envoyer le SMS ?", 1200)
            snackbar.setAction("Oui") {
                snackbar.setText("Message envoyé")
            }
            snackbar.show()
        }

        aavb.checkBoxIsBought.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) {
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                aavb.textViewDate.text = LocalDate.now().format(formatter).toString()
                aavb.textViewDate.visibility = View.VISIBLE
            } else {
                aavb.textViewDate.text = null
                aavb.textViewDate.visibility = View.INVISIBLE
            }
        }
    }
}