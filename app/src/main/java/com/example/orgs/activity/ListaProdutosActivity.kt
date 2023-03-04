package com.example.orgs.activity

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.adapter.ListaProdutosAdapter
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.databinding.ActivityListaProdutosBinding

class ListaProdutosActivity : AppCompatActivity() {

    val dao = ProdutosDao()
    val adapter =  ListaProdutosAdapter(
        context = this,
        produtos = dao.getAll()
    )

    private lateinit var binding: ActivityListaProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()

        AlertDialog.Builder(this)
            .setTitle("Titulo para teste")
            .setMessage("mensagem de teste")
            .setPositiveButton("Confirmar") { _, _ ->

            }
            .setNegativeButton("Cancelar") { _, _ ->

            }
            .show()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.getAll())
    }

    private fun configuraFab() {
        binding.fabAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        })
    }

    private fun configuraRecyclerView() {
        binding.itemProduct.adapter = adapter
    }
}