package com.example.orgs.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.databinding.ActivityFormularioProdutoBinding
import com.example.orgs.ui.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botaoSalvar = findViewById<Button>(R.id.button_salvar)
        botaoSalvar.setOnClickListener(View.OnClickListener {
            val (nome, descricao, valor) = criaProduto()

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            val dao = ProdutosDao()
            dao.add(produtoNovo)

            finish()
        })


    }

    private fun criaProduto(): Triple<String, String, BigDecimal> {
        val nome = binding.edittextNome.text.toString()
        val descricao = binding.edittextDescricao.text.toString()
        val valorEmTexto = binding.edittextValor.text.toString()

        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }
        return Triple(nome, descricao, valor)
    }
}