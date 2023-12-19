package net.mundotela.exerciciosaula7.exercicios.A07ex07

import net.mundotela.exerciciosaula7.MinhasImages

class Produto(val foto: String = "", val titulo: String = "", val descricao: String = "") {

}

fun criarProdutos(): ArrayList<Produto> {
    val produtos = ArrayList<Produto>()
    produtos.add(Produto(MinhasImages(1).getUrl(), "Celular", "Celular de ultimo tipo"))
    produtos.add(Produto(MinhasImages(2).getUrl(), "titulo2", "descricao2"))
    produtos.add(Produto(MinhasImages(3).getUrl(), "titulo3", "descricao3"))
    produtos.add(Produto(MinhasImages(4).getUrl(), "titulo4", "descricao4"))
    produtos.add(Produto(MinhasImages(5).getUrl(), "titulo5", "descricao5"))
    return produtos
}