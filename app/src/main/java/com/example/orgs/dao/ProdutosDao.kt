package com.example.orgs.dao

import com.example.orgs.ui.orgs.model.Produto
import java.math.BigDecimal

class ProdutosDao {

    fun add(produtos: Produto){
        produto.add(produtos)
    }

    fun getAll(): List<Produto> = produto.toList()

    companion object {
        val produto = mutableListOf<Produto>(
            Produto(
                nome = "Salada de frutas",
                descricao = "Banana, Maça e Morango",
                valor = BigDecimal("19.99")
            )
        )
    }
}